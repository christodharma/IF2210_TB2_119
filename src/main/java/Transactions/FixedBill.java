package Transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@RequiredArgsConstructor
public class FixedBill implements Serializable {
    //TODO: TransactionsDB
    private static final long serialVersionUID = 3L;
    @JsonProperty("items")
    private final ArrayList<FixedBillEntry> items;
}
