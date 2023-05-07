package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

public class ManajemenBarangGudang extends JPanel {

    JLabel textLabel;
        public Map<JLabel, String> ManajemenBarangGudang() throws IOException {
            String path = "src/main/resources/images/Tab Manajemen Barang.png";
            JLabel panelMain = new JLabel();
            ImageIcon bg = new ImageIcon("src/main/resources/images/Manajemen Barang Gudang.png");
            panelMain.setBounds(0, 90, 1280, 630);
            panelMain.setIcon(bg);

            textLabel = new JLabel("<html><div style='line-height: 5em;'>Kategori<br>Harga Barang<br>Harga Beli<br>Jumlah</html>");
            textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
            textLabel.setBounds(902, 319, 108, 98);
            textLabel.setForeground(Color.decode("#675D50"));
            panelMain.add(textLabel);

            textLabel = new JLabel("<html><div style='line-height: 5em;'>Nama Barang</html>");
            textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
            textLabel.setBounds(962, 81, 143, 30);
            textLabel.setForeground(Color.decode("#675D50"));
            panelMain.add(textLabel);

            JButton tambahBarang = new JButton();
            JLabel tambahBarangText = new JLabel("Perbarui");
            tambahBarangText.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
            tambahBarangText.setForeground(Color.decode("#675D50"));
            tambahBarangText.setAlignmentX(Component.CENTER_ALIGNMENT);
            tambahBarang.add(tambahBarangText);
            tambahBarang.setBounds(917, 458, 234, 64);
            tambahBarang.setIcon(new ImageIcon("src/main/resources/images/Perbarui1.png"));
            tambahBarang.setBackground(Color.decode("#A9907E"));
            panelMain.add(tambahBarang);

            tambahBarang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        Perbarui halamanPerbarui = new Perbarui();
                        MainGUI.tabbedPane.addTabs(((Perbarui) halamanPerbarui).Perbarui());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

                    Map < JLabel, String > panelLabel = new java.util.HashMap<>();
            panelLabel.put(panelMain, path);

            return panelLabel;
        }
    }