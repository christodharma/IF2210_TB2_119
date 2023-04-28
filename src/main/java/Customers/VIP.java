package Customers;

import java.io.Serializable;

public class VIP implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    private Member memberRef;
    private double DiscountRate = 0.1;
    /**
     * VIP Constructor as an upgrade from Member
     * @param member Existing Member class
     * */
    public VIP(Member member){
        this.memberRef = member;
    }
    /**
     * VIP Constructor as a new Member simultaneously
     * @param customer Existing Customer class
     * @param newName Desired Member name
     * @param newPhone Desired Member phone number
     * */
    public VIP(Customer customer, String newName, String newPhone){
        this.memberRef = new Member(customer, newName, newPhone);
    }

    public double getDiscountRate() {
        return DiscountRate;
    }

    public void setDiscountRate(Double discountRate) {
        DiscountRate = discountRate;
    }
}
