package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

public class Perbarui extends JPanel {

    JLabel textLabel;
    public Map<JLabel, String> Perbarui() throws IOException {
        String path = "src/main/resources/images/Tab Perbarui.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        textLabel = new JLabel("<html><div style='line-height: 5em;'>ID Barang<br>Nama Barang<br>Harga Jual<br>Harga Beli<br>Kategori<br>Stok Barang<br>Gambar</html>");
        textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        textLabel.setBounds(191, 65, 300, 370);
        textLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(textLabel);

        String[] idList = {"001", "002", "003", "004"};

        JComboBox id = new JComboBox(idList);
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


        JButton pilihGambar = new JButton();
        JLabel pilihGambarText = new JLabel("Pilih Gambar");
        pilihGambarText.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        pilihGambarText.setForeground(Color.decode("#675D50"));
        pilihGambarText.setAlignmentX(Component.CENTER_ALIGNMENT);
        pilihGambar.add(pilihGambarText);
        pilihGambar.setBounds(640, 390, 150, 35);
        pilihGambar.setIcon(new ImageIcon("src/main/resources/images/Pilih Gambar.png"));
        pilihGambar.setBackground(Color.decode("#A9907E"));
        panelMain.add(pilihGambar);


        pilihGambar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Membuat JFileChooser
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

                // Menampilkan dialog untuk memilih file gambar
                int result = fileChooser.showOpenDialog(panelMain);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Mendapatkan file gambar yang dipilih
                    File selectedFile = fileChooser.getSelectedFile();

                    // Mendapatkan nama file gambar
                    String fileName = selectedFile.getName();

                    // Menyalin file gambar ke folder
                    try {
                        Path sourcePath = Paths.get(selectedFile.getAbsolutePath());
                        Path destinationPath = Paths.get("src/main/resources/images/" + fileName);
                        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    // Menambahkan label text dengan nama file gambar
                    JLabel fileNameLabel = new JLabel(fileName);
                    fileNameLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
//                    mengetur posisi
                    fileNameLabel.setBounds(900, 390, 300, 35);
                    fileNameLabel.setForeground(Color.decode("#FFFFFF"));
                    panelMain.remove(pilihGambarText);
                    panelMain.add(fileNameLabel);
                    panelMain.updateUI();
                }
            }
        });


        JButton deleteButton = new JButton();
        JLabel deleteText = new JLabel("Hapus");
        deleteText.setFont(MainGUI.poppinsSemiBold.deriveFont(25f));
        deleteText.setForeground(Color.decode("#FFFFFF"));
        deleteText.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteButton.add(deleteText);
        deleteButton.setBounds(400, 470, 167, 51);
        deleteButton.setIcon(new ImageIcon("src/main/resources/images/Delete.png"));
        deleteButton.setBackground(Color.decode("#A9907E"));
        panelMain.add(deleteButton);

//        jika menekan tombol deleteButton, maka akan menghapus data yang ada di database dan menampilkan pesan berhasil, lalu menghapus isi JTextField menjadi kosong
        deleteButton.addActionListener(e -> {
//            try {
//                String idBarang = id.getSelectedItem().toString();
//                String nama = namaBarang.getText();
//                String hargaJualBarang = hargaJual.getText();
//                String hargaBeliBarang = hargaBeli.getText();
//                String kategoriBarang = kategori.getText();
//                String stok = stokBarang.getText();
//                String pathGambar = path;
//                String query = "DELETE FROM barang WHERE id_barang = '" + idBarang + "'";
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pos", "root", "");
//                Statement stat = con.createStatement();
//                stat.executeUpdate(query);
                namaBarang.setText("");
                hargaJual.setText("");
                hargaBeli.setText("");
                kategori.setText("");
                stokBarang.setText("");


                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Data gagal dihapus");
//            }
        });

        JButton updateButton = new JButton();
        JLabel updateText = new JLabel("Update");
        updateText.setFont(MainGUI.poppinsSemiBold.deriveFont(25f));
        updateText.setForeground(Color.decode("#675D50"));
        updateText.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateButton.add(updateText);
        updateButton.setBounds(710, 470, 167, 51);
        updateButton.setIcon(new ImageIcon("src/main/resources/images/Update n Create.png"));
        updateButton.setBackground(Color.decode("#A9907E"));
        panelMain.add(updateButton);


//        jika menekan tombol updateButton, maka akan memperbarui data yang ada di database dan menampilkan pesan berhasil, lalu menghapus isi JTextField menjadi kosong
        updateButton.addActionListener(e -> {
//            try {
//                String idBarang = id.getSelectedItem().toString();
//                String nama = namaBarang.getText();
//                String hargaJualBarang = hargaJual.getText();
//                String hargaBeliBarang = hargaBeli.getText();
//                String kategoriBarang = kategori.getText();
//                String stok = stokBarang.getText();
//                String pathGambar = path;
//                String query = "UPDATE barang SET nama_barang = '" + nama + "', harga_jual = '" + hargaJualBarang + "', harga_beli = '" + hargaBeliBarang + "', kategori = '" + kategoriBarang + "', stok = '" + stok + "', gambar = '" + pathGambar + "' WHERE id_barang = '" + idBarang + "'";
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pos", "root", "");
//                Statement stat = con.createStatement();
//                stat.executeUpdate(query);
                namaBarang.setText("");
                hargaJual.setText("");
                hargaBeli.setText("");
                kategori.setText("");
                stokBarang.setText("");
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Data gagal diupdate");
//            }
        });


        Map<JLabel, String> panelLabel = new java.util.HashMap<>();
        panelLabel.put(panelMain, path);

        return panelLabel;
    }
}