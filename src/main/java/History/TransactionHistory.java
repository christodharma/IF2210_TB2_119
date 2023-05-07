package History;

import Bill.FixedBill;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@Jacksonized
public class TransactionHistory {
    @JacksonXmlProperty(localName = "transactions")
    @JsonProperty("transactions")
    private ArrayList<FixedBill> contents;
    public TransactionHistory(){
        contents = new ArrayList<>();
    }
    public TransactionHistory(ArrayList<FixedBill> contents){
        this.contents = contents;
    }
    public void addHistory(FixedBill transaction){
        contents.add(transaction);
    }
}
