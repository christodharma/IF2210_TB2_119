package GUI;

import App.Main;
import Products.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManajemenBarangGudang extends JPanel {

    JLabel textLabel;
    public Map<JLabel, String> ManajemenBarangGudang() throws IOException {
        String path = "src/main/resources/images/Tab Manajemen Barang.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Manajemen Barang Gudang.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);
        String[][] gudang = new String[Main.Products.getProducts().size()][5];
        ArrayList<Product> fromDB = Main.Products.getProducts();
        for (int i = 0; i < Main.Products.getProducts().size(); i++) {
            gudang[i][0] = String.valueOf(Main.Products.getProducts().get(i).getName());
            gudang[i][1] = String.valueOf(Main.Products.getProducts().get(i).getCategory());
            gudang[i][2] = String.valueOf(Main.Products.getProducts().get(i).getPrice());
            gudang[i][3] = String.valueOf(Main.Products.getProducts().get(i).getBuyPrice());
            gudang[i][4] = String.valueOf(Main.Products.getProducts().get(i).getQuantity());
        }
//        String[][] gudang = {
//                {"Donat","Makanan","4000","5000","5"},
//                {"Risoles","Makanan","7000","8000","6"},
//                {"Nasi Gila","Makanan","8000","9000","7"},
//                {"Nasi Goreng","Makanan","9000","1000","8"},
//                {"Kwetiauw","Makanan","10000","11000","9"},
//                {"Fanta susu","Minuman","5000","6000","10"},
//                {"Es Milo","Minuman","6000","6000","11"},
//                {"Donat","Makanan","4000","5000","5"},
//                {"Risoles","Makanan","7000","8000","6"},
//                {"Nasi Gila","Makanan","8000","9000","7"},
//                {"Nasi Goreng","Makanan","9000","1000","8"},
//                {"Kwetiauw","Makanan","10000","11000","9"},
//                {"Fanta susu","Minuman","5000","6000","10"},
//                {"Es Milo","Minuman","6000","6000","11"},
//                {"Donat","Makanan","4000","5000","5"},
//                {"Risoles","Makanan","7000","8000","6"},
//                {"Nasi Gila","Makanan","8000","9000","7"},
//                {"Nasi Goreng","Makanan","9000","1000","8"},
//                {"Kwetiauw","Makanan","10000","11000","9"},
//                {"Fanta susu","Minuman","5000","6000","10"},
//                {"Es Milo","Minuman","6000","6000","11"},
//                {"Donat","Makanan","4000","5000","5"},
//                {"Risoles","Makanan","7000","8000","6"},
//                {"Nasi Gila","Makanan","8000","9000","7"},
//                {"Nasi Goreng","Makanan","9000","1000","8"},
//                {"Kwetiauw","Makanan","10000","11000","9"},
//                {"Fanta susu","Minuman","5000","6000","10"},
//                {"Es Milo","Minuman","6000","6000","11"}
//        };

        textLabel = new JLabel("<html><div style='line-height: 5px;'>Kategori<br>Harga Jual<br>Harga Beli<br>Jumlah</html>");
        textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        textLabel.setBounds(902, 319, 108, 98);
        textLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(textLabel);


//          ruang scroll
        JScrollPane scrollPaneInventory = new JScrollPane();
        scrollPaneInventory.setBounds(73, 70, 692, 430);
        scrollPaneInventory.getVerticalScrollBar().setUnitIncrement(16); // Kecepatan scroll
        scrollPaneInventory.setBorder(null);
        scrollPaneInventory.setOpaque(false);
        scrollPaneInventory.getViewport().setOpaque(false);
        scrollPaneInventory.getVerticalScrollBar().setOpaque(false);
        scrollPaneInventory.getHorizontalScrollBar().setOpaque(false);
        scrollPaneInventory.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneInventory.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelMain.add(scrollPaneInventory);

        JPanel inventory = new JPanel();
        inventory.setLayout(new GridLayout((int)Math.ceil(gudang.length / 5.0), 5, 10, 10));
        inventory.setOpaque(false);

        JPanel showInventory = new JPanel();
        showInventory.setBounds(840, 80, 393, 370);
        showInventory.setOpaque(false);
        panelMain.add(showInventory);

        JLabel labelNamaBarang = new JLabel("");
        labelNamaBarang.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        labelNamaBarang.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNamaBarang.setForeground(Color.decode("#675D50"));
        showInventory.add(labelNamaBarang);

        JLabel labelKategori = new JLabel("");
        labelKategori.setFont(MainGUI.poppinsSemiBold.deriveFont(13f));
        labelKategori.setBounds(1040, 280, 108, 98);
        labelKategori.setForeground(Color.decode("#000000"));
        panelMain.add(labelKategori);

        JLabel labelHargaBarang = new JLabel("");
        labelHargaBarang.setFont(MainGUI.poppinsSemiBold.deriveFont(13f));
        labelHargaBarang.setBounds(1040, 348, 132, 13);
        labelHargaBarang.setForeground(Color.decode("#000000"));
        panelMain.add(labelHargaBarang);

        JLabel labelHargaBeli = new JLabel("");
        labelHargaBeli.setFont(MainGUI.poppinsSemiBold.deriveFont(13f));
        labelHargaBeli.setBounds(1040, 373, 132, 15);
        labelHargaBeli.setForeground(Color.decode("#000000"));
        panelMain.add(labelHargaBeli);

        JLabel labelJumlah = new JLabel("");
        labelJumlah.setFont(MainGUI.poppinsSemiBold.deriveFont(13f));
        labelJumlah.setBounds(1040, 397, 132, 15);
        labelJumlah.setForeground(Color.decode("#000000"));
        panelMain.add(labelJumlah);

        JLabel labelImageProduk = new JLabel();
        labelImageProduk.setPreferredSize(new Dimension(200,200));
        labelImageProduk.setBounds(980, 30, 393, 370);
        ImageIcon showProduk = new ImageIcon("");
        labelImageProduk.setIcon(showProduk);
        panelMain.add(labelImageProduk);

        for (int i = 0; i < gudang.length; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setPreferredSize(new Dimension(120, 150));
            panel.setBackground(Color.decode("#F3DEBA"));

            JLabel imageLabel = new JLabel();
            imageLabel.setBounds(10, 10, 100, 100);
            ImageIcon produk = new ImageIcon("src/main/resources/images/" + gudang[i][0] + ".png");
            imageLabel.setIcon(produk);
            panel.add(imageLabel);

            JButton button = new JButton(gudang[i][0]);
            button.setBounds(10, 120, 100, 20);
            panel.add(button);

            int finalI = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    labelNamaBarang.setText(gudang[finalI][0]);
                    labelKategori.setText(gudang[finalI][1]);
                    labelHargaBarang.setText(gudang[finalI][2]);
                    labelHargaBeli.setText(gudang[finalI][3]);
                    labelJumlah.setText(gudang[finalI][4]);
                    labelImageProduk.setIcon(new ImageIcon("src/main/resources/images/" + gudang[finalI][0] + ".png"));
                }
            });

            inventory.add(panel);
        }

        scrollPaneInventory.setViewportView(inventory);

        JButton tambahBarang = new JButton();
        JLabel tambahBarangText = new JLabel("Tambah Barang");
        tambahBarangText.setFont(MainGUI.poppinsSemiBold.deriveFont(17f));
        tambahBarangText.setForeground(Color.decode("#675D50"));
        tambahBarangText.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahBarangText.setAlignmentY(Component.CENTER_ALIGNMENT);
        tambahBarang.add(tambahBarangText);
        tambahBarang.setBounds(1055, 474, 175, 48);
        tambahBarang.setIcon(new ImageIcon("src/main/resources/images/Perbarui dan Tambah Barang.png"));
        tambahBarang.setBackground(Color.decode("#A9907E"));
        panelMain.add(tambahBarang);

        JButton perbaruiBarang = new JButton();
        JLabel perbaruiBarangText = new JLabel("Perbarui Barang");
        perbaruiBarangText.setFont(MainGUI.poppinsSemiBold.deriveFont(17f));
        perbaruiBarangText.setForeground(Color.decode("#675D50"));
        perbaruiBarangText.setAlignmentX(Component.CENTER_ALIGNMENT);
        perbaruiBarangText.setAlignmentY(Component.CENTER_ALIGNMENT);
        perbaruiBarang.add(perbaruiBarangText);
        perbaruiBarang.setBounds(835, 474, 175, 48);
        perbaruiBarang.setIcon(new ImageIcon("src/main/resources/images/Perbarui dan Tambah Barang.png"));
        perbaruiBarang.setBackground(Color.decode("#A9907E"));
        panelMain.add(perbaruiBarang);

        perbaruiBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    Perbarui halamanPerbarui = new Perbarui();
                    MainGUI.tabbedPane.addTabs(((Perbarui) halamanPerbarui).Perbarui());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        tambahBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    TambahBarang halamanTambah = new TambahBarang();
                    MainGUI.tabbedPane.addTabs(((TambahBarang) halamanTambah).TambahBarang());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Map < JLabel, String > panelLabel = new HashMap<>();
        panelLabel.put(panelMain, path);

        return panelLabel;
    }
}