package Products;

import lombok.NonNull;

import java.io.Serializable;
import java.util.HashMap;

public class ProductDB extends ProductCollection implements Serializable {
    private static final long serialVersionUID = 11L;
    private static final String keyPrefix = "";
    /**
     * ProductId, Product Object
     */
    public ProductDB()
    {
        this.contents = new HashMap<>();
    }
    public ProductDB(HashMap<String, Product> DB)
    {
        this.contents = DB;
    }
    @Override
    public void addProduct(@NonNull Product added)
    {
        Product existingProduct = contents.get(keyPrefix + added.getID());
        if (existingProduct != null)
        {
            existingProduct.addQuantity(added.getQuantity());
        } else
        {
            contents.put(keyPrefix + added.getID(), added);
        }
    }
}