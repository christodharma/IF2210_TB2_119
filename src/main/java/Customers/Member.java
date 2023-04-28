package Customers;

import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    private final Customer customerRef;
    private String Name;
    private String Phone;
    private Integer Point;
    private Boolean Status;

    /**
     * Member constructor
     * @param customer Existing Customer class
     * @param newName Desired Member name
     * @param newPhone Desired Member phone number
     */
    public Member(Customer customer, String newName, String newPhone){
        this.customerRef = customer;
        this.Name = newName;
        this.Phone = newPhone;
        this.Point = 0;
        this.Status = true;
    }

    public String getName() {
        return Name;
    }
    public String getPhone() {
        return Phone;
    }

    public Integer getPoint() {
        return Point;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(String phone) { Phone = phone; }

    public void setPoint(Integer point) {
        Point = point;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }
}
