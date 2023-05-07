package Customers;

import lombok.AccessLevel;
import lombok.Getter;

import java.io.Serializable;

public abstract class Membership implements Serializable {
    private static final long serialVersionUID = 20L;
    public int purchaseCount;
@Getter(AccessLevel.PUBLIC)
    protected static long Counter = 0;

    public abstract String getID();
}
