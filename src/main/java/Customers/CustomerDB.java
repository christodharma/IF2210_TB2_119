package Customers;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;

public class CustomerDB extends MembershipDB<Customer> implements Serializable {
    private static final long serialVersionUID = 12L;
    public CustomerDB(){
        super();
    }
    public CustomerDB(ArrayList<Customer> customers){
        super(customers);
    }
    public void addMembership(){
        Memberships.add(new Customer());
    }
    @JsonProperty("customer")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public ArrayList<Customer> getMemberships(){
        return Memberships;
    }
    public void resetCustomerCount(){Membership.Counter = 0;}
}
