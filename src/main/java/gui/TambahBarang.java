package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TambahBarang extends JPanel{
    JLabel textLabel;
    public Map<JLabel, String> TambahBarang() throws IOException {
        String path = "src/main/resources/images/Tab Tambah Barang.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        textLabel = new JLabel("<html><div style='line-height: 5em;'>ID Barang<br>Nama Barang<br>Harga Jual<br>Harga Beli<br>Kategori<br>Stok Barang<br>Gambar</html>");
        textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        textLabel.setBounds(191, 65, 300, 370);
        textLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(textLabel);


        JTextField id = new JTextField();
        id.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        id.setBounds(641, 80, 447, 35);
        id.setForeground(Color.decode("#675D50"));
        panelMain.add(id);

        JTextField namaBarang = new JTextField();
        namaBarang.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        namaBarang.setBounds(641, 130, 447, 35);
        namaBarang.setForeground(Color.decode("#675D50"));
        namaBarang.setBorder(null);
        panelMain.add(namaBarang);

        JTextField hargaJual = new JTextField();
        hargaJual.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        hargaJual.setBounds(641, 180, 447, 35);
        hargaJual.setForeground(Color.decode("#675D50"));
        hargaJual.setBorder(null);
        panelMain.add(hargaJual);

        JTextField hargaBeli = new JTextField();
        hargaBeli.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        hargaBeli.setBounds(641, 230, 447, 35);
        hargaBeli.setForeground(Color.decode("#675D50"));
        hargaBeli.setBorder(null);
        panelMain.add(hargaBeli);

        JTextField kategori = new JTextField();
        kategori.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        kategori.setBounds(641, 280, 447, 35);
        kategori.setForeground(Color.decode("#675D50"));
        kategori.setBorder(null);
        panelMain.add(kategori);

        JTextField stokBarang = new JTextField();
        stokBarang.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        stokBarang.setBounds(641, 330, 447, 35);
        stokBarang.setForeground(Color.decode("#675D50"));
        stokBarang.setBorder(null);
        panelMain.add(stokBarang);

        //            membuat button pilih gambar
        JButton pilihGambar = new JButton();
        JLabel pilihGambarText = new JLabel("Pilih Gambar");
        pilihGambarText.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        pilihGambarText.setForeground(Color.decode("#675D50"));
        pilihGambarText.setAlignmentX(CENTER_ALIGNMENT);
        pilihGambar.add(pilihGambarText);
        pilihGambar.setBounds(640, 390, 150, 35);
        pilihGambar.setIcon(new ImageIcon("src/main/resources/images/Pilih Gambar.png"));
        pilihGambar.setBackground(Color.decode("#A9907E"));
        panelMain.add(pilihGambar);
        //            membuat action yang dapat mengambil gambar dari file lokal
        //            pilihGambar.addActionListener(e -> {
        //                JFileChooser fileChooser = new JFileChooser();
        //                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        //                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        //                fileChooser.addChoosableFileFilter(filter);
        //                int result = fileChooser.showSaveDialog(null);
        //                if (result == JFileChooser.APPROVE_OPTION) {
        //                    File selectedFile = fileChooser.getSelectedFile();
        //                    String pathGambar = selectedFile.getAbsolutePath();
        //                    ImageIcon myImage = new ImageIcon(pathGambar);
        //                    Image img = myImage.getImage();
        //                    Window gambar = null;
        //                    Image newImg = img.getScaledInstance(gambar.getWidth(), gambar.getHeight(), Image.SCALE_SMOOTH);
        //                    ImageIcon image = new ImageIcon(newImg);
        //                    gambar.setIcon(image);
        //
        //                } else if (result == JFileChooser.CANCEL_OPTION) {
        //                    System.out.println("No Data");
        //                }
        //            });

        JButton tambahButton = new JButton();
        JLabel tambahText = new JLabel("Tambah Barang");
        tambahText.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        tambahText.setForeground(Color.decode("#675D50"));
        tambahText.setAlignmentX(CENTER_ALIGNMENT);
        tambahButton.add(tambahText);
        tambahButton.setBounds(552, 465, 175, 48);
        tambahButton.setIcon(new ImageIcon("src/main/resources/images/Perbarui dan Tambah Barang.png"));
        tambahButton.setBackground(Color.decode("#A9907E"));
        panelMain.add(tambahButton);

        //        jika menekan tombol tambahBarang, maka akan menambah data yang ada di database dan menampilkan pesan berhasil, lalu menghapus isi JTextField menjadi kosong
        tambahButton.addActionListener(e -> {
            //            try {
            //                Barang barang = new Barang();
            //                barang.setIdBarang(id.getText());
            //                barang.setNamaBarang(namaBarang.getText());
            //                barang.setHargaJual(Integer.parseInt(hargaJual.getText()));
            //                barang.setHargaBeli(Integer.parseInt(hargaBeli.getText()));
            //                barang.setKategori(kategori.getText());
            //                barang.setStokBarang(Integer.parseInt(stokBarang.getText()));
            //                barang.setGambar("src/main/resources/images/Barang/" + id.getText() + ".png");
            //                barang.tambahBarang();
            JOptionPane.showMessageDialog(null, "Berhasil Menambah Barang");
            id.setText("");
            namaBarang.setText("");
            hargaJual.setText("");
            hargaBeli.setText("");
            kategori.setText("");
            stokBarang.setText("");
            //            } catch (Exception exception) {
            //                JOptionPane.showMessageDialog(null, "Gagal Menambah Barang");
            //            }
        });


        Map<JLabel, String> panelLabel = new HashMap<>();
        panelLabel.put(panelMain, path);

        return panelLabel;
    }
}