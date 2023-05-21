package GUI.Call;

import Customers.Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeactivateMemberAction implements ActionListener {
    private Member member;

    public DeactivateMemberAction(Member member) {
        this.member = member;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        member.setStatus(false);
    }
}
