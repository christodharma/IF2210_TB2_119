package GUI.Call;

import App.Main;
import Customers.Customer;
import Customers.Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static App.Main.Members;

public class DaftarMemberAction implements ActionListener {
    private Customer customerRef;
    private String name, phone;
    public DaftarMemberAction(String customerID, String name, String phone) {
        this.customerRef = Main.Customers.find(customerID);
        this.name = name;
        this.phone = phone;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Member n = new Member(customerRef, name, phone);
        Members.addMembership(n);
    }
}
