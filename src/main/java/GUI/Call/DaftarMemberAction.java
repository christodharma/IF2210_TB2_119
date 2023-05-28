package GUI.Call;

import Model.Memberships.Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static App.Main.Members;

public class DaftarMemberAction implements ActionListener {
    private String customerID;
    private String name, phone;
    public DaftarMemberAction(String customerID, String name, String phone) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Member n = new Member(customerID, name, phone);
        Members.insert(n);
    }
}
