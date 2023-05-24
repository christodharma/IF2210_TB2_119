package Products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@JsonRootName("Product")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
        private final String ID;
    @NonNull
        private String Name;
    @NonNull
        private Double Price;
    @NonNull
        private Double BuyPrice;
    @NonNull
        private String Category;
        private String Picture = null;
        private int Quantity=0;

    public Product(String ID, String Name, Number Price, Number BuyPrice, String Category, int Quantity){
        this.ID = ID;
        this.Name = Name;
        this.Price = Double.valueOf(String.valueOf(Price));
        this.BuyPrice = Double.valueOf(String.valueOf(BuyPrice));
        this.Category = Category;
        this.Quantity = Quantity;
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
