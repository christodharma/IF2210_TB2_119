package Transactions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RequiredArgsConstructor
@Data
public class FixedBill implements Serializable {
    //TODO: TransactionsDB
    private static final long serialVersionUID = 3L;
    @JsonProperty("buyerID")
    private final String buyerID;
    @JsonProperty("items")
    private final ArrayList<FixedBillEntry> items;
    @JsonProperty("datetime") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private final LocalDateTime dateTime = LocalDateTime.now();
    @JsonIgnore
    public String getID() {
        DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ldt = LocalDateTime.now();
        String formatteddatetime = ldt.format(CUSTOM_FORMATTER);
        return buyerID + formatteddatetime;
    }
}
