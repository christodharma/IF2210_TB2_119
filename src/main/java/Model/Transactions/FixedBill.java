package Model.Transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class FixedBill implements Serializable {
    private static final long serialVersionUID = 3L;
    @JsonProperty("buyerID")
    private final String buyerID;
    @JsonProperty("items")
    private final ArrayList<FixedBillEntry> items;
    @JsonProperty("datetime") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private final ZonedDateTime dateTime;
    @JsonIgnore
    public String getID() {
        DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ldt = LocalDateTime.now();
        String formatteddatetime = ldt.format(CUSTOM_FORMATTER);
        return buyerID + formatteddatetime;
    }

    public FixedBill(String buyerID, ArrayList<FixedBillEntry> items) {
        this.buyerID = buyerID;
        this.items = items;
        this.dateTime = ZonedDateTime.now();
    }

    @JsonCreator
    public FixedBill JacksonCreate(
            @JsonProperty("buyerID") String id,
            @JsonProperty("items") ArrayList<FixedBillEntry> items,
            @JsonProperty("datetime") ZonedDateTime dt
    ){
        return new FixedBill(id, items, dt);
    }
}
