package Products;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Jacksonized
@XmlRootElement(name="Product")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    @JacksonXmlProperty(localName = "id", isAttribute = true) private final String ID;
    @XmlElement(name = "name") @NonNull private String Name;
    @XmlElement(name = "price") @NonNull private Double Price;
    @XmlElement(name = "buyPrice") @NonNull private Double BuyPrice;
    @XmlElement(name = "category") @NonNull private String Category;
    @XmlElement(name="picture") private String Picture;
    @XmlElement(name = "quantity") private int quantity = 0;

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
}
