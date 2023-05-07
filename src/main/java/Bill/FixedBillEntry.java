package Bill;

import Products.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class FixedBillEntry {
@JsonProperty("product")
@JacksonXmlProperty(localName = "product")
    @NonNull private final Product product;
@JsonProperty("quantity")
@JacksonXmlProperty(localName = "quantity")
    @NonNull private final Integer qty;
@JsonProperty("total")
@JacksonXmlProperty(localName = "total")
    public Double totalPrice;

    public FixedBillEntry(Product p, int qty){
        this.product = p;
        this.qty = qty;
        this.totalPrice = p.getPrice()*qty;
    }
}