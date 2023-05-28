package Database.Product;

import Database.Database;
import Database.DatabaseOperations;
import Model.Product.Product;
import Exception.Database.NoSuchEntryException;
import Database.MappingFromID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

@NoArgsConstructor
@JsonRootName("ProductDB")
public class ProductDB extends Database<Product> implements Serializable, DatabaseOperations<Product>, MappingFromID<Product> {
    private static final long serialVersionUID = 11L;
    @JsonProperty("contents")
    public HashSet<Product> getSet(){
        return contents;
    }

    @JsonIgnore
    private HashMap<String,Product> ProductMap = toMap(contents);

    @Override
    public void insert(Product element) throws NoSuchEntryException {
        if (contents.add(element)){
            ProductMap.put(element.getID(), element);
        } else {
            throw new NoSuchEntryException("element exists");
        }
    }

    @Override
    public Product select(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(Product.class)){
            // keyword is product object
            return ProductMap.get(((Product) keyword).getID());
        } else if (keyword.getClass().equals(String.class)) {
            if (((String) keyword).matches("\\d+")) {
                // keyword is product ID string
                if (ProductMap.containsKey(keyword)){
                    return ProductMap.get(keyword);
                } else {
                    throw new NoSuchEntryException();
                }
            } else {
                // keyword is product name
                // will return the first occasion of select condition
                return ProductMap.values().stream().filter(
                                member -> member.getName().contains((String) keyword))
                        .findFirst().orElseThrow(() -> new NoSuchEntryException(keyword + " name not found"));
            }
        } else {
            throw new NoSuchEntryException();
        }
    }

    @Override
    public void update(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(Product.class)) {
            ProductMap.replace(select(keyword).getID(), (Product) keyword);
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
        contents.remove(ret);
        ProductMap.remove(select(keyword).getID());
        return ret;
    }
}