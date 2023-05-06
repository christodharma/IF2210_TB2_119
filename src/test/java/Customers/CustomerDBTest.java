package Customers;

import DatabaseService.DatabaseService;
import DatabaseService.JsonService;
import DatabaseService.ObjService;
import DatabaseService.XmlService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import Exception.ExtensionException;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerDBTest {
    public void templateCustomersDBAdd(CustomerDB custDB){
        Customer c = new Customer();
        custDB.addMembership(c);
        custDB.addMembership();
    }
    @Test
    @Order(1)
    public void CustomersTest(){
        CustomerDB custDB = new CustomerDB();
        templateCustomersDBAdd(custDB);
        for (Customer itr :
                custDB.Memberships) {
            assertNotEquals(Membership.Counter, itr.getID(), "Counter did not increment");
        }
    }

    @Test
    @Order(2)
    public void CustomerDBSaveTest() throws ExtensionException, IOException {
        CustomerDB custDB = new CustomerDB();
        templateCustomersDBAdd(custDB);
        templateCustomersDBAdd(custDB);
        templateCustomersDBAdd(custDB);
        templateCustomersDBAdd(custDB);
        DatabaseService dbs = new DatabaseService(new ObjService(custDB), "src/test/resources/data/Customers.obj");
        dbs.saveData(custDB);
        File file = new File("src/test/resources/data/Customers.obj");
        assertTrue(file.exists());
    }

    @Test
    @Order(3)
    public void CustomerDBLoadTest() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new ObjService(CustomerDB.class), "src/test/resources/data/Customers.obj");
        CustomerDB loaded = (CustomerDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Customer c :
                loaded.Memberships) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
//            System.out.println(c.getID());
        }
    }
    @Test
    @Order(4)
    public void CustomerDBSaveTestJson() throws ExtensionException, IOException {
        CustomerDB custDB = new CustomerDB();
        templateCustomersDBAdd(custDB);
        templateCustomersDBAdd(custDB);
        templateCustomersDBAdd(custDB);
        templateCustomersDBAdd(custDB);
        DatabaseService dbs = new DatabaseService(new JsonService(custDB), "src/test/resources/data/Customers.json");
        dbs.saveData(custDB);
        File file = new File("src/test/resources/data/Customers.json");
        assertTrue(file.exists());
    }

    @Test
    @Order(5)
    public void CustomerDBLoadTestJson() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new JsonService(CustomerDB.class), "src/test/resources/data/Customers.json");
        CustomerDB loaded = (CustomerDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Customer c :
                loaded.Memberships) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
            System.out.println(c.getID());
        }
    }
    @Test
    @Order(6)
    public void CustomerDBSaveTestXML() throws ExtensionException, IOException {
        CustomerDB custDB = new CustomerDB();
        templateCustomersDBAdd(custDB);
        templateCustomersDBAdd(custDB);
        templateCustomersDBAdd(custDB);
        templateCustomersDBAdd(custDB);
        DatabaseService dbs = new DatabaseService(new XmlService(custDB), "src/test/resources/data/Customers.xml");
        dbs.saveData(custDB);
        File file = new File("src/test/resources/data/Customers.xml");
        assertTrue(file.exists());
    }

    @Test
    @Order(7)
    public void CustomerDBLoadTestXML() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new XmlService(CustomerDB.class), "src/test/resources/data/Customers.xml");
        CustomerDB loaded = (CustomerDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Customer c :
                loaded.Memberships) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
            System.out.println(c.getID());
        }
    }
}