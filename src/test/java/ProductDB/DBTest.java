package ProductDB;

import Database.DatabaseService.*;
import _119Exception.ExtensionException;
import Product.Product;
import Database.Product.ProductDB;
import _119Exception.NoSuchEntryException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBTest {
    ProductDB templateProductDB() throws NoSuchEntryException {
        ProductDB testDB = new ProductDB();
        Product built = Product.builder(
                        "1",
                        "Indomilk",
                        5000,
                        4900,
                        "Food")
                .Quantity(0).build();
        testDB.insert(built);
        Product built2 = built.toBuilder().ID("2").build();
        testDB.insert(built2);
        Product built3 = built.toBuilder().ID("3").build();
        testDB.insert(built3);
        Product built4 = built.toBuilder().ID("4").build();
        testDB.insert(built4);
        Product built5 = built.toBuilder().ID("4").Quantity(7357).build();
        testDB.insert(built5);
        return testDB;
    }
    @Test
    @Order(1)
    void saveDataTest() throws IOException, ExtensionException, NoSuchEntryException {
        ProductDB testDB = templateProductDB();
        ServiceAdapter DBInterface = new ObjService(ProductDB.class);
        DatabaseService objDB = new DatabaseService(DBInterface, "src/test/resources/data/Product.obj");
        objDB.saveData(testDB);
    }
    @Test
    @Order(2)
    void loadDataTest() throws IOException, ExtensionException {
        DatabaseService DBWrongPath = new DatabaseService(new ObjService(ProductDB.class), "src/test/resources/data/Product.xm");
        assertThrows(ExtensionException.class, DBWrongPath::loadData);
        DatabaseService DB = new DatabaseService(new ObjService(ProductDB.class), "src/test/resources/data/Product.obj");
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
        DatabaseService DB = new DatabaseService(new JsonService(ProductDB.class), "src/test/resources/data/Product.json");
        DB.saveData(testDB);
    }
    @Test
    @Order(4)
    void JsonLoadDataTest() throws IOException, ExtensionException {
        DatabaseService DBWrongPath = new DatabaseService(new JsonService(ProductDB.class), "src/test/resources/data/Product.xm");
        assertThrows(ExtensionException.class, DBWrongPath::loadData);
        DatabaseService DB = new DatabaseService(new JsonService(ProductDB.class), "src/test/resources/data/Product.json");
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
        DatabaseService DB = new DatabaseService(new XmlService(testDB), "src/test/resources/data/Product.xml");
        DB.saveData(testDB);
    }
    @Test
    @Order(6)
    void XmlLoadDataTest() throws IOException, ExtensionException {
        DatabaseService DBWrongPath = new DatabaseService(new XmlService(ProductDB.class), "src/test/resources/data/Product.xm");
        assertThrows(ExtensionException.class, DBWrongPath::loadData);
        DatabaseService DB = new DatabaseService(new XmlService(ProductDB.class), "src/test/resources/data/Product.xml");
        ProductDB products = (ProductDB) DB.loadData();
        assertNotNull(products, "Fail to import");
        assertTrue(products instanceof ProductDB, "Wrong Class");
        assertFalse(products.toArrayList().isEmpty(), "getProduct is empty");
        for (Product p :
                products.toArrayList()) {
            System.out.println(p.getID() +" "+ p.getName()+" "+p.getPrice()+" "+p.getQuantity());
        }
    }
}