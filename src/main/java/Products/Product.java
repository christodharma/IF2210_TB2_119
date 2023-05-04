package Products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name="Product")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
//    /**
//     * @param ID Required ID for product
//     * @param Name Required product name
//     * @param Price Required product price
//     * @param Quantity Stock Quantity, defaults to 0
//     */
    @XmlAttribute(name = "id") private final String ID;
    @XmlElement(name = "name") @NonNull private String Name;
    @XmlElement(name = "price") @NonNull private Double Price;
    @XmlElement(name = "stockQuantity") private int StockQuantity = 0;
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
    /**
     * Handling for JSON format DB
     * */
    @JsonCreator
    public static Product create(
            @JsonProperty("name") String Name,
            @JsonProperty("id") String ID,
            @JsonProperty("price") Double Price,
            @JsonProperty("stockQuantity") int StockQuantity
            )
        {
            return new Product(ID, Name, Price, StockQuantity);
    }
}
