package Database.Memberships;

import Database.DatabaseOperations;
import Memberships.Member;
import Exception.Database.NoSuchEntryException;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;

@Getter
@Setter
public class VIPDB implements Serializable, DatabaseOperations<Member> {
    private HashSet<Member> VIPs = new HashSet<>();

    @Override
    public void insert(Member element) {
        VIPs.add(element);
    }

    @Override
    public Member select(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(String.class)) {
            if (((String) keyword).matches("\\d+")){
                // keyword is ID string
                return VIPs.stream().filter(
                        member -> member.getID().contains((String) keyword))
                        .findFirst().orElseThrow(NoSuchEntryException::new);
            } else {
                // keyword is Name field
                return VIPs.stream().filter(
                        member -> member.getName().contains((String) keyword)
                ).findFirst().orElseThrow(NoSuchEntryException::new);
            }
        } else if (keyword.getClass().equals(Member.class) && VIPs.contains(keyword)) {
            return (Member) keyword;
        } else {
            throw new NoSuchEntryException();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object keyword) throws NoSuchEntryException {
        if (keyword.getClass().equals(VIPDB.class)){
            setVIPs(((VIPDB) keyword).getVIPs());
        } else if (keyword.getClass().equals(HashSet.class)) {
            HashSet<?> keywordSet = (HashSet<?>) keyword;
            for (Object i :
                    keywordSet) {
                if (i.getClass().equals(Member.class)){
                    HashSet<Member> VIPSet = (HashSet<Member>) keywordSet;
                    setVIPs(VIPSet);
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
        VIPs.remove(deleted);
        return deleted;
    }

    public boolean isVIP(Member member) {
        return VIPs.contains(member);
    }
}
