package ProductDB;

import Database.DatabaseService.*;
import Exception.Database.ExtensionException;
import Model.Product.Product;
import Database.Product.ProductDB;
import Model.Product.Price;
import Exception.Database.NoSuchEntryException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductDBTest {
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
        testDB.insert(built.toBuilder().ID("2").BuyPrice(new Price(4900.5)).build());
        testDB.insert(built.toBuilder().ID("3").build());
        testDB.insert(built.toBuilder().ID("4").Quantity(7357).build());
        testDB.insert(built.toBuilder().ID("5").Name("Metal Pipe").build());
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
    @Test
    @Order(7)
    void OperationTest() throws NoSuchEntryException {
        ProductDB testDB = templateProductDB();
        // testDB has template members
        // basic insert is already covered by templateProductDB
        assertThrows(NoSuchEntryException.class,() ->
                testDB.insert(
                        Product.builder(
                                "1",
                                "Indomie",
                                3000,
                                2900,
                                "Food")
                                .build()),
                "database overwritten");

        // select operation
        // select by ID
        Product select1 = testDB.select("4");
        // item id 4 should have 7357 in quantity
        assertEquals(7357, select1.getQuantity(), "Quantity is wrong");
        // select by name returns first occurance
        Product select2 = testDB.select("Metal Pipe");
        assertEquals(testDB.select("5"), select2, "ID is not 5 or not first occurence");
        // select by Product object
        Product select3 = testDB.select(select1);
        assertEquals(select3.getQuantity(), select1.getQuantity(), "fails to find with object param");
        // select with illegal argument
        assertThrows(NoSuchEntryException.class, () -> testDB.select(1), "unexpected type accept");

        //update operations
        assertThrows(NoSuchEntryException.class, () -> testDB.update(1), "unexpected type accept");
        // before update
        double beforeUpdate = testDB.select(select1).getValue();
        select1.setDiscount(0.1);
        testDB.update(select1);
        // after update
        assertNotEquals(beforeUpdate,testDB.select(select1).getValue(), "update fail");

        // subtract and add operation
        int beforeUpdate2 = testDB.select(select1).getQuantity();
        testDB.subtractProduct(select1, 7);
        assertNotEquals(beforeUpdate2, testDB.select(select1).getQuantity());
        // resetting select1 value
        testDB.addProduct(select1, 7);
        assertEquals(beforeUpdate2, testDB.select(select1).getQuantity());

        //delete operation
        testDB.delete("3");
        assertThrows(NoSuchEntryException.class, ()->testDB.select("3"), "deletion fail");
    }
}