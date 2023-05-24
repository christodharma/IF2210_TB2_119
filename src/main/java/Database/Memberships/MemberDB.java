package Database.Memberships;

import Database.Database;
import Database.DatabaseOperations;
import Memberships.Member;
import _119Exception.NoSuchEntryException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;

public class MemberDB extends Database<Member> implements DatabaseOperations<Member>, Serializable {
    private static final long serialVersionUID = 12L;
    @JsonProperty("contents")
    @JsonSerialize(keyUsing = MemberDBSerializer.class)
    public HashMap<String, Member> getHashMap(){
        return contents;
    }
    @Override
    public void insert(Member element){
        if (contents.containsValue(element)){
            throw new IllegalArgumentException("Member already exists");
        } else {
            contents.put(element.getID(), element);
        }
    }

    @Override
    public Member select(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(Member.class)){
            // keyword is member object
            return contents.get(((Member) keyword).getID());
        } else if (keyword.getClass().equals(String.class)) {
            if (((String) keyword).matches("\\d+")) {
                // keyword is ID string
                return contents.get(keyword);
            } else {
                // keyword is member name
                return contents.values().stream().filter(
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
            contents.replace(select(keyword).getID(), (Member) keyword);
        } else {
            throw new NoSuchEntryException("Wrong Class");
        }
    }

    @Override
    public Member delete(Object keyword) throws NoSuchEntryException {
        Member ret = select(keyword);
        contents.remove(select(keyword).getID());
        return ret;
    }
}
