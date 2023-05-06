package oop.tubes2;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class JualBarang extends JPanel {
    JLabel textLabel;
    private String path;
    private JLabel panelMain;
    public Map<JLabel, String> JualBarang() throws IOException {
        String path = "src/main/resources/images/Tab Jual Barang.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        Map<JLabel, String> panelLabel = new java.util.HashMap<>();
        panelLabel.put(panelMain, path);

        JLabel gambarLabel = new JLabel("Gambar");
        gambarLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        gambarLabel.setForeground(Color.decode("#675D50"));
        gambarLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        gambarLabel.setVerticalTextPosition(JLabel.CENTER);
        gambarLabel.setHorizontalTextPosition(JLabel.CENTER);
        gambarLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gambarLabel.setBounds(20,25,133,43);
        panelMain.add(gambarLabel);

        JLabel namaBarangLabel = new JLabel("Nama Barang");
        namaBarangLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        namaBarangLabel.setForeground(Color.decode("#675D50"));
        namaBarangLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        namaBarangLabel.setVerticalTextPosition(JLabel.CENTER);
        namaBarangLabel.setHorizontalTextPosition(JLabel.CENTER);
        namaBarangLabel.setHorizontalAlignment(SwingConstants.CENTER);
        namaBarangLabel.setBounds(153,25,133,43);
        panelMain.add(namaBarangLabel);

        JLabel hargaLabel = new JLabel("Harga Barang");
        hargaLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        hargaLabel.setForeground(Color.decode("#675D50"));
        hargaLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        hargaLabel.setVerticalTextPosition(JLabel.CENTER);
        hargaLabel.setHorizontalTextPosition(JLabel.CENTER);
        hargaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        hargaLabel.setBounds(286,25,133,43);
        panelMain.add(hargaLabel);

        JLabel kategoriLabel = new JLabel("Kategori");
        kategoriLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        kategoriLabel.setForeground(Color.decode("#675D50"));
        kategoriLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        kategoriLabel.setVerticalTextPosition(JLabel.CENTER);
        kategoriLabel.setHorizontalTextPosition(JLabel.CENTER);
        kategoriLabel.setHorizontalAlignment(SwingConstants.CENTER);
        kategoriLabel.setBounds(419,25,133,43);
        panelMain.add(kategoriLabel);

        JLabel kuantitasLabel = new JLabel("Kuantitas");
        kuantitasLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        kuantitasLabel.setForeground(Color.decode("#675D50"));
        kuantitasLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        kuantitasLabel.setVerticalTextPosition(JLabel.CENTER);
        kuantitasLabel.setHorizontalTextPosition(JLabel.CENTER);
        kuantitasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        kuantitasLabel.setBounds(552,25,133,43);
        panelMain.add(kuantitasLabel);

        String[][] data = {{"Donat","Makanan","4000","5000","5"},{"Risoles","Makanan","7000","8000","7"},{"Nasi Gila","Makanan","11000","13000","10"}};

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.decode("#ABC4AA"));
        for (int i = 0; i < data.length; i++) {
            JPanel panelX = new JPanel();
            panelX.setLayout(new BoxLayout(panelX, BoxLayout.X_AXIS));

            JLabel gambar = new JLabel("");
            gambar.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
            gambar.setForeground(Color.decode("#675D50"));
            gambar.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
            gambar.setVerticalTextPosition(JLabel.CENTER);
            gambar.setHorizontalTextPosition(JLabel.CENTER);
            gambar.setHorizontalAlignment(SwingConstants.CENTER);
            gambar.setPreferredSize(new Dimension(133,75));
            panelX.add(gambar);

            JLabel nama = new JLabel(data[i][0]);
            nama.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
            nama.setForeground(Color.decode("#675D50"));
            nama.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
            nama.setVerticalTextPosition(JLabel.CENTER);
            nama.setHorizontalTextPosition(JLabel.CENTER);
            nama.setHorizontalAlignment(SwingConstants.CENTER);
            nama.setPreferredSize(new Dimension(133,75));
            panelX.add(nama);

            JLabel harga = new JLabel(data[i][3]);
            harga.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
            harga.setForeground(Color.decode("#675D50"));
            harga.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
            harga.setVerticalTextPosition(JLabel.CENTER);
            harga.setHorizontalTextPosition(JLabel.CENTER);
            harga.setHorizontalAlignment(SwingConstants.CENTER);
            harga.setPreferredSize(new Dimension(133,75));
            panelX.add(harga);

            JLabel kategori = new JLabel(data[i][1]);
            kategori.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
            kategori.setForeground(Color.decode("#675D50"));
            kategori.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
            kategori.setVerticalTextPosition(JLabel.CENTER);
            kategori.setHorizontalTextPosition(JLabel.CENTER);
            kategori.setHorizontalAlignment(SwingConstants.CENTER);
            kategori.setPreferredSize(new Dimension(133,75));
            panelX.add(kategori);

//            JPanel panelKuantitas = new JPanel();
//            panelKuantitas.setPreferredSize(new Dimension(133,75));
//            int max = Integer.parseInt(data[i][4]);
//            SpinnerModel value = new SpinnerNumberModel(0, 0, max, 1);
//            JSpinner kuantitasSpinner = new JSpinner(value);
//            JFormattedTextField txt = ((JSpinner.NumberEditor)kuantitasSpinner.getEditor()).getTextField();
//            ((NumberFormatter)txt.getFormatter()).setAllowsInvalid(false);
//            txt.setColumns(5);
//            kuantitasSpinner.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
//            kuantitasSpinner.setForeground(Color.decode("#675D50"));
//            panelKuantitas.add(kuantitasSpinner);
//            panelX.add(panelKuantitas);

            int max = Integer.parseInt(data[i][4]);
            SpinnerModel value = new SpinnerNumberModel(0, 0, max, 1);
            JSpinner kuantitasSpinner = new JSpinner(value);
            JFormattedTextField txt = ((JSpinner.NumberEditor)kuantitasSpinner.getEditor()).getTextField();
            ((NumberFormatter)txt.getFormatter()).setAllowsInvalid(false);
            txt.setColumns(5);
            kuantitasSpinner.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
            kuantitasSpinner.setForeground(Color.decode("#675D50"));
            panelX.add(kuantitasSpinner);

            panel.add(panelX);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(20, 182-90, 665, 427);
        scrollPane.setBackground(Color.decode("#ABC4AA"));
        scrollPane.setBorder(null);
        panelMain.add(scrollPane);

        return panelLabel;
    }
}
