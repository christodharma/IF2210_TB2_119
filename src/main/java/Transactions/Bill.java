package Transactions;

import Products.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Bill{
    private final String buyerID;
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
            ret.add(new FixedBillEntry(i.getKey(), i.getValue(), i.getKey().getPrice().valuate(0)));
        }
        return new FixedBill(ret);
    }
}
