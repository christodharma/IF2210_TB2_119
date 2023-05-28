package Model.Transactions;

import Model.Memberships.CustomerCounter;
import Model.Product.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Bill{
    private HashMap<Product, Integer> cart = new HashMap<>();
    public boolean addToCart(Product added, Integer amount) {
        if (added.subtractQuantity(amount)){
            cart.put(added, amount);
            return true;
        } else {
            // barang tidak cukup, tidak dimasukkan ke keranjang
            return false;
        }
    }

    public boolean takeFromCart(Product taken, Integer amount) {
        if (cart.get(taken) >= amount) {
            taken.addQuantity(amount);
            cart.replace(taken, cart.get(taken)-amount);
            return true;
        } else {
            // barang yang dikeluarkan terlalu banyak
            return false;
        }
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
