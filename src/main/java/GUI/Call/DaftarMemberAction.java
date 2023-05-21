package GUI.Call;

import Customers.Customer;
import Customers.Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DaftarMemberAction implements ActionListener {
    private Customer customerRef;
    private String name, phone;
    public DaftarMemberAction(Customer c, String name, String phone) {
        this.customerRef = c;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Member n = new Member(customerRef, name, phone);
//      masukin database
    }
}
