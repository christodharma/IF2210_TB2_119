package Database.Transactions;

import Database.Database;
import Database.DatabaseOperations;
import Exception.Database.NoSuchEntryException;
import Model.Transactions.FixedBill;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;

public class TransactionDB extends Database<FixedBill> implements Serializable, DatabaseOperations<FixedBill> {
    private static final long serialVersionUID = 14L;

    @JsonProperty("contents")
    public HashSet<FixedBill> getSet(){
        return contents;
    }
    @Override
    public void insert(FixedBill element){
        contents.add(element);
    }

    @Override
    public FixedBill select(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(String.class)){
            String keywordString = (String) keyword;
            String datetimeMaybe = keywordString.substring(keywordString.length()-14);
            DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            try {
                LocalDateTime datetime = LocalDateTime.parse(datetimeMaybe, CUSTOM_FORMATTER);
                // keywordString ends with datetime
                // check normally as ID
                return contents.stream().filter(
                        e -> e.getID().equals(keywordString)
                        )
                        .findFirst().orElseThrow(() -> new NoSuchEntryException(keywordString + "is not found"));
            }catch (DateTimeParseException d) {
                //keyword String doesn't end with datetime
                //multiple result, throws exception
                throw new NoSuchEntryException();
            }
        } else if (keyword.getClass().equals(FixedBill.class)) {
            // search by fixedbill object
            return contents.stream().filter(
                            member -> member.equals(keyword))
                    .findFirst().orElseThrow(NoSuchEntryException::new);
        } else {
            throw new NoSuchEntryException();
        }
    }

    @Override
    public void update(Object keyword) throws NoSuchEntryException {
        throw new NoSuchEntryException("Transaction database elements can not be updated/overwritten");
    }

    @Override
    public FixedBill delete(Object keyword) throws NoSuchEntryException {
        throw new NoSuchEntryException("Transaction database elements can not be deleted");
    }
}
