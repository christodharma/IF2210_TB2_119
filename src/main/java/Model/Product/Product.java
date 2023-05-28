package Model.Product;

import Model.HaveID;
import Model.Transactions.Valueable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Builder(builderMethodName = "internalBuilder", toBuilder = true)
@JsonDeserialize(builder = Product.ProductBuilder.class)
@Getter @Setter
@JsonRootName("Model")
public class Product extends HaveID implements Serializable, Valueable {

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
    @JsonProperty("discount") @JsonInclude(JsonInclude.Include.NON_DEFAULT) @Builder.Default
        private double Discount = 0;

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

    @Override
    public double valuate(double percentage) {
        return Price.getAmount() * (1+percentage);
    }

    @JsonIgnore
    public double getValue() {
        return valuate(-Discount);
    }
    @Override
    public boolean equals(Object o) {
        if (o.getClass().equals(Product.class)){
            return this.ID.equals(((Product) o).ID);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
