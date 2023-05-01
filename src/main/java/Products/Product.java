package Products;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable{
    private static final long serialVersionUID = System.currentTimeMillis();
    /**
     * @param ID Required ID for product
     * @param Name Required product name
     * @param Price Required product price
     * @param Quantity Stock Quantity, defaults to 0
     */
    private final String ID;
    @NonNull private String Name;
    @NonNull private double Price;
    private int StockQuantity = 0;
    //Need to add productCount, either from counting DB entries or static int counter
    public void addStockQuantity(int many){
        StockQuantity+=many;
    }
    public boolean subtractStockQuantity(int many){
        if (StockQuantity>=many){
            StockQuantity-=many;
            return true;
        } else {
            return false;
        }
    }
}
