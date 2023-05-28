package Database.Memberships;

import Database.Database;
import Database.DatabaseOperations;
import Model.Memberships.Member;
import Database.MappingFromID;
import Exception.Database.NoSuchEntryException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class MemberDB extends Database<Member> implements DatabaseOperations<Member>, Serializable, MappingFromID<Member> {
    private static final long serialVersionUID = 12L;
    @JsonProperty("contents")
    public HashSet<Member> getSet(){
        return contents;
    }
    @JsonIgnore
    private HashMap<String, Member> MemberMap = toMap(contents);
    @Override
    public void insert(Member element){
        if (contents.add(element)){
            MemberMap.put(element.getID(), element);
        } else {
            throw new IllegalArgumentException("Member already exists");
        }
    }

    @Override
    public Member select(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(Member.class)){
            // keyword is member object
            return MemberMap.get(((Member) keyword).getID());
        } else if (keyword.getClass().equals(String.class)) {
            if (((String) keyword).matches("\\d+")) {
                // keyword is ID string
                return MemberMap.get(keyword);
            } else {
                // keyword is member name
                return MemberMap.values().stream().filter(
                        member -> member.getName().contains((String) keyword)
                ).findFirst().orElseThrow(NoSuchEntryException::new);
            }
        } else {
            throw new NoSuchEntryException();
        }
    }

    @Override
    public void update(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(Member.class)) {
            MemberMap.replace(select(keyword).getID(), (Member) keyword);
        } else {
            throw new NoSuchEntryException("Wrong Class");
        }
    }

    @Override
    public Member delete(Object keyword) throws NoSuchEntryException {
        Member ret = select(keyword);
        MemberMap.remove(ret.getID());
        contents.remove(ret);
        return ret;
    }
}
