package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class AutoSuggest extends JPanel{
    private final JTextField tf;
    private final JComboBox combo = new JComboBox();
    private final Vector<String> v = new Vector<String>();
    public AutoSuggest(String[] countries, int x, int y) {
        super(new BorderLayout());
        combo.setEditable(true);
        tf = (JTextField) combo.getEditor().getEditorComponent();
        tf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        String text = tf.getText();
                        if(text.length()==0) {
                            combo.hidePopup();
                            setModel(new DefaultComboBoxModel(v), "");
                        }else{
                            DefaultComboBoxModel m = getSuggestedModel(v, text);
                            if(m.getSize()==0 || hide_flag) {
                                combo.hidePopup();
                                hide_flag = false;
                            }else{
                                setModel(m, text);
                                combo.showPopup();
                            }
                        }
                    }
                });
            }
            public void keyPressed(KeyEvent e) {
                String text = tf.getText();
                int code = e.getKeyCode();
                if(code==KeyEvent.VK_ENTER) {
                    if(!v.contains(text)) {
                        v.addElement(text);
                        Collections.sort(v);
                        setModel(getSuggestedModel(v, text), text);
                    }
                    hide_flag = true;
                }else if(code==KeyEvent.VK_ESCAPE) {
                    hide_flag = true;
                }else if(code==KeyEvent.VK_RIGHT) {
                    for(int i=0;i<v.size();i++) {
                        String str = v.elementAt(i);
                        if(str.startsWith(text)) {
                            combo.setSelectedIndex(-1);
                            tf.setText(str);
                            return;
                        }
                    }
                }
            }
        });
        for(int i=0;i<countries.length;i++){
            v.addElement(countries[i]);
        }
        setModel(new DefaultComboBoxModel(v), "");
        JPanel p = new JPanel(new BorderLayout());
        p.add(combo, BorderLayout.NORTH);
        add(p);
        setPreferredSize(new Dimension(x, y));
        combo.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        combo.setForeground(Color.decode("#675D50"));
    }
    public AutoSuggest(String[] countries, int x, int y, JPanel panelButtons, String[][] historyList, String[][] transactionList) {
//        call auto suggest
        this(countries, x, y);
        this.actionHistoryCombo(combo, panelButtons, historyList, transactionList);
    }
    public AutoSuggest(String[] countries, int x, int y, JTextField name, JTextField phoneNumber, String[][] data) {
//        call auto suggest
        this(countries, x, y);
        this.actionMemberCombo(combo, name, phoneNumber, data);
    }
    public AutoSuggest(String[] countries, int x, int y, String[][] saveBill, JPanel panelBill, JLabel totalHarga) {
//        call auto suggest
        this(countries, x, y);
        this.actionJualBeliCombo(combo, saveBill, panelBill, totalHarga);
    }

    public AutoSuggest(String[] countries, int x, int y, JTextField namaBarang, JTextField hargaJual, JTextField hargaBeli, JTextField kategori, JTextField stokBarang, String[][] data) {
//        call auto suggest
        this(countries, x, y);
        this.actionPerbaruiCombo(combo, namaBarang, hargaJual, hargaBeli, kategori, stokBarang, data);
    }

    public AutoSuggest(String[] countries, int x, int y, String[][] data, JPanel panel, JPanel panelBill, JLabel totalHarga) {
        this(countries, x, y);
        this.actionShowInventory(combo, data, panel, panelBill, totalHarga);
    }

    private boolean hide_flag = false;
    private void setModel(DefaultComboBoxModel mdl, String str) {
        combo.setModel(mdl);
        combo.setSelectedIndex(-1);
        tf.setText(str);
    }
    private static DefaultComboBoxModel getSuggestedModel(java.util.List<String> list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for(String s: list) {
            if(s.startsWith(text)) m.addElement(s);
        }
        return m;
    }

    public void actionHistoryCombo(JComboBox id, JPanel panelButtons, String[][] historyList, String[][] transactionList) {
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
    }

    public void actionMemberCombo(JComboBox id, JTextField name, JTextField phoneNumber, String[][] data) {
        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedId = (String) id.getSelectedItem();
                for (int i = 0; i < data.length; i++) {
                    if (data[i][0].equals(selectedId)) {
                        name.setText(data[i][1]);
                        phoneNumber.setText(data[i][2]);
                    }
                }
            }
        });
    }

    public void actionPerbaruiCombo (JComboBox id, JTextField namaBarang, JTextField hargaJual, JTextField hargaBeli, JTextField kategori, JTextField stokBarang, String[][] data) {
        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedId = (String) id.getSelectedItem();
                for (int i = 0; i < data.length; i++) {
                    if (data[i][0].equals(selectedId)) {
                        namaBarang.setText(data[i][1]);
                        hargaJual.setText(data[i][2]);
                        hargaBeli.setText(data[i][3]);
                        kategori.setText(data[i][4]);
                        stokBarang.setText(data[i][5]);
                    }
                }
            }
        });
    }

    public void actionShowInventory(JComboBox search, String[][] data, JPanel panel, JPanel panelBill, JLabel totalHarga) {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                panel.removeAll();
                String searchNama = (String) search.getSelectedItem();
                for (int i = 0; i < data.length; i++) {
                    if (data[i][0].equals(searchNama)) {
                        JualBarang.setPanel(data, i, panel, panelBill, totalHarga);
                        found = true;
                    }
                }
                if (!found) {
                    for (int i = 0; i < data.length; i++) {
                        JualBarang.setPanel(data, i, panel, panelBill, totalHarga);
                    }
                }
            }
        });
    }

    public void actionJualBeliCombo (JComboBox id, String[][] saveBill, JPanel panelBill, JLabel totalHarga) {
        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedId = (String) id.getSelectedItem();
                panelBill.removeAll();
                for (int i = 0; i < saveBill.length; i++) {
                    if (saveBill[i][0].equals(selectedId)) {
                        JPanel panelXBill = new JPanel();
                        panelXBill.setLayout(new BoxLayout(panelXBill, BoxLayout.X_AXIS));

                        JLabel noBill = new JLabel(saveBill[i][1]);
                        noBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
                        noBill.setForeground(Color.decode("#675D50"));
                        noBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
                        noBill.setVerticalTextPosition(JLabel.CENTER);
                        noBill.setHorizontalTextPosition(JLabel.CENTER);
                        noBill.setHorizontalAlignment(SwingConstants.CENTER);
                        noBill.setPreferredSize(new Dimension(133,75));
                        panelXBill.add(noBill);

                        JLabel namaBill = new JLabel(saveBill[i][2]);
                        namaBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
                        namaBill.setForeground(Color.decode("#675D50"));
                        namaBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
                        namaBill.setVerticalTextPosition(JLabel.CENTER);
                        namaBill.setHorizontalTextPosition(JLabel.CENTER);
                        namaBill.setHorizontalAlignment(SwingConstants.CENTER);
                        namaBill.setPreferredSize(new Dimension(133,75));
                        panelXBill.add(namaBill);

                        JLabel kuantitasBill = new JLabel(saveBill[i][3]);
                        kuantitasBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
                        kuantitasBill.setForeground(Color.decode("#675D50"));
                        kuantitasBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
                        kuantitasBill.setVerticalTextPosition(JLabel.CENTER);
                        kuantitasBill.setHorizontalTextPosition(JLabel.CENTER);
                        kuantitasBill.setHorizontalAlignment(SwingConstants.CENTER);
                        kuantitasBill.setPreferredSize(new Dimension(133,75));
                        panelXBill.add(kuantitasBill);

                        JLabel hargaBill = new JLabel(saveBill[i][4]);
                        hargaBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
                        hargaBill.setForeground(Color.decode("#675D50"));
                        hargaBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
                        hargaBill.setVerticalTextPosition(JLabel.CENTER);
                        hargaBill.setHorizontalTextPosition(JLabel.CENTER);
                        hargaBill.setHorizontalAlignment(SwingConstants.CENTER);
                        hargaBill.setPreferredSize(new Dimension(133,75));
                        panelXBill.add(hargaBill);

                        boolean itemFound = false;
                        for (Component component : panelBill.getComponents()) {
                            if (component instanceof JPanel) {
                                JPanel panelXBillExisting = (JPanel) component;
                                JLabel namaBillExisting = (JLabel) panelXBillExisting.getComponent(1);
                                if (namaBillExisting.getText().equals(namaBill.getText())) {
                                    itemFound = true;
                                }
                            }
                        }

                        if (!itemFound) {
                            System.out.println("Item not found");
                            // Item does not exist, add new item panel
                            panelBill.add(panelXBill);
                        }
                        int totalHargaInt = 0;
                        for (int j = 0; j < panelBill.getComponentCount(); j++) {
                            panelXBill = (JPanel) panelBill.getComponent(j);
                            hargaBill = (JLabel) panelXBill.getComponent(3);
                            totalHargaInt += Integer.parseInt(hargaBill.getText());
                        }
                        totalHarga.setText(String.valueOf(totalHargaInt));
                    }
                }
                panelBill.validate();
                panelBill.repaint();
            }
        });
    }
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        String[] idList = {"001", "002", "003", "004"};
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout());
//        panel.add(new AutoSuggest(idList));
//        frame.add(panel);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);

//
//        JPanel id = new AutoSuggest(idList);
//        id.setBounds(617, 155, 487, 40);
//        id.setLayout(null);
//        id.setBackground(Color.decode("#F5F5F5"));
//        frame.add(id);
//    }
}