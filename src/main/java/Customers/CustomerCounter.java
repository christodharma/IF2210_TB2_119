package Customers;

import java.io.Serializable;

public class CustomerCounter implements Serializable {
    private static final long serialVersionUID = 5L;
    public static long count = 0;
    public void addCount() {
        count++;
    }
}
