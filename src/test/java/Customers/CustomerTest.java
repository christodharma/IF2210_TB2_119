package Customers;

import org.junit.jupiter.api.Test;

import static Customers.Customer.customerNo;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void shouldIncCustomerNo() {
        Customer myCustomer = new Customer();
        assertEquals("0", myCustomer.getID(), "ID isn't 0");
        Customer myCustomerInc = new Customer();
        assertEquals("1", myCustomerInc.getID(), "ID isn't 1");
        assertTrue(myCustomer.getID()!= myCustomerInc.getID(), "same ID");
        System.out.println("myCustomer ID is " + myCustomer.getID());
        System.out.println("myCustomerInc ID is " + myCustomerInc.getID());
        System.out.println("Next Customer ID should be " + customerNo);
    }
}