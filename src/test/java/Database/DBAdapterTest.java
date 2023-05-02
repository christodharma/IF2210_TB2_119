package Database;

import Products.Product;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBAdapterTest {
    void templateProductAdd(ProductDB target) {
        target.addProduct(new Product("1", "Indomilk", 5000D, 50));
        target.addProduct(new Product("2", "Indomie", 3000d, 100));
        target.addProduct(new Product("3", "Indocafe", 3000D, 400));
        target.addProduct(new Product("4", "Teh Kotak", 5000D, 70));
        target.addProduct(new Product("5", "Teh Bundar", 4000D, 40));
    }
    @Test
    @Order(1)
    void saveDataTest() throws IOException {
        ProductDB testDB = new ProductDB();
        templateProductAdd(testDB);
        IDatabase<ProductDB> DBInterface = new ObjService<>();
        DBAdapter<ProductDB> objDB = new DBAdapter<>(DBInterface, "src/test/resources/data/Products.obj");
        objDB.saveData(testDB);
    }
    @Test
    @Order(2)
    void loadDataTest() throws IOException, ClassNotFoundException {
        IDatabase<Object> IDB = new ObjService<>();
        DBAdapter<Object> objDB = new DBAdapter<>(IDB, "src/test/resources/data/Products.obj");
        ProductDB products = (ProductDB) objDB.loadData();
        assertNotNull(products, "Fail to import");
        assertTrue(products instanceof ProductDB, "Wrong Class");
        for (Product p :
                products.Inventory.values()) {
            System.out.println(p.getID() +" "+ p.getName()+" "+p.getPrice()+" "+p.getStockQuantity());
        }
    }
}