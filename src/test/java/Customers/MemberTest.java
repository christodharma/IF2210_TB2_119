package Customers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    public void validCustomerRef()
    {
        Customer c = new Customer(); // Customer has made transaction
        Member m = new Member(c, "Christophorus", "0341710327");
        assertEquals("0", m.getCustomerRef().getID(),"ID is not 0");
        Customer c1 = new Customer();
        Member m1 = new Member(c1, "Dharma", "12341234");
        assertEquals("1", m1.getCustomerRef().getID(), "ID is not 1");
    }
}