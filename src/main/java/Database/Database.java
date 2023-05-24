package Database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public abstract class Database<T> implements Serializable {
    private static final long serialVersionUID = 10L;
    @JsonIgnore
    protected HashMap<String, T> contents = new HashMap<>();
    @JsonIgnore
    public ArrayList<T> toArrayList() {
        return new ArrayList<T>(contents.values());
    }
}
