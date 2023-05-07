package Bill;


import Customers.Customer;
import Products.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JacksonXmlRootElement(localName = "FixedBill")
public class FixedBill {
    @JacksonXmlProperty(localName = "fixedItems")
    private final ArrayList<FixedBillEntry> fixedItems = new ArrayList<>();
    private final Customer buyer;

    public FixedBill(Bill s) {
        buyer = s.getCustomerRef();
        for (Product i : s.getProducts()) {
            fixedItems.add(new FixedBillEntry(i, i.getQuantity()));
        }
    }
    @JsonProperty("subTotal")
    @JacksonXmlProperty(localName = "subTotal")
    private double getSubTotal () {
        double ret = 0d;
        for (FixedBillEntry e :
                getFixedItems()) {
            ret += e.getTotalPrice();
        }
        return ret;
    }
}

