package Customers;

import lombok.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class MembershipDB<T extends Membership> implements Serializable {
    private static final long serialVersionUID = 12L;
    protected ArrayList<T> Memberships;
    public MembershipDB(){
        Memberships = new ArrayList<>();
    }
    public MembershipDB(ArrayList<T> memberships){
        Memberships = memberships;
    }
    public T find(String ID){
        for (T itr :
                Memberships) {
            if (itr.getID().equals(ID))
            {
                return itr;
            }
        }
        return null;
    }
    public void addMembership(@NonNull T added){
        if (find(added.getID())==null){
            Memberships.add(added);
        }
    }
    // MembershipDB can not remove customer, so Delete is not implemented
}
