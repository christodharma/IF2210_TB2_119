package Customers;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class Member extends Membership implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    /**
     * @param customerRef Reference to existing Customer class
     * @param Name Desired Member Name
     * @param Phone Desired Member Phone number
     */
    private final Customer customerRef;
    @NonNull private String Name;
    @NonNull private String Phone;

    private int Point = 0;
    private boolean Status = true;
    @Override
    public String getID()
    {
        return customerRef.getID();
    }
}
