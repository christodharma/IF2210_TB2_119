package Customers;

import Bill.Bill;
import Bill.FixedBill;
import DatabaseService.DatabaseService;
import DatabaseService.JsonService;
import DatabaseService.ObjService;
import DatabaseService.XmlService;
import Exception.ExtensionException;
import Products.Product;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberDBTest {
    static MemberDB custDB;
    @BeforeAll
    public static void setUp(){
        custDB = new MemberDB();
        Bill cart = new Bill("123", "1");
        Product p = new Product("1", "Indomilk", 5000D, 4900D, "Food", "", 0);
        cart.addProduct(new Product("1", "Indomilk", 5000D, 4900D, "Food", "", 0));
        cart.addProduct(new Product("12", "Indomilk", 5000D, 4900D, "Food", "", 0));
        cart.addProduct(new Product("1", "Indomilk", 5000D, 4900D, "Food", "", 0));
        assertNotNull(cart);
        Member m1 = new Member(new Customer(new FixedBill("0", "1")), "Memi", "73577357");
        Member m2 = new Member(new Customer(new FixedBill("0", "1")), "Momo", "735715");
        Member m = new Member(new Customer(new FixedBill("0", "1")), "Mime", "7357");
        custDB.addMembership(m);
        custDB.addMembership(m1);
        custDB.addMembership(m2);
    }
    @Test
    @Order(1)
    public void MembersTest(){
        for (Member itr :
                custDB.Memberships) {
            assertNotEquals(Membership.Counter, itr.getID(), "Counter did not increment");
        }
    }

    @Test
    @Order(2)
    public void MemberDBSaveTest() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new ObjService(custDB), "src/test/resources/data/MembersTest.obj");
        dbs.saveData(custDB);
        File file = new File("src/test/resources/data/MembersTest.obj");
        assertTrue(file.exists());
    }

    @Test
    @Order(3)
    public void MemberDBLoadTest() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new ObjService(MemberDB.class), "src/test/resources/data/MembersTest.obj");
        MemberDB loaded = (MemberDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Member c :
                loaded.Memberships) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
//            System.out.println(c.getID());
        }
    }
    @Test
    @Order(4)
    public void MemberDBSaveTestJson() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new JsonService(custDB), "src/test/resources/data/MembersTest.json");
        dbs.saveData(custDB);
        File file = new File("src/test/resources/data/MembersTest.json");
        assertTrue(file.exists());
    }

    @Test
    @Order(5)
    public void MemberDBLoadTestJson() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new JsonService(MemberDB.class), "src/test/resources/data/MembersTest.json");
        MemberDB loaded = (MemberDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Member c :
                loaded.Memberships) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
            if (c.getName()==null){
                System.out.println(c.getID());
            } else {
                System.out.println(c.getID() + c.getName());
            }
        }
    }
    @Test
    @Order(6)
    public void MemberDBSaveTestXML() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new XmlService(custDB), "src/test/resources/data/MembersTest.xml");
        dbs.saveData(custDB);
        File file = new File("src/test/resources/data/MembersTest.xml");
        assertTrue(file.exists());
    }

    @Test
    @Order(7)
    public void MemberDBLoadTestXML() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new XmlService(MemberDB.class), "src/test/resources/data/MembersTest.xml");
        MemberDB loaded = (MemberDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Member c :
                loaded.Memberships) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
            if (c.getName()==null){
                System.out.println(c.getID());
            } else {
                System.out.println(c.getID() + c.getName());
            }
        }
    }
}