package Customers;

import Database.DatabaseService.DatabaseService;
import Database.DatabaseService.ObjService;
import Exception.Database.ExtensionException;
import Model.Memberships.CustomerCounter;
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
        CustomerCounter.count = (long) dbs.loadData();
        assertEquals(0, CustomerCounter.count, "customerCount is not 0");
    }

    @Test
    @Order(2)
    void AddingAndSaveCount() throws ExtensionException, IOException {
        CustomerCounter.setID();
        CustomerCounter.setID();
        CustomerCounter.setID();
        CustomerCounter.setID();
        CustomerCounter.setID();
        assertNotEquals(0, CustomerCounter.count);
        System.out.println(0 + " vs "+CustomerCounter.count);
        DatabaseService dbs = new DatabaseService(new ObjService(CustomerCounter.count), "src/test/resources/system/customerCount.obj");
        dbs.saveData(CustomerCounter.count);
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