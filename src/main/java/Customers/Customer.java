package Customers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@JsonRootName("customer")
public class Customer extends Membership implements Serializable {
    private static final long serialVersionUID = 21L;
@JacksonXmlProperty(isAttribute = true, localName = "id")
@JsonProperty("id")
    private final String ID;
    public Customer()
    {
        this.ID = String.valueOf(Counter+1);
        Counter++;
    }
    public int purchaseCount = 1;
    @Override
    public String getID()
    {
        return ID;
    }
}
