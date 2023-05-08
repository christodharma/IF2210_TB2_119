package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;
public class Laporan extends JPanel{
    JLabel textLabel;
    public Map<JLabel, String> Laporan() throws IOException {
        String path = "src/main/resources/images/Tab Laporan.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        JButton downloadLaporan = new JButton();
        JLabel downloadLaporanText = new JLabel("Download Laporan");
        downloadLaporanText.setFont(MainGUI.poppinsSemiBold.deriveFont(30f));
        downloadLaporanText.setForeground(Color.decode("#675D50"));
        downloadLaporanText.setAlignmentX(Component.CENTER_ALIGNMENT);
        downloadLaporan.add(downloadLaporanText);
        downloadLaporan.setBounds(430, 160, 420, 63);
        downloadLaporan.setIcon(new ImageIcon("src/main/resources/images/Laporan dan Bill.png"));
        downloadLaporan.setBackground(Color.decode("#A9907E"));
        panelMain.add(downloadLaporan);

        JButton downloadFixedBill = new JButton();
        JLabel downloadFixedBillText = new JLabel("Download Fixed Bill");
        downloadFixedBillText.setFont(MainGUI.poppinsSemiBold.deriveFont(30f));
        downloadFixedBillText.setForeground(Color.decode("#675D50"));
        downloadFixedBillText.setAlignmentX(Component.CENTER_ALIGNMENT);
        downloadFixedBill.add(downloadFixedBillText);
        downloadFixedBill.setBounds(430, 340, 420, 63);
        downloadFixedBill.setIcon(new ImageIcon("src/main/resources/images/Laporan dan Bill.png"));
        downloadFixedBill.setBackground(Color.decode("#A9907E"));
        panelMain.add(downloadFixedBill);

        Map<JLabel, String> panelLabel = new java.util.HashMap<>();
        panelLabel.put(panelMain, path);

        return panelLabel;

    }
}
