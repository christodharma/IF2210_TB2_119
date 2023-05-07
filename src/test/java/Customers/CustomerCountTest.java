package Customers;

import DatabaseService.DatabaseService;
import DatabaseService.ObjService;
import Exception.ExtensionException;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerCountTest {
    static DatabaseService dbs = new DatabaseService(new ObjService(Long.class), "src/test/resources/system/customerCount.obj");

    //Load customer count
    @Test
    @Order(1)
    void LoadCustomerCountTest() throws ExtensionException, IOException {
        Membership.Counter = (long) dbs.loadData();
        assertEquals(0, Membership.Counter, "customerCount is not 0");
    }

    @Test
    @Order(2)
    void AddingAndSaveCount() throws ExtensionException, IOException {
        CustomerDB cdb = new CustomerDB();
        cdb.addMembership();
        cdb.addMembership();
        cdb.addMembership();
        cdb.addMembership();
        cdb.addMembership();
        assertNotEquals(0, Membership.getCounter());
        System.out.println(0 + " vs "+Membership.getCounter());
        DatabaseService dbs = new DatabaseService(new ObjService(Membership.getCounter()), "src/test/resources/system/customerCount.obj");
        dbs.saveData(Membership.getCounter());
//        new customerCount is saved, customerCount should not be 0 next time
    }
    @Test
    @Order(3)
    void LoadNewCustomerCount() throws ExtensionException, IOException {
        long a = (long) dbs.loadData(); //a = 5
        assertNotEquals(0, a);
    }
    @AfterAll @BeforeAll
    static void Set0customerCount() throws ExtensionException, IOException {
        dbs.saveData(0L);
    }
}