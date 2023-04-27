package Customers;

import java.io.Serializable;

public class Customer implements Serializable {
    protected String ID;

    public Customer(String newID){
        this.ID = newID;
    }

    public String getID() {
        return ID;
    }
    public void setID(String customerID) {
        ID = customerID;
    }
}
