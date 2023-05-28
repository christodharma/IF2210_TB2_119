package GUI.Call;

import App.Main;
import Model.Memberships.Member;
import Exception.Database.NoSuchEntryException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMemberAction implements ActionListener {
    private Member member;
    private String name,phone;
    public UpdateMemberAction(String customerID, String Name, String Phone){
        try {
            member = Main.Members.select(customerID);
        } catch (NoSuchEntryException e) {
            throw new RuntimeException(e);
        }
        name = Name;
        phone = Phone;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Main.Members.select(member.getID()).setName(name);
            Main.Members.select(member.getID()).setPhone(phone);
        } catch (NoSuchEntryException ex) {
            throw new RuntimeException(ex);
        }
    }
}
