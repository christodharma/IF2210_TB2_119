package Products;

import DatabaseService.*;
import Exception.ExtensionException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductDBTest {
    ProductDB templateProductDB() {
        ProductDB testDB = new ProductDB();
        testDB.addProduct(new Product("1", "Indomilk", 5000D, 4900D, "Food", "", 0));
        testDB.addProduct(new Product("2", "Indomie", 5000D, 4900D, "Food", "", 0));
        testDB.addProduct(new Product("3", "Indotea", 5000D, 4900D, "Food", "", 0));
        testDB.addProduct(new Product("4", "Indokopi", 5000D, 4900D, "Food", "", 0));
        testDB.addProduct(new Product("5", "Indorice", 5000D, 4900D, "Food", "", 0));
        return testDB;
    }
    @Test
    @Order(1)
    void saveDataTest() throws IOException, ExtensionException {
        ProductDB testDB = templateProductDB();
        ServiceAdapter DBInterface = new ObjService(ProductDB.class);
        DatabaseService objDB = new DatabaseService(DBInterface, "src/test/resources/data/Products.obj");
        objDB.saveData(testDB);
    }
    @Test
    @Order(2)
    void loadDataTest() throws IOException, ExtensionException {
        DatabaseService DBWrongPath = new DatabaseService(new ObjService(ProductDB.class), "src/test/resources/data/Products.xm");
        assertThrows(ExtensionException.class, DBWrongPath::loadData);
        DatabaseService DB = new DatabaseService(new ObjService(ProductDB.class), "src/test/resources/data/Products.obj");
        ProductDB products = (ProductDB) DB.loadData();
        assertNotNull(products, "Fail to import");
        assertTrue(products instanceof ProductDB, "Wrong Class");

    }
    @Test
    @Order(3)
    void JsonSaveDataTest() throws IOException, ExtensionException {
        ProductDB testDB = templateProductDB();
        DatabaseService DB = new DatabaseService(new JsonService(ProductDB.class), "src/test/resources/data/Products.json");
        DB.saveData(testDB);
    }
    @Test
    @Order(4)
    void JsonLoadDataTest() throws IOException, ExtensionException {
        DatabaseService DBWrongPath = new DatabaseService(new JsonService(ProductDB.class), "src/test/resources/data/Products.xm");
        assertThrows(ExtensionException.class, DBWrongPath::loadData);
        DatabaseService DB = new DatabaseService(new JsonService(ProductDB.class), "src/test/resources/data/Products.json");
        ProductDB products = (ProductDB) DB.loadData();
        assertNotNull(products, "Fail to import");
        assertTrue(products instanceof ProductDB, "Wrong Class");
    }
    @Test
    @Order(5)
    void XmlSaveDataTest() throws IOException, ExtensionException {
        ProductDB testDB = templateProductDB();
        DatabaseService DB = new DatabaseService(new XmlService(testDB), "src/test/resources/data/Products.xml");
        DB.saveData(testDB);
    }
    @Test
    @Order(6)
    void XmlLoadDataTest() throws IOException, ExtensionException {
        DatabaseService DBWrongPath = new DatabaseService(new XmlService(ProductDB.class), "src/test/resources/data/Products.xm");
        assertThrows(ExtensionException.class, DBWrongPath::loadData);
        DatabaseService DB = new DatabaseService(new XmlService(ProductDB.class), "src/test/resources/data/Products.xml");
        ProductDB products = (ProductDB) DB.loadData();
        assertNotNull(products, "Fail to import");
        assertTrue(products instanceof ProductDB, "Wrong Class");
    }
}