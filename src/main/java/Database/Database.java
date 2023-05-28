package Database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;


public abstract class Database<T> implements Serializable {
    private static final long serialVersionUID = 10L;
    // TODO: Database format change
    // TODO: JDBC Connector
    // TODO?: Bonus lain
    // TODO: Database might be better in public static
    @JsonIgnore
    protected HashSet<T> contents = new HashSet<>();

    @JsonIgnore
    public ArrayList<T> toArrayList() {
        return new ArrayList<>(contents);
    }
}
