package Database;

import Products.Product;
import lombok.NonNull;

import java.io.Serializable;
import java.util.HashMap;

public class ProductDB implements Serializable {
    private static final long serialVersionUID = 11L;
    /**
     * ProductId, Product Object
     */
    public HashMap<String, Product> Inventory;
    public ProductDB()
    {
        this.Inventory = new HashMap<>();
    }
    public ProductDB(HashMap<String, Product> DB)
    {
        this.Inventory = DB;
    }
    public void addProduct(@NonNull Product added)
    {
        Product existingProduct = Inventory.get(added.getID());
        if (existingProduct != null)
        {
            existingProduct.addStockQuantity(added.getStockQuantity());
        } else
        {
            Inventory.put(String.valueOf(added.getID()), added);
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
        Inventory.remove(removed.getID());
    }
    public void clearInventory()
    {
        Inventory.clear();
    }

    public Product find(String filter, String filterValue)
    {
        switch (filter){
            case "Id":
            case "id":
            case "ID":
                return Inventory.get(filterValue);
            case "name":
            case "NAME":
            case "Name":
                for (Product p :
                        Inventory.values()) {
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
