package oop.tubes2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowTransaction extends JPanel{

    public Map<JLabel, String> ShowTransaction(ArrayList<String[]> selectedIdList) throws IOException {
        for (int i = 0; i < selectedIdList.size(); i++) {
            System.out.println("Selected ID: " + selectedIdList.get(i)[0]);
        }

        String path = "src/main/resources/images/Tab Transaksi.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(215, 130-90, 880, 480);
        scrollPane.setBackground(Color.decode("#D9D9D9"));
        scrollPane.setBorder(null);
        panelMain.add(scrollPane);

        String[] attributes = {"No","Nama Barang","Kategori","Kuantitas","Harga"};
        String[][] data = new String[selectedIdList.size()][5];
        for (int i = 0; i < selectedIdList.size(); i++) {
            data[i][0] = Integer.toString(i+1);
            data[i][1] = selectedIdList.get(i)[2];
            data[i][2] = selectedIdList.get(i)[3];
            data[i][3] = selectedIdList.get(i)[4];
            data[i][4] = selectedIdList.get(i)[5];
            System.out.println(data[i][4]);
        }
        JTable table = new JTable(data,attributes);
        scrollPane.setViewportView(table);

        Map<JLabel, String> panelLabel = new HashMap<>();
        panelLabel.put(panelMain, path);

        return panelLabel;
    }
}
