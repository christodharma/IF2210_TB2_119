package Database;

import Products.Product;
import lombok.NonNull;

import java.io.IOException;
import java.util.HashMap;

public class ProductDB extends Parser<HashMap<Integer,Product>>{
    /**
     * ProductId, Product Object
     */
    public HashMap<Integer, Product> Inventory;
    public ProductDB()
    {
        this.Inventory = new HashMap<>();
    }
    public ProductDB(HashMap<Integer, Product> DB)
    {
        this.Inventory = DB;
    }
    public ProductDB(String filePath) throws IOException, ClassNotFoundException {
        this.Inventory = ReadDatabase(filePath);
    }
    public void addProduct(@NonNull Product added)
    {
        Product existingProduct = Inventory.get(Integer.parseInt(added.getID()));
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
            if (p.getName().equals(ProductName))
            {
                return p;
            }
        }
        return null;
    }
}
