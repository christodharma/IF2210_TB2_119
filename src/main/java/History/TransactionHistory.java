package History;

import Bill.FixedBill;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@XmlRootElement(name="TransactionHistory")
public class TransactionHistory implements Serializable {
    @JacksonXmlProperty(localName = "transactions")
    @JsonProperty("transactions")
    private ArrayList<FixedBill> contents;
    public TransactionHistory(){
        contents = new ArrayList<>();
    }
    public void addHistory(FixedBill transaction){
        contents.add(transaction);
    }
}
