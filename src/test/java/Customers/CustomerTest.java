package Customers;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerTest {
    @Test
    @Order(1)
    public void MembershipCounterisBoundToProgram(){
        //Counter may need to be stored
        System.out.println("test0");
        assertEquals("1", String.valueOf(Membership.Counter), "is not bound to program");
    }
    @Test
    @Order(2)
    public void shouldIncCustomerNo() {
        Customer myCustomer = new Customer();
        assertEquals("1", myCustomer.getID(), "ID isn't 1");
        Customer myCustomerInc = new Customer();
        assertEquals("2", myCustomerInc.getID(), "ID doesn't increment");
        assertTrue(myCustomer.getID()!= myCustomerInc.getID(), "same ID");
        System.out.println("myCustomer ID is " + myCustomer.getID());
        System.out.println("myCustomerInc ID is " + myCustomerInc.getID());
        System.out.println("Next Customer ID should be " + Membership.getCounter());
    }
    @Test
    @Order(3)
    public void MembershipCounterIsIndependant(){
        System.out.println("test2");
        assertNotEquals("1", String.valueOf(Membership.Counter), "is not bound");
    }
}