package GUI.Call;

import GUI.JualBarang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SaveBillAction implements ActionListener {
    private String[] SaveBill;

    public SaveBillAction(String[] saveBill) {
        SaveBill = saveBill;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[][] NewSaveBill = Arrays.copyOf(JualBarang.saveBill, JualBarang.saveBill.length+1);
        NewSaveBill[NewSaveBill.length] = SaveBill;
        JualBarang.saveBill = NewSaveBill;
    }
}
