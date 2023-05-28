package Transactions;

import Database.DatabaseService.DatabaseService;
import Database.DatabaseService.JsonService;
import Database.DatabaseService.ObjService;
import Database.DatabaseService.XmlService;
import Database.Memberships.MemberDB;
import Database.Product.ProductDB;
import Database.Transactions.TransactionDB;
import Exception.Database.ExtensionException;
import Exception.Database.NoSuchEntryException;
import Model.Memberships.CustomerCounter;
import Model.Transactions.Bill;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDBTest {
    static TransactionDB testDB;
    static ProductDB productDB;
    static MemberDB memberDB;
    static String DatabasePath = "src/test/resources/data/";
    @BeforeAll
    static void setUp() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new XmlService(ProductDB.class), DatabasePath+"Product.xml");
        try {
            productDB = (ProductDB) dbs.loadData();
        } catch (IOException io) {
            System.out.println("File isn't found, try running ProductDB test first");
        }
        dbs.setIDB(new XmlService(MemberDB.class));
        dbs.setDBPath(DatabasePath+"Members.xml");
        try {
            memberDB = (MemberDB) dbs.loadData();
        } catch (IOException io) {
            System.out.println("File isn't found, try running MemberDB test first");
        }
        testDB = new TransactionDB();
    }

    @AfterAll
    static void wrapUp() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new XmlService(ProductDB.class), DatabasePath+"Product_AfterTransaction.xml");
        dbs.saveData(productDB);
        dbs.setDBPath(DatabasePath + "TransactionDB.xml");
        dbs.setIDB(new XmlService(TransactionDB.class));
        dbs.saveData(testDB);
        dbs.setIDB(new ObjService(TransactionDB.class));
        dbs.setDBPath(DatabasePath + "TransactionDB.obj");
        dbs.saveData(testDB);
        dbs.setIDB(new JsonService(TransactionDB.class));
        dbs.setDBPath(DatabasePath + "TransactionDB.json");
        dbs.saveData(testDB);
    }

    @Test
    @Order(1)
    void insert() throws NoSuchEntryException {
        Bill cart = new Bill();
        assertFalse(cart.addToCart(productDB.select("1"), 1), "addToCart added 0 quantity product");
        cart.addToCart(productDB.select("4"), 350);
        assertFalse(cart.getCart().isEmpty(), "addToCart fails");

        //checkout as customer
        testDB.insert(cart.checkout());
        // by checkout, customercounter should increment
        assertEquals(1, CustomerCounter.count, "CustomerCounter did not increment");
        // testDB should not be empty
        assertFalse(testDB.toArrayList().isEmpty(), "testDB wasn't added an element");

        // reset cart
        cart.emptyCart();

        cart.addToCart(productDB.select("4"), 7);
        testDB.insert(cart.checkout(memberDB.select("1").getID()));
    }

    @Test
    @Order(2)
    void select() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new JsonService(TransactionDB.class), DatabasePath+"TransactionDB.json");
        testDB = (TransactionDB) dbs.loadData();
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}