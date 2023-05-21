package GUI;

import Customers.Customer;
import GUI.Call.DaftarMemberAction;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class PendaftaranMember extends JPanel {
    private static final String COMMIT_ACTION = "commit";
    JLabel textLabel;
    public Map<JLabel, String> PendaftaranMember() throws IOException {
        String path = "src/main/resources/images/Tab Pendaftaran Member.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        textLabel = new JLabel("<html><div style='line-height: 5em;'>ID Customer<br>Name<br>Phone Number</html>");
        textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        textLabel.setBounds(200, 147, 315, 155);
        textLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(textLabel);

//        ArrayList<String> idList = new ArrayList<String>();
//        idList.add("001");
//        idList.add("002");
//        idList.add("003");
//        idList.add("004");
        String[] idList = {"001", "002", "003", "004","005"};
        String[][] data = {{"001","Rifa","000"}, {"002","Joja","111"}, {"003","Toto","222"}, {"004","Agsha","333"},{"005","Malik","444"}};

        JTextField name = new JTextField();
        name.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        name.setBounds(617, 205, 487, 40);
        name.setForeground(Color.decode("#675D50"));
        name.setBorder(null);
        panelMain.add(name);

        JTextField phoneNumber = new JTextField();
        phoneNumber.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        phoneNumber.setBounds(617, 255, 487, 41);
        phoneNumber.setForeground(Color.decode("#675D50"));
        phoneNumber.setBorder(null);
        panelMain.add(phoneNumber);

        JPanel id = new JPanel();
        id.setBounds(617, 155, 487, 40);
        id.setLayout(new FlowLayout());
        id.setOpaque(false);
        id.add(new AutoSuggest(idList,487,40));
        panelMain.add(id);

        JButton saveButton = new JButton();
        JLabel saveText = new JLabel("Save");
        saveText.setFont(MainGUI.poppinsSemiBold.deriveFont(25f));
        saveText.setForeground(Color.decode("#675D50"));
        saveText.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveButton.add(saveText);
        saveButton.setBounds(551, 377, 186, 54);
        saveButton.setIcon(new ImageIcon("src/main/resources/images/Save.png"));
        saveButton.setBackground(Color.decode("#A9907E"));
        panelMain.add(saveButton);

        Map<JLabel, String> panelLabel = new java.util.HashMap<>();
        panelLabel.put(panelMain, path);

        saveButton.addActionListener(new DaftarMemberAction(new Customer(), name.getText(), phoneNumber.getText()));
        return panelLabel;
    }
}
