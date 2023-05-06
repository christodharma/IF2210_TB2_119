package Products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

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
    @JacksonXmlProperty(localName = "id", isAttribute = true) private final String ID;
    @XmlElement(name = "name") @NonNull private String Name;
    @XmlElement(name = "price") @NonNull private Double Price;
    @XmlElement(name = "quantity") private int quantity = 0;
    //Need to add productCount, either from counting DB entries or static int counter
    public void addQuantity(int many){
        quantity+=many;
    }
    public boolean subtractQuantity(int many){
        if (quantity>=many){
            quantity-=many;
            return true;
        } else {
            return false;
        }
    }
    /**
     * Handling for JSON format DB
     * */
    @JsonCreator
    public static Product JacksonCreate(
            @JsonProperty("name") String Name,
            @JsonProperty("id") String ID,
            @JsonProperty("price") Double Price,
            @JsonProperty("quantity") int quantity
            )
        {
            return new Product(ID, Name, Price, quantity);
    }
}
