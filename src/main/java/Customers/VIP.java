package Customers;

public class VIP extends Member{
    private Double DiscountRate = 0.1;

    public VIP(String newID, String newName, String newPhone){
        super(newID, newName, newPhone);
    }

    public Double getDiscountRate() {
        return DiscountRate;
    }

    public void setDiscountRate(Double discountRate) {
        DiscountRate = discountRate;
    }
}
