package Bill;
import Products.ProductCollection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter(AccessLevel.PROTECTED)
public class Bill extends ProductCollection {
    private final String buyerID;
    private final String transactionID;
    private ProductCollection items = new ProductCollection();
}
