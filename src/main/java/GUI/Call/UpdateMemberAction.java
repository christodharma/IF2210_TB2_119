package GUI.Call;

import App.Main;
import Customers.Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMemberAction implements ActionListener {
    private Member member;
    private String name,phone;
    public UpdateMemberAction(String customerID, String Name, String Phone){
        member = Main.Members.find(customerID);
        name = Name;
        phone = Phone;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.Members.find(member.getID()).setName(name);
        Main.Members.find(member.getID()).setPhone(phone);
    }
}
