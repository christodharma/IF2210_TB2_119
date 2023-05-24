package Transactions;

import Products.Product;
import lombok.Getter;

@Getter
public class FixedBillEntry{
    private final String ProductID;
    private final int Quantity;
    private final double Price;
    public FixedBillEntry(Product product,int quantity, double valuation) {
        ProductID = product.getID();
        Quantity = quantity;
        Price = product.getPrice().valuate(valuation);
    }
}
