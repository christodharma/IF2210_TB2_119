package History;

import Bill.Bill;
import DatabaseService.DatabaseService;
import Products.Product;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import DatabaseService.*;

import java.io.File;
import java.io.IOException;
import Exception.ExtensionException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionHistoryTest {

    Bill cart;
    @Test
    @Order(1)
    void TransactionHistoryTest(){
        cart = new Bill("123", "1");
        Product p = new Product("1", "Indomilk", 5000D, 4900D, "Food", "", 0);
        cart.addProduct(new Product("1", "Indomilk", 5000D, 4900D, "Food", "", 0));
        cart.addProduct(new Product("12", "Indomilk", 5000D, 4900D, "Food", "", 0));
        cart.addProduct(new Product("1", "Indomilk", 5000D, 4900D, "Food", "", 0));
        assertNotNull(cart);
    }
    @Test
    @Order(2)
    void TransactionHistorySave() throws ExtensionException, IOException {
        TransactionHistoryTest();
        DatabaseService dbs = new DatabaseService(new JsonService(TransactionHistory.class), "src/test/resources/data/TransactionHistory.json");
        dbs.saveData(cart);
        File fileCheck = new File("src/test/resources/data/TransactionHistory.json");
        assertTrue(fileCheck.exists());
    }
}