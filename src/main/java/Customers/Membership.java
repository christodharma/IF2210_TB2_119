package Customers;

import java.io.Serializable;

public abstract class Membership implements Serializable {
    private static final long serialVersionUID = 20L;
    protected static long Counter = 0;
    public abstract String getID();
    public static long getCounter(){
        return Counter;
    }
}
