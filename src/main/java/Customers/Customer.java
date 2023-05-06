package Customers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

import java.io.Serializable;

@Setter
@JsonRootName("customer")
public class Customer extends Membership implements Serializable {
    private static final long serialVersionUID = 21L;
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    @JsonProperty("id")
    private final String ID;
    public Customer()
    {
        this.ID = String.valueOf(Counter+1);
        Counter++;
    }
    @Override
    public String getID()
    {
        return ID;
    }
}
