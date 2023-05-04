package Products;

import lombok.NonNull;

import java.io.Serializable;
import java.util.HashMap;

public class ProductDB implements Serializable {
    private static final long serialVersionUID = 11L;
    /**
     * ProductId, Product Object
     */
    public HashMap<String, Product> Products;
    public ProductDB()
    {
        this.Products = new HashMap<>();
    }
    public ProductDB(HashMap<String, Product> DB)
    {
        this.Products = DB;
    }
    public void addProduct(@NonNull Product added)
    {
        Product existingProduct = Products.get(keyPrefix + added.getID());
        if (existingProduct != null)
        {
            existingProduct.addStockQuantity(added.getStockQuantity());
        } else
        {
            Products.put(keyPrefix + added.getID(), added);
        }
    }

    /**
     * Subtracting product stockQuantity field
     * @param subtracted Non-null product in inventory
     * @param many Quantity to be subtracted
     * @return true if product is enough
     */
    public boolean subtractProduct(@NonNull Product subtracted, int many)
    {
        return (subtracted.subtractStockQuantity(many));
    }
    public void removeProduct(@NonNull Product removed)
    {
        Products.remove(removed.getID());
    }
    public void clearInventory()
    {
        Products.clear();
    }

    public Product find(String filter, String filterValue)
    {
        switch (filter){
            case "Id":
            case "id":
            case "ID":
                return Products.get(filterValue);
            case "name":
            case "NAME":
            case "Name":
                for (Product p :
                        Products.values()) {
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
}
