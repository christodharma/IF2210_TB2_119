package Transactions;

import Product.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;

@Getter
@JsonRootName("Entry")
public class FixedBillEntry{
    @JsonProperty
    private final String ProductID;
    @JsonProperty
    private final double Price;
    @JsonProperty
    private final int Quantity;
    @JsonProperty
    private final double TotalPrice;
    public FixedBillEntry(Product product, int quantity) {
        ProductID = product.getID();
        Price = product.getValue();
        Quantity = quantity;
        TotalPrice = Price * Quantity;
    }
}
