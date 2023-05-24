package GUI;

import GUI.Call.DaftarMemberAction;
import Memberships.Member;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static App.Main.Members;

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

        ArrayList<Member> memberArrayList = Members.toArrayList();
        String[] idList = new String[memberArrayList.size()];
        for (int i = 0; i < idList.length; i++) {
            idList[i] = memberArrayList.get(i).getID();
        }
        String[][] data = new String[memberArrayList.size()][3];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = memberArrayList.get(i).getID();
            data[i][1] = memberArrayList.get(i).getName();
            data[i][2] = memberArrayList.get(i).getPhone();
        }
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
        AutoSuggest as = new AutoSuggest(idList,487,40);
        id.add(as);
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

        saveButton.addActionListener(new DaftarMemberAction(as.getReturnString(), name.getText(), phoneNumber.getText()));
        return panelLabel;
    }
}
