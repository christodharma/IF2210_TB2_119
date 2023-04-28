package Products;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
//    potential attributes: quantity
    protected String ID;
    protected double Price;
}
