package Products;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductCollection {
    HashMap<String, Product> contents = new HashMap<>();
    public void addProduct(@NonNull Product added)
    {
        Product existingProduct = contents.get(added.getID());
        if (existingProduct != null)
        {
            existingProduct.addQuantity(added.getQuantity());
        } else
        {
            contents.put(added.getID(), added);
        }
    }
    public boolean subtractProduct(@NonNull Product subtracted, int many)
    {
        return (subtracted.subtractQuantity(many));
    }
    public void removeProduct(@NonNull Product removed)
    {
        contents.remove(removed.getID());
    }
    public void clearContents()
    {
        contents.clear();
    }
    public Product find(String filter, String filterValue)
    {
        switch (filter){
            case "Id":
            case "id":
            case "ID":
                return contents.get(filterValue);
            case "name":
            case "NAME":
            case "Name":
                for (Product p :
                        contents.values()) {
                    if (p.getName().equals(filterValue))
                    {
                        return p;
                    }
                }
                return null;
            default:
                return null;
        }
    }
    public List<Product> getProducts(){
        return new ArrayList<>(contents.values());
    }
}
