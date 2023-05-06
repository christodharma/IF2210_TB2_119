package Products;

import Exception.ExtensionException;
import Database.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void ProductInstantiation()
    {
        Product Milk = new Product("0", "Milk", 15000.0, 10);
        assertEquals("Milk", Milk.getName(), "Name is not Milk");
        assertEquals(10, Milk.getStockQuantity(), "Stock isn't 0");
    }
    @Test
    public void ProductIntoXML() throws IOException, ExtensionException {
        Product p = new Product("1", "Soap", 25d, 20);
        DatabaseService db = new DatabaseService(new XmlService(Product.class), "src/test/resources/data/ProductTest.xml");
        db.saveData(p);
    }
}