package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

public class Settings extends JPanel {

    JLabel textLabel;
    public Map<JLabel, String> Settings() throws IOException {
        String path = "src/main/resources/images/Tab Pengaturan.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        textLabel = new JLabel("<html><div style='line-width: 5em;'>Tipe Data Penyimpanan</html>");
        textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(30f));
        textLabel.setBounds(215, 101, 372, 45);
        textLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(textLabel);

        textLabel = new JLabel("<html><div style='line-width: 5em;'>Plugin</html>");
        textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(30f));
        textLabel.setBounds(820, 101, 372, 45);
        textLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(textLabel);

        String[] dataPenyimpanan = {"xml", "json"};
//        String[] listPlugin = {"Plugin 1", "Plugin 2"};

        JComboBox penyimpanan = new JComboBox(dataPenyimpanan);
        penyimpanan.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        penyimpanan.setBounds(260, 197, 290, 36);
        penyimpanan.setForeground(Color.decode("#675D50"));
        panelMain.add(penyimpanan);

//        JComboBox plugin = new JComboBox(listPlugin);
//        plugin.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
//        plugin.setBounds(730, 197, 290, 36);
//        plugin.setForeground(Color.decode("#675D50"));
//        panelMain.add(plugin);


        JButton hapus = new JButton();
        JLabel hapusText = new JLabel("Hapus");
        hapusText.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        hapusText.setForeground(Color.decode("#FFFFFF"));
        hapusText.setAlignmentX(Component.CENTER_ALIGNMENT);
        hapus.add(hapusText);
        hapus.setBounds(785, 285, 167, 51);
        hapus.setIcon(new ImageIcon("src/main/resources/images/Hapus.png"));
        hapus.setBackground(Color.decode("#A9907E"));
        panelMain.add(hapus);


        JButton simpan = new JButton();
        JLabel simpanText = new JLabel("Simpan");
        simpanText.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        simpanText.setForeground(Color.decode("#675D50"));
        simpanText.setAlignmentX(Component.CENTER_ALIGNMENT);
        simpan.add(simpanText);
        simpan.setBounds(320, 285, 167, 51);
        simpan.setIcon(new ImageIcon("src/main/resources/images/Simpan.png"));
        simpan.setBackground(Color.decode("#A9907E"));
        panelMain.add(simpan);

        JButton uploadPlugin = new JButton();
        JLabel uploadPluginText = new JLabel("Upload Plugin");
        uploadPluginText.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        uploadPluginText.setForeground(Color.decode("#675D50"));
        uploadPluginText.setAlignmentX(Component.CENTER_ALIGNMENT);
        uploadPlugin.add(uploadPluginText);
        uploadPlugin.setBounds(480, 400, 285, 63);
        uploadPlugin.setIcon(new ImageIcon("src/main/resources/images/Upload Plugin.png"));
        uploadPlugin.setBackground(Color.decode("#A9907E"));
        panelMain.add(uploadPlugin);


        Map < JLabel, String > panelLabel = new java.util.HashMap<>();
        panelLabel.put(panelMain, path);

        return panelLabel;
    }
}