package Products;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    private String ID;
    private String Name;
    private double Price;
    private int StockQuantity;
    public Product(String newID, String newName, double newPrice, int newStockQuantity)
    {
        this.ID = newID;
        this.Name = newName;
        this.Price = newPrice;
        this.StockQuantity = newStockQuantity;
    }

    public String getID() {
        return ID;
    }

    public String getName(){
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }
    public void addStockQuantity(int many){
        StockQuantity+=many;
    }
    public void subtractStockQuantity(int many){
        if (StockQuantity>=many){
            StockQuantity-=many;
        }
    }
}
