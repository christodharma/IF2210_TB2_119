package Database;

import Products.Product;
import lombok.NonNull;

import java.util.HashMap;

public class Product_DB {
    /**
     * ProductId, Product Object
     */
    public HashMap<Integer, Product> Inventory;
    public Product_DB()
    {
        this.Inventory = new HashMap<>();
    }

    /*TODO: Instantiate Product_DB with existing data store
    *  e.g. Taking parameter file path*/

    public void addProduct(@NonNull Product added)
    {
        Product existingProduct = Inventory.get(added.getID());
        if (existingProduct != null)
        {
            existingProduct.addStockQuantity(added.getStockQuantity());
        } else
        {
            Inventory.put(Integer.parseInt(added.getID()), added);
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
        Inventory.remove(Integer.parseInt(removed.getID()));
    }
    public void clearDatabase()
    {
        Inventory.clear();
    }

    public Product find(int ProductID)
    {
        return Inventory.get(ProductID);
    }
    public Product find(String ProductName)
    {
        for (Product p :
                Inventory.values()) {
            if (p.getName() == ProductName)
            {
                return p;
            }
        }
        return null;
    }
}
