package History;

import Bill.Bill;
import Bill.FixedBill;
import Customers.Customer;
import Customers.Membership;
import DatabaseService.DatabaseService;
import DatabaseService.ObjService;
import DatabaseService.XmlService;
import Exception.ExtensionException;
import lombok.NonNull;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.IOException;

import static Products.ProductCollectionTest.templateProductCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionHistoryTest {

    public static FixedBill templateBill(@NonNull Customer buyer){
        Bill cart = new Bill(buyer);
        templateProductCollection(cart);
        return new FixedBill(cart);
    }
    @Test
    @Order(1)
    void TransactionHistorySave() throws ExtensionException, IOException {
        FixedBill b = templateBill(new Customer());
        TransactionHistory h = new TransactionHistory();
        h.addHistory(b);
        h.addHistory(b);
        h.addHistory(b);
        h.addHistory(b);
        h.addHistory(b);
        DatabaseService dbs = new DatabaseService(new XmlService(TransactionHistory.class), "src/test/resources/data/TransactionHistory.xml");
        dbs.saveData(h);
        dbs.setIDB(new ObjService(Membership.getCounter()));
        dbs.setDBPath("src/test/resources/data/customerCount.obj");
        System.out.println(Membership.getCounter());
        dbs.saveData(Membership.getCounter());
        File fileCheck = new File("src/test/resources/data/TransactionHistory.xml");
        File fileCheckCustCount = new File("src/test/resources/data/customerCount.obj");
        assertTrue(fileCheck.exists());
        assertTrue(fileCheckCustCount.exists());
        long a = (long) dbs.loadData();
        assertEquals(a, Membership.getCounter());
        dbs.setIDB(new ObjService(Long.class));
    }
}