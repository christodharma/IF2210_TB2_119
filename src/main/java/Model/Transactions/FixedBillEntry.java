package Model.Transactions;

import Model.Product.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@JsonRootName("Entry")
@AllArgsConstructor
public class FixedBillEntry implements Serializable {
    private static final long serialVersionUID = 6L;
    private final String ProductID;
    private final double Price;
    private final int Quantity;
    private final double TotalPrice;
    public FixedBillEntry(Product product, int quantity) {
        ProductID = product.getID();
        Price = product.getValue();
        Quantity = quantity;
        TotalPrice = Price * Quantity;
    }
    @JsonCreator
    public static FixedBillEntry JacksonCreate
            (@JsonProperty("productID") String productID,
             @JsonProperty("price") double price,
             @JsonProperty("quantity") int quantity,
             @JsonProperty("totalPrice") double totalPrice) {
        return new FixedBillEntry(productID, price, quantity, totalPrice);
    }
}
