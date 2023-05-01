package Database;

import Products.Product;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Product_DBTest {
    private Product_DB db = new Product_DB();
    @Test
    @Order(1)
    public void DBAddSubtractProduct()
    {
        Product milk = new Product("1","Indomilk", 15000, 15);
        db.addProduct(milk);
        assertTrue(db.find(1)!=null, "milk not found");
        assertTrue(db.find("Indomilk")!=null, "milk not found");
        assertTrue(db.subtractProduct(db.find("Indomilk"),1),"Did not subtract or not found");
        assertEquals(14, db.find(1).getStockQuantity(), "Did not subtract");
    }
    @Test
    @Order(2)
    public void NonExisting()
    {
        assertNull(db.find("Indomie"), "Item is found");
        assertThrows(NullPointerException.class, () -> db.subtractProduct(db.find(192),2), "Item is found and subtracted");
    }
    @Test
    @Order(3)
    public void RemoveProduct()
    {
        Product myProduct = new Product("2","Kubis", 7000, 2);
        db.addProduct(myProduct);
        db.removeProduct(myProduct);
        assertNull(db.find("Kubis"), "Product not removed");
    }
    @Test
    @Order(4)
    public void ClearDatabase()
    {
        db.addProduct(new Product("1", "Indomilk", 15000, 3));
        db.addProduct(new Product("2", "Indomie", 3000));
        assertFalse(db.Inventory.isEmpty(), "Fail to add");
        db.clearDatabase();
        assertTrue(db.Inventory.isEmpty(), "Fail to clear");
    }
}