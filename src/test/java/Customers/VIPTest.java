package Customers;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VIPTest {
    // Testing if run all at once, static variable follows in one program
    @Test
    @Order(1)
    public void createVIPFromMember()
    {
        Customer c = new Customer();
        assertEquals("0", c.getID(), "c ID is not 0");
        Member m = new Member(c, "MemberName", "73577347");
        assertEquals("0", m.getCustomerRef().getID(), "m ID is not 0");
        VIP v = new VIP(m);
        assertEquals("0", v.getMemberRef().getCustomerRef().getID(), "m ID is not 0");
        assertEquals(0.1, v.getDiscountRate(), "Discount not 10%");
    }
    @Test
    @Order(2)
    public void createVIPFromCustomer()
    {
        Customer c1 = new Customer();
        assertEquals("1", c1.getID(), "c1 ID is not 1");
        VIP v = new VIP(c1, "VIPname", "73577357");
        assertEquals("1", v.getMemberRef().getCustomerRef().getID(), "m ID is not 1");
        assertEquals(0.1, v.getDiscountRate(), "Discount not 10%");
    }
}