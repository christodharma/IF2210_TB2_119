package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class History extends JPanel {
    JLabel textLabel;
    private String path;
    private JLabel panelMain;
    public Map<JLabel, String> History() throws IOException {
        String path = "src/main/resources/images/Tab History.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        textLabel = new JLabel("<html><div style='line-height: 5em;'>ID Customer</html>");
        textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        textLabel.setBounds(205, 149-90, 315, 45);
        textLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(textLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(215, 239-90, 880, 357);
        scrollPane.setBackground(Color.decode("#D9D9D9"));
        scrollPane.setBorder(null);
        panelMain.add(scrollPane);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));

        String[] idList = {"001", "002", "003", "004"};
        String[][] historyList = {{"004","1","TanggalKe1","Totalke1"},{"004","2","TanggalKe2","Totalke2"},{"003","1","TanggalKe1","Totalke1"}};
        String[][] transactionList = {{"004","1","Donat","Makanan","1","5000"},{"004","1","Garpu","Alat Makan","1","8000"},{"004","2","Garpu","Alat Makan","1","8000"}};
        JPanel id = new JPanel();
        id.setBounds(617, 150-90, 487, 44);
        id.setLayout(new FlowLayout());
        id.setOpaque(false);
        id.add(new AutoSuggest(idList,487,44, panelButtons, historyList, transactionList));
        panelMain.add(id);

        scrollPane.setViewportView(panelButtons);

        Map<JLabel, String> panelLabel = new java.util.HashMap<>();
        panelLabel.put(panelMain, path);

        return panelLabel;
    }
}
