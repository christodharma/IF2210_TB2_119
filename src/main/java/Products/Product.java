package Products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@Builder @Jacksonized
@XmlRootElement(name="Product")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    @JacksonXmlProperty(localName = "id", isAttribute = true)
        private final String ID;
    @XmlElement(name = "name")
    @NonNull
        private String Name;
    @XmlElement(name = "price")
    @NonNull
        private Double Price;
    @XmlElement(name = "buyPrice")
    @NonNull
        private Double BuyPrice;
    @XmlElement(name = "category")
    @NonNull
        private String Category;
    @XmlElement(name="picture")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @Builder.Default
        private String Picture = null;
    @XmlElement(name = "quantity")
    @NonNull
    @Builder.Default
        private int Quantity=0;

    public Product(String a, String b, Number c, Number d, String e, int f){
        this.ID = a;
        this.Name = b;
        this.Price = Double.valueOf(String.valueOf(c));
        this.BuyPrice = Double.valueOf(String.valueOf(d));
        this.Category = e;
        this.Quantity = f;
    }
    @JsonCreator
    public static Product create(
            @JsonProperty("id") String ID,
            @JsonProperty("name") @NonNull String name,
            @JsonProperty("price") @NonNull Number Price,
            @JsonProperty("buyPrice") @NonNull Number BuyPrice,
            @JsonProperty("category") @NonNull String category,
            @JsonProperty("picture") String picture,
            @JsonProperty("quantity") int quantity) {
        return new Product(ID, name, Double.valueOf(String.valueOf(Price)), Double.valueOf(String.valueOf(BuyPrice)), category, picture, quantity);
    }


    public void addQuantity(int many){
        Quantity +=many;
    }
    public boolean subtractQuantity(int many){
        if (Quantity >=many){
            Quantity -=many;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Product){
            return Objects.equals(((Product) o).ID, this.ID);
        }
        return false;
    }
}
