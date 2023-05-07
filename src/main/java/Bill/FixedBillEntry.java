package Bill;

import Products.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonRootName("fixed-item")
@JacksonXmlRootElement(localName = "fixed-item")
public class FixedBillEntry {
    private final Product product;
    private final Integer qty;
    @JsonProperty("total")
    public Double total = this.getProduct().getPrice()*this.getQty();
    @JsonProperty("product")
    public Product getProduct() {
        return product;
    }
    @JsonProperty("quantity")
    public Integer getQty() {
        return qty;
    }
}