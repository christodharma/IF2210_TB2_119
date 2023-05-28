package Database.Memberships;

import Database.Database;
import Database.DatabaseOperations;
import Model.Memberships.Member;
import Exception.Database.NoSuchEntryException;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashSet;

public class VIPDB extends Database<Member> implements Serializable, DatabaseOperations<Member> {

    @JsonProperty("contents")
    private HashSet<Member> getSet() {
        return contents;
    }

    @Override
    public void insert(Member element) throws NoSuchEntryException {
        if (contents.add(element)){
            return;
        } else {
            throw new NoSuchEntryException("element exists");
        }
    }

    @Override
    public Member select(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(String.class)) {
            if (((String) keyword).matches("\\d+")){
                // keyword is ID string
                return contents.stream().filter(
                        member -> member.getID().contains((String) keyword))
                        .findFirst().orElseThrow(NoSuchEntryException::new);
            } else {
                // keyword is Name field
                return contents.stream().filter(
                        member -> member.getName().contains((String) keyword)
                ).findFirst().orElseThrow(NoSuchEntryException::new);
            }
        } else if (keyword.getClass().equals(Member.class) && contents.contains(keyword)) {
            return (Member) keyword;
        } else {
            throw new NoSuchEntryException();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(VIPDB.class)){
            contents = ((VIPDB) keyword).contents;
        } else if (keyword.getClass().equals(HashSet.class)) {
            HashSet<?> keywordSet = (HashSet<?>) keyword;
            for (Object i :
                    keywordSet) {
                if (i.getClass().equals(Member.class)){
                    contents = (HashSet<Member>) keywordSet;
                    break;
                }
                break;
            }
        } else {
            throw new NoSuchEntryException();
        }
    }

    @Override
    public Member delete(Object keyword) throws NoSuchEntryException {
        Member deleted = select(keyword);
        contents.remove(deleted);
        return deleted;
    }
    public boolean isVIP(Member member) {
        return contents.contains(member);
    }
}
