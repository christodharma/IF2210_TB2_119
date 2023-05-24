package ProductDB;

import Database.DatabaseService.*;
import _119Exception.ExtensionException;
import Products.Product;
import Database.Product.ProductDB;
import _119Exception.NoSuchEntryException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBTest {
    ProductDB templateProductDB() throws NoSuchEntryException {
        ProductDB testDB = new ProductDB();
        testDB.insert(new Product("1", "Indomilk", 5000D, 4900D, "Food", "", 0));
        testDB.insert(new Product("2", "Indomilk", 5000D, 4900D, "Food", "", 0));
        testDB.insert(new Product("3", "Indomilk", 5000D, 4900D, "Food", "", 0));
        testDB.insert(new Product("4", "Indomilk", 5000D, 4900D, "Food", "", 0));
        testDB.insert(new Product("4", "Indomilk", 5000D, 4900D, "Food", "", 7357));
        return testDB;
    }
    @Test
    @Order(1)
    void saveDataTest() throws IOException, ExtensionException, NoSuchEntryException {
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
        assertFalse(products.toArrayList().isEmpty(), "getProduct is empty");
        for (Product p :
                products.toArrayList()) {
            System.out.println(p.getID() +" "+ p.getName()+" "+p.getPrice()+" "+p.getQuantity());
        }
    }
    @Test
    @Order(3)
    void JsonSaveDataTest() throws IOException, ExtensionException, NoSuchEntryException {
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
        assertFalse(products.toArrayList().isEmpty(), "getProduct is empty");
        for (Product p :
                products.toArrayList()) {
            System.out.println(p.getID() +" "+ p.getName()+" "+p.getPrice()+" "+p.getQuantity());
        }
    }
    @Test
    @Order(5)
    void XmlSaveDataTest() throws IOException, ExtensionException, NoSuchEntryException {
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
        assertFalse(products.toArrayList().isEmpty(), "getProduct is empty");
        for (Product p :
                products.toArrayList()) {
            System.out.println(p.getID() +" "+ p.getName()+" "+p.getPrice()+" "+p.getQuantity());
        }
        for (Product s:
                products.toArrayList()
        ) {
            System.out.println(s);
        }
    }
}