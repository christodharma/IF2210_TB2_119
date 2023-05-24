package Products;

import Transactions.Valueable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
@RequiredArgsConstructor
public class Price implements Serializable,Valueable {
    private static final long serialVersionUID = 4L;
@JsonProperty("amount")
@JacksonXmlProperty(isAttribute = true, localName = "amount")
    private double amount;

    public Price(Number amount){
        if (amount.getClass().equals(Integer.class)){
            this.amount = (int) amount;
        } else {
            this.amount = (double) amount;
        }
    }
    @Override
    public double valuate(double percentage) {
        return (1+percentage) * amount;
    }

    @Override
    public String toString(){
        return String.valueOf(amount);
    }
}