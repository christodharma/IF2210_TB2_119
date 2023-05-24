package Products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Builder(builderMethodName = "internalBuilder", toBuilder = true)
@JsonDeserialize(builder = Product.ProductBuilder.class)
@Getter @Setter
@JsonRootName("Product")
public class Product implements Serializable{

    private static final long serialVersionUID = 1L;
    @JsonProperty("id")
        private final String ID;
    @JsonProperty("name") @NonNull
        private String Name;
    @JsonProperty("price") @NonNull
        private Price Price;
    @JsonProperty("buyPrice") @NonNull
        private Price BuyPrice;
    @JsonProperty("category") @NonNull
        private String Category;
    @JsonProperty("picturePath") @JsonInclude(JsonInclude.Include.NON_DEFAULT) @Builder.Default
        private String Picture = null;
    @JsonProperty("quantity") @JsonInclude(JsonInclude.Include.NON_DEFAULT) @Builder.Default
        private int Quantity = 0;

    public static ProductBuilder builder(
            String ID,
            String Name,
            Number Price,
            Number BuyPrice,
            String Category){
        return internalBuilder().ID(ID).Name(Name).Price(new Price(Price)).BuyPrice(new Price(BuyPrice)).Category(Category);
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
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof Product){
//            return Objects.equals(((Product) o).ID, this.ID);
//        }
//        return false;
//    }
}
