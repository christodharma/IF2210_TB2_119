package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
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

        String[] idList = {"001", "002", "003", "004"};
        JComboBox id = new JComboBox(idList);
        id.setFont(MainGUI.poppinsSemiBold.deriveFont(35f));
        id.setBounds(617, 150-90, 487, 44);
        id.setForeground(Color.decode("#675D50"));
        panelMain.add(id);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(215, 239-90, 880, 357);
        scrollPane.setBackground(Color.decode("#D9D9D9"));
        scrollPane.setBorder(null);
        panelMain.add(scrollPane);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));

        String[][] historyList = {{"004","1","TanggalKe1","Totalke1"},{"004","2","TanggalKe2","Totalke2"},{"003","1","TanggalKe1","Totalke1"}};
        String[][] transactionList = {{"004","1","Donat","Makanan","1","5000"},{"004","1","Garpu","Alat Makan","1","8000"},{"004","2","Garpu","Alat Makan","1","8000"}};
        id.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelButtons.removeAll(); // clear existing buttons
                String selectedId = (String) id.getSelectedItem();
                System.out.println("Selected ID: " + selectedId);
                for (int i = 0; i < historyList.length; i++) {
                    System.out.println("Checking historyList[" + i + "][0]: " + historyList[i][0]);
                    ArrayList<String[]> selectedIdList = new ArrayList<String[]>();
                    if (historyList[i][0].equals(selectedId)) {
                        System.out.println("Adding button for historyList[" + i + "]");
                        JButton button = new JButton();
                        JLabel text = new JLabel("Button " + historyList[i][1] + "          " + historyList[i][2] + "          " + historyList[i][3]);
                        text.setFont(MainGUI.poppinsSemiBold.deriveFont(18f));
                        text.setForeground(Color.decode("#675D50"));
                        text.setAlignmentX(Component.CENTER_ALIGNMENT);
                        button.add(text);
                        button.setBackground(Color.decode("#ABC4AA"));
                        button.setBorder(null);
                        button.setMaximumSize(new Dimension(880, 50));

                        // Add ActionListener to button
                        int finalI = i;
                        button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                for (int j = 0; j < transactionList.length; j++) {
                                    if (transactionList[j][0].equals(selectedId) && transactionList[j][1].equals(historyList[finalI][1])) {
                                        selectedIdList.add(transactionList[j]);
                                        System.out.println("Adding transactionList[" + j + "] to selectedIdList");
                                    }
                                }
                                ShowTransaction showTransaction = new ShowTransaction();
                                try {
                                    Map<JLabel, String> panelTransaction = showTransaction.ShowTransaction(selectedIdList);
                                    MainGUI.tabbedPane.addTabs(panelTransaction);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }

                            }
                        });

                        panelButtons.add(button);
                    }
                }
                panelButtons.revalidate(); // refresh panel
                panelButtons.repaint();
            }
        });

        scrollPane.setViewportView(panelButtons);

        Map<JLabel, String> panelLabel = new java.util.HashMap<>();
        panelLabel.put(panelMain, path);

        return panelLabel;
    }
}
