package Customers;

public class Member extends Customer{
    protected String Name;
    protected String Phone;
    protected Integer Point;
    protected Boolean Status;

    public Member(String newID, String newName, String newPhone){
        super(newID);
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

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setPoint(Integer point) {
        Point = point;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }
}
