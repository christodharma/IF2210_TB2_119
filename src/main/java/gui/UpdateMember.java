package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class UpdateMember extends JPanel {
    JLabel textLabel;
    public Map<JLabel, String> UpdateMember() throws IOException {
        String path = "src/main/resources/images/Tab Update Member.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        textLabel = new JLabel("<html><div style='line-height: 5em;'>ID Customer<br>Name<br>Phone Number<br>Status</html>");
        textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        textLabel.setBounds(200, 140, 315, 195);
        textLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(textLabel);

        String[] idList = {"001", "002", "003", "004"};
        JPanel id = new JPanel();
        id.setBounds(617, 142, 487, 40);
        id.setLayout(new FlowLayout());
        id.setOpaque(false);
        id.add(new AutoSuggest(idList,487,40));
        panelMain.add(id);

        JTextField name = new JTextField();
        name.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        name.setBounds(617, 192, 487, 40);
        name.setForeground(Color.decode("#675D50"));
        name.setBorder(null);
        panelMain.add(name);

        JTextField phoneNumber = new JTextField();
        phoneNumber.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        phoneNumber.setBounds(617, 242, 487, 41);
        phoneNumber.setForeground(Color.decode("#675D50"));
        phoneNumber.setBorder(null);
        panelMain.add(phoneNumber);

        String statusList[] = {"Member", "VIP"};
        JComboBox status = new JComboBox(statusList);
        status.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        status.setBounds(617, 292, 487, 41);
        status.setForeground(Color.decode("#675D50"));
        panelMain.add(status);

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

        return panelLabel;
    }
}
