package Customers;

import lombok.*;

import java.io.Serializable;

@Setter

public class Customer extends Membership implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    private final String ID;
    public static int customerNo = 0;
    //need to be changed to current customer count in database instead
    public Customer()
    {
        this.ID = String.valueOf(customerNo);
        customerNo++;
    }
    @Override
    public String getID()
    {
        return ID;
    }
}
