package Products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void ProductInstantiation()
    {
        Product Milk = new Product("0", "Milk", 15000);
        assertEquals("Milk", Milk.getName(), "Name is not Milk");
        assertEquals(0, Milk.getStockQuantity(), "Stock isn't 0");
    }
}