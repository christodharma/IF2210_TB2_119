package Database.Product;

import Database.Database;
import Database.DatabaseOperations;
import Product.Product;
import _119Exception.NoSuchEntryException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

@NoArgsConstructor
@JsonRootName("ProductDB")
public class ProductDB extends Database<Product> implements Serializable, DatabaseOperations<Product> {
    private static final long serialVersionUID = 11L;
    @JsonProperty("contents")
    @JsonSerialize(keyUsing = ProductDBSerializer.class)
    public HashMap<String,Product> getHashMap(){
        return contents;
    }
    @Override
    public void insert(Product element) throws NoSuchEntryException {
        if (contents.containsValue(element)){
            addProduct(element, element.getQuantity());
        } else {
            contents.put(element.getID(), element);
        }
    }

    @Override
    public Product select(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(Product.class)){
            // keyword is product object
            return contents.get(((Product) keyword).getID());
        } else if (keyword.getClass().equals(String.class)) {
            if (((String) keyword).matches("\\d+")) {
                // keyword is product ID string
                return contents.get(keyword);
            } else {
                // keyword is product name
                return contents.values().stream().filter(
                                member -> member.getID().contains((String) keyword))
                        .findFirst().orElseThrow(NoSuchEntryException::new);
            }
        } else {
            throw new NoSuchEntryException();
        }
    }

    @Override
    public void update(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(Product.class)) {
            contents.replace(select(keyword).getID(), (Product) keyword);
        } else {
            throw new NoSuchEntryException("Wrong Class");
        }
    }

    public void addProduct(Object target, int amount) throws NoSuchEntryException {
        Product added = select(target);
        added.addQuantity(amount);
        update(added);
    }
    public void subtractProduct(Object target, int amount) throws NoSuchEntryException {
        Product added = select(target);
        added.subtractQuantity(amount);
        update(added);
    }

    @Override
    public Product delete(Object keyword) throws NoSuchEntryException {
        Product ret = select(keyword);
        contents.remove(select(keyword).getID());
        return ret;
    }
}