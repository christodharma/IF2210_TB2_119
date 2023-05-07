package Bill;

import Customers.Customer;
import Customers.Member;
import Products.ProductCollection;
import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PROTECTED)
public class Bill extends ProductCollection {
    private final Customer customerRef;
    public Bill(Customer buyer){
        customerRef = buyer;
    }
    public Bill (Member buyer){
        customerRef = buyer.getCustomerRef();
        buyer.purchaseCount++;
    }
}
