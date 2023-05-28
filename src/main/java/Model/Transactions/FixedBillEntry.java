package Model.Transactions;

import Model.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;

import java.io.Serializable;

@Getter
@JsonRootName("Entry")
public class FixedBillEntry implements Serializable {
    private static final long serialVersionUID = 6L;
    @JsonIgnore
    private final String ProductID;
    @JsonIgnore
    private final double Price;
    @JsonIgnore
    private final int Quantity;
    @JsonIgnore
    private final double TotalPrice;
    public FixedBillEntry(Product product, int quantity) {
        ProductID = product.getID();
        Price = product.getValue();
        Quantity = quantity;
        TotalPrice = Price * Quantity;
    }
}
