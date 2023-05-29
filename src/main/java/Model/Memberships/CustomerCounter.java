package Model.Memberships;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
@JsonRootName("customerCount")
public class CustomerCounter implements Serializable {
    private static final long serialVersionUID = 5L;
    public static long count = 0;
    public static void addCount() {
        count++;
    }

    public static String setID(){
        addCount();
        return String.valueOf(count);
    }
}
