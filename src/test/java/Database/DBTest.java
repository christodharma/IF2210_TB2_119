package Database;

import Exception.ExtensionException;
import Products.Product;
import Products.ProductDB;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBTest {
    ProductDB templateProductDB() {
        ProductDB testDB = new ProductDB();
        testDB.addProduct(new Product("1", "Indomilk", 5000D, 50));
        testDB.addProduct(new Product("2", "Indomie", 3000d, 100));
        testDB.addProduct(new Product("3", "Indocafe", 3000D, 400));
        testDB.addProduct(new Product("4", "Teh Kotak", 5000D, 70));
        testDB.addProduct(new Product("5", "Teh Bundar", 4000D, 40));
        return testDB;
    }
    @Test
    @Order(1)
    void saveDataTest() throws IOException, ExtensionException {
        ProductDB testDB = templateProductDB();
        IDBAdapter<ProductDB> DBInterface = new ObjService<ProductDB>();
        Database<ProductDB> objDB = new Database<ProductDB>(DBInterface, "src/test/resources/data/Products.obj");
        objDB.saveData(testDB);
    }
    @Test
    @Order(2)
    void loadDataTest() throws IOException, ClassNotFoundException, ExtensionException {
        Database<ProductDB> DBWrongPath = new Database<ProductDB>(new ObjService<ProductDB>(), "src/test/resources/data/Products.xm");
        assertThrows(ExtensionException.class, DBWrongPath::loadData);
        Database<Object> DB = new Database<Object>(new ObjService<>(), "src/test/resources/data/Products.obj");
        ProductDB products = (ProductDB) DB.loadData();
        assertNotNull(products, "Fail to import");
        assertTrue(products instanceof ProductDB, "Wrong Class");
        for (Product p :
                products.Products.values()) {
            System.out.println(p.getID() +" "+ p.getName()+" "+p.getPrice()+" "+p.getStockQuantity());
        }
    }
    @Test
    @Order(3)
    void JsonSaveDataTest() throws IOException, ExtensionException {
        ProductDB testDB = templateProductDB();
        Database<ProductDB> DB = new Database<ProductDB>(new JsonService<>(ProductDB.class), "src/test/resources/data/Products.json");
        DB.saveData(testDB);
    }
    @Test
    @Order(4)
    void JsonLoadDataTest() throws IOException, ClassNotFoundException, ExtensionException {
        Database<ProductDB> DBWrongPath = new Database<ProductDB>(new JsonService<>(ProductDB.class), "src/test/resources/data/Products.xm");
        assertThrows(ExtensionException.class, DBWrongPath::loadData);
        Database<ProductDB> DB = new Database<ProductDB>(new JsonService<>(ProductDB.class), "src/test/resources/data/Products.json");
        ProductDB products = /*(ProductDB)*/ DB.loadData();
        assertNotNull(products, "Fail to import");
        assertTrue(products instanceof ProductDB, "Wrong Class");
        for (Product p :
                products.Products.values()) {
            System.out.println(p.getID() +" "+ p.getName()+" "+p.getPrice()+" "+p.getStockQuantity());
        }
    }
    @Test
    @Order(5)
    void XmlSaveDataTest() throws IOException, ExtensionException {
        ProductDB testDB = templateProductDB();
        Database<ProductDB> DB = new Database<ProductDB>(new XmlService<>(ProductDB.class), "src/test/resources/data/Products.xml");
        DB.saveData(testDB);
    }
    @Test
    @Order(6)
    void XmlLoadDataTest() throws IOException, ClassNotFoundException, ExtensionException {
        Database<ProductDB> DBWrongPath = new Database<ProductDB>(new XmlService<>(ProductDB.class), "src/test/resources/data/Products.xm");
        assertThrows(ExtensionException.class, DBWrongPath::loadData);
        Database<ProductDB> DB = new Database<ProductDB>(new XmlService<>(ProductDB.class), "src/test/resources/data/Products.xml");
        ProductDB products = /*(ProductDB)*/ DB.loadData();
        assertNotNull(products, "Fail to import");
        assertTrue(products instanceof ProductDB, "Wrong Class");
        for (Product p :
                products.Products.values()) {
            System.out.println(p.getID() +" "+ p.getName()+" "+p.getPrice()+" "+p.getStockQuantity());
        }
    }
}