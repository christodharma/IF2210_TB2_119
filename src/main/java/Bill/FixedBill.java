package Bill;


import Products.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class FixedBill extends Bill{

    public FixedBill(String buyerID, String transactionID) {
        super(buyerID, transactionID);
        for (Product i :
                super.getItems().getProducts()) {
            fixedItems.add(new Pair(i, i.getQuantity()));
        }
    }
    @Getter
    @AllArgsConstructor
    class Pair {
        @JsonProperty("product")
        Product product;
        @JsonProperty("quantity")
        Integer qty;
    }
    private final ArrayList<Pair> fixedItems = new ArrayList<>();
    private double getSubTotal(){
        double ret=0d;
        for (Pair i :
                fixedItems) {
            ret=i.product.getPrice()* i.qty;
        }
        return ret;
    }
}
