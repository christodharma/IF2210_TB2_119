package Customers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MemberDB extends MembershipDB<Member>{
    private static final long serialVersionUID = 12L;
    public MemberDB(){
        super();
    }
    public MemberDB(ArrayList<Member> members){
         super(members);
    }
    @JsonProperty("members")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ArrayList<Member> getMemberships(){
        return Memberships;
    }
}
