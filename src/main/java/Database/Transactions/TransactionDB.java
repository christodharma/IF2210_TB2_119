package Database.Transactions;

import Database.Database;
import Database.DatabaseOperations;
import Database.Product.ProductDBSerializer;
import Transactions.FixedBill;
import _119Exception.NoSuchEntryException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class TransactionDB extends Database<FixedBill> implements Serializable, DatabaseOperations<FixedBill> {
    private static final long serialVersionUID = 14L;

    @JsonProperty("contents")
    @JsonSerialize(keyUsing = ProductDBSerializer.class)
    public HashMap<String, FixedBill> getHashMap(){
        return contents;
    }
    @Override
    public void insert(FixedBill element){
        contents.put(element.getID(), element);
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
                return contents.get(keywordString);
            }catch (DateTimeParseException d) {
                //keyword String doesn't end with datetime
                //multiple result, throws exception
                throw new NoSuchEntryException();
            }
        } else if (keyword.getClass().equals(FixedBill.class)) {
            return contents.values().stream().filter(
                            member -> member.equals(keyword))
                    .findFirst().orElseThrow(NoSuchEntryException::new);
        } else {
            throw new NoSuchEntryException();
        }
    }

    @Override
    public void update(Object keyword) throws NoSuchEntryException {
        throw new NoSuchEntryException("Transaction database can not be updated");
    }

    @Override
    public FixedBill delete(Object keyword) throws NoSuchEntryException {
        throw new NoSuchEntryException("Transaction database can not be deleted");
    }
}
