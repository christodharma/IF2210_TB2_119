package Customers;

import Bill.FixedBill;
import History.TransactionHistory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Setter
@Getter
@JsonRootName("customer")
public class Customer extends Membership implements Serializable {
    private static final long serialVersionUID = 21L;
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    @JsonProperty("id")
    private final String ID;
    @JacksonXmlProperty(localName = "transactions")
    @JsonProperty("transactions")
    private final TransactionHistory historiTransaksi;
    public Customer(FixedBill bought)
    {
        this.historiTransaksi = new TransactionHistory(new ArrayList<>(Collections.singletonList(bought)));
        this.ID = String.valueOf(Counter+1);
        Counter++;
    }
    @Override
    public String getID()
    {
        return ID;
    }
}
