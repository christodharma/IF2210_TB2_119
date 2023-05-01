package Customers;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class VIP extends Membership implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    /**
     * @param memberRef reference to existing Member class
     */
    private final Member memberRef;
    private double DiscountRate = 0.1;

    /**
     * VIP Constructor as a new Member simultaneously
     * @param customer Existing Customer class
     * @param newName Desired Member name
     * @param newPhone Desired Member phone number
     * */
    public VIP(Customer customer, String newName, String newPhone){
        this.memberRef = new Member(customer, newName, newPhone);
    }
    @Override
    public String getID()
    {
        return memberRef.getCustomerRef().getID();
    }
}
