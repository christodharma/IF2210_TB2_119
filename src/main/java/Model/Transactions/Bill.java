package Model.Transactions;

import Model.Memberships.CustomerCounter;
import Model.Product.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
public class Bill{
    //TODO?: Bill is data stored?
    private HashMap<Product, Integer> cart = new HashMap<>();
    public boolean addToCart(Product added, Integer amount) {
        if (added.subtractQuantity(amount) && amount > 0){
            if (cart.containsKey(added)){
                // cart contains same product
                cart.replace(added, cart.get(added)+amount);
            } else {
                cart.put(added, amount);
            }
            return true;
        } else {
            // barang tidak cukup, tidak dimasukkan ke keranjang
            return false;
        }
    }
    //TODO: test takeFromCart
    public boolean takeFromCart(Product taken, Integer amount) {
        if (cart.get(taken) >= amount && amount>=0) {
            taken.addQuantity(amount);
            cart.replace(taken, cart.get(taken)-amount);
            return true;
        } else if (amount < 0) {
            throw new IllegalArgumentException("Amount is negative");
        } else if (!cart.containsKey(taken)) {
            throw new NoSuchElementException("Product not found");
        } else {
            // barang yang dikeluarkan terlalu banyak
            return false;
        }
    }

    public void emptyCart() {
        cart.clear();
    }

    public FixedBill checkout() {
        ArrayList<FixedBillEntry> ret = new ArrayList<>();
        for (Map.Entry<Product, Integer> i :
                cart.entrySet()) {
            ret.add(new FixedBillEntry(i.getKey(), i.getValue()));
        }
        return new FixedBill(CustomerCounter.setID(), ret);
    }
    public FixedBill checkout(String MemberID) {
        ArrayList<FixedBillEntry> ret = new ArrayList<>();
        for (Map.Entry<Product, Integer> i :
                cart.entrySet()) {
            ret.add(new FixedBillEntry(i.getKey(), i.getValue()));
        }
        return new FixedBill(MemberID, ret);
    }
}
