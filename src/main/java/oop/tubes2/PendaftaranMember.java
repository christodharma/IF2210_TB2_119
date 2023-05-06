package oop.tubes2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class PendaftaranMember extends JPanel {

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

        String[] idList = {"001", "002", "003", "004"};
//        AutoCompleteDecorator.decorate(textField,
//                new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, idList));
//        JTextField textField = new JTextField();
//        textField.setFont(new Font("Arial", Font.PLAIN, 33));
//        textField.setBackground(new Color(177, 197, 221));
//        textField.setForeground(Color.WHITE);
        JComboBox id = new JComboBox(idList);
        id.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        id.setBounds(617, 155, 487, 40);
        id.setForeground(Color.decode("#675D50"));
        panelMain.add(id);

        JTextField name = new JTextField();
        name.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        name.setBounds(617, 205, 487, 40);
        name.setForeground(Color.decode("#675D50"));
        name.setBorder(null);
        panelMain.add(name);

        JTextField phoneNumber = new JTextField();
        phoneNumber.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        phoneNumber.setBounds(617, 255, 487, 41);
        phoneNumber.setForeground(Color.decode("#675D50"));
        phoneNumber.setBorder(null);
        panelMain.add(phoneNumber);

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
