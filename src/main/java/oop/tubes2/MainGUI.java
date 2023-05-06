package oop.tubes2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainGUI {

    static Font poppinsBold;
    static Font poppinsSemiBold;
    public static TabbedPane tabbedPane = new TabbedPane(); // declare tabbedPane as a field
    private static Map<JLabel, String> panelLabel = new HashMap<>(); // declare panelLabel as a field
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();

        try {
            poppinsBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/font/Poppins-Bold.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppinsBold);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        try {
            poppinsSemiBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/font/Poppins-SemiBold.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppinsSemiBold);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        JPanel halamanUtama = new HalamanUtama();
        panelLabel.putAll(((HalamanUtama) halamanUtama).HalamanUtama());
        tabbedPane.addTabs(panelLabel);
        tabbedPane.setBackground(Color.decode("#F3DEBA"));

        JButton closeTab = new JButton();
        closeTab.setBounds(1170, 120, 62, 62);
        closeTab.setIcon(new ImageIcon("src/main/resources/images/Close Tab.png"));
        closeTab.setBackground(new Color(0xA9907E));
        frame.add(closeTab);

        JButton membershipButton = new JButton();
        JLabel membershipText = new JLabel("Membership");
        membershipText.setFont(poppinsSemiBold.deriveFont(18f));
        membershipText.setForeground(Color.decode("#FFFFFF"));
        membershipText.setAlignmentX(Component.CENTER_ALIGNMENT);
        membershipButton.add(membershipText);
        membershipButton.setBounds(129, 648, 185, 59);
        membershipButton.setIcon(new ImageIcon("src/main/resources/images/Label.png"));
        frame.add(membershipButton);
        membershipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPopupMenu popUp = new JPopupMenu();
                popUp.setPreferredSize(new Dimension(297, 194));
                popUp.setBackground(new Color(0xF3DEBA, true));

                JButton addMember = new JButton();
                addMember.setIcon(new ImageIcon("src/main/resources/images/Box Pop Up.png"));
                addMember.setBounds(0, 0, 286, 54);
                addMember.setBackground(new Color(0xF3DEBA));
                popUp.add(addMember);

                JLabel addMemText = new JLabel("Pendaftaran Member");
                addMemText.setFont(poppinsSemiBold.deriveFont(18f));
                addMemText.setForeground(Color.WHITE);
                addMemText.setHorizontalAlignment(JLabel.CENTER);
                addMemText.setVerticalAlignment(JLabel.CENTER);
                addMemText.setBounds(5, 5, 286, 54);

                addMember.setLayout(null);
                addMember.add(addMemText);
                addMember.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            JPanel pendaftaranHalaman = new PendaftaranMember();
                            tabbedPane.addTabs(((PendaftaranMember) pendaftaranHalaman).PendaftaranMember()); // add the new tab here
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                JButton updateMember = new JButton();
                updateMember.setIcon(new ImageIcon("src/main/resources/images/Box Pop Up.png"));                updateMember.setBackground(new Color(0xF3DEBA));
                popUp.add(updateMember);

                JLabel updateMemText = new JLabel("Update Member/VIP");
                updateMemText.setFont(poppinsSemiBold.deriveFont(18f));
                updateMemText.setForeground(Color.WHITE);
                updateMemText.setHorizontalAlignment(JLabel.CENTER);
                updateMemText.setVerticalAlignment(JLabel.CENTER);
                updateMemText.setBounds(5, 5, 286, 54);

                updateMember.setLayout(null);
                updateMember.add(updateMemText);

                updateMember.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            JPanel updateHalaman = new UpdateMember();
                            tabbedPane.addTabs(((UpdateMember) updateHalaman).UpdateMember()); // add the new tab here
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                JButton deactivateMember = new JButton();
                deactivateMember.setIcon(new ImageIcon("src/main/resources/images/Box Pop Up.png"));                updateMember.setBackground(new Color(0xF3DEBA));
                deactivateMember.setBackground(new Color(0xF3DEBA));
                popUp.add(deactivateMember);

                JLabel deactivateMemText = new JLabel("Deaktivasi Akun");
                deactivateMemText.setFont(poppinsSemiBold.deriveFont(18f));
                deactivateMemText.setForeground(Color.WHITE);
                deactivateMemText.setHorizontalAlignment(JLabel.CENTER);
                deactivateMemText.setVerticalAlignment(JLabel.CENTER);
                deactivateMemText.setBounds(5, 5, 286, 54);

                deactivateMember.setLayout(null);
                deactivateMember.add(deactivateMemText);

                deactivateMember.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            JPanel deactivateHalaman = new DeactivateMember();
                            tabbedPane.addTabs(((DeactivateMember) deactivateHalaman).DeactivateMember()); // add the new tab here
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                popUp.show(membershipButton, 0, -200);
            }
        });

        JButton historyButton = new JButton();
        JLabel historyText = new JLabel("History");
        historyText.setFont(poppinsSemiBold.deriveFont(18f));
        historyText.setForeground(Color.decode("#FFFFFF"));
        historyText.setAlignmentX(Component.CENTER_ALIGNMENT);
        historyButton.add(historyText);
        historyButton.setBounds(337, 648, 185, 59);
        historyButton.setIcon(new ImageIcon("src/main/resources/images/Label.png"));
        frame.add(historyButton);

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JPanel historyHalaman = new History();
                    tabbedPane.addTabs(((History) historyHalaman).History()); // add the new tab here
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton penjualanButton = new JButton();
        JLabel penjualanText = new JLabel("Penjualan");
        penjualanText.setFont(poppinsSemiBold.deriveFont(18f));
        penjualanText.setForeground(Color.decode("#FFFFFF"));
        penjualanText.setAlignmentX(Component.CENTER_ALIGNMENT);
        penjualanButton.add(penjualanText);
        penjualanButton.setBounds(546, 648, 185, 59);
        penjualanButton.setIcon(new ImageIcon("src/main/resources/images/Label.png"));
        frame.add(penjualanButton);

        penjualanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPopupMenu popUp = new JPopupMenu();
                popUp.setPreferredSize(new Dimension(297, 128));
                popUp.setBackground(new Color(0xF3DEBA, true));

                JButton manageBarang = new JButton();
                manageBarang.setIcon(new ImageIcon("src/main/resources/images/Box Pop Up.png"));
                manageBarang.setBounds(0, 0, 286, 54);
                manageBarang.setBackground(new Color(0xF3DEBA));
                popUp.add(manageBarang);

                JLabel manageBarangText = new JLabel("Manajemen Barang");
                manageBarangText.setFont(poppinsSemiBold.deriveFont(18f));
                manageBarangText.setForeground(Color.WHITE);
                manageBarangText.setHorizontalAlignment(JLabel.CENTER);
                manageBarangText.setVerticalAlignment(JLabel.CENTER);
                manageBarangText.setBounds(5, 5, 286, 54);

                manageBarang.setLayout(null);
                manageBarang.add(manageBarangText);
//                manageBarang.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        try {
//                            JPanel pendaftaranHalaman = new PendaftaranMember();
//                            tabbedPane.addTabs(((PendaftaranMember) pendaftaranHalaman).PendaftaranMember()); // add the new tab here
//                        } catch (IOException ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//                });

                JButton laporan = new JButton();
                laporan.setIcon(new ImageIcon("src/main/resources/images/Box Pop Up.png"));
                laporan.setBackground(new Color(0xF3DEBA));
                popUp.add(laporan);

                JLabel laporanText = new JLabel("Update Member/VIP");
                laporanText.setFont(poppinsSemiBold.deriveFont(18f));
                laporanText.setForeground(Color.WHITE);
                laporanText.setHorizontalAlignment(JLabel.CENTER);
                laporanText.setVerticalAlignment(JLabel.CENTER);
                laporanText.setBounds(5, 5, 286, 54);

                laporan.setLayout(null);
                laporan.add(laporanText);

//                laporan.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        try {
//                            JPanel updateHalaman = new UpdateMember();
//                            tabbedPane.addTabs(((UpdateMember) updateHalaman).UpdateMember()); // add the new tab here
//                        } catch (IOException ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//                });
                popUp.show(penjualanButton, 0, -133);
            }
        });

        JButton jualBarangButton = new JButton();
        JLabel jualBarangText = new JLabel("Jual Barang");
        jualBarangText.setFont(poppinsSemiBold.deriveFont(18f));
        jualBarangText.setForeground(Color.decode("#FFFFFF"));
        jualBarangText.setAlignmentX(Component.CENTER_ALIGNMENT);
        jualBarangButton.add(jualBarangText);
        jualBarangButton.setBounds(755, 648, 185, 59);
        jualBarangButton.setIcon(new ImageIcon("src/main/resources/images/Label.png"));
        frame.add(jualBarangButton);

        jualBarangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JPanel jualBarangHalaman = new JualBarang();
                    tabbedPane.addTabs(((JualBarang) jualBarangHalaman).JualBarang()); // add the new tab here
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton settingButton = new JButton();
        JLabel settingText = new JLabel("Setting");
        settingText.setFont(poppinsSemiBold.deriveFont(18f));
        settingText.setForeground(Color.decode("#FFFFFF"));
        settingText.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingButton.add(settingText);
        settingButton.setBounds(964, 648, 185, 59);
        settingButton.setIcon(new ImageIcon("src/main/resources/images/Label.png"));
        frame.add(settingButton);

        closeTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabbedPane.getSelectedIndex() == 0) {
                    return;
                }
                JLabel selectedLabel = (JLabel) tabbedPane.getTabComponentAt(tabbedPane.getSelectedIndex());
                tabbedPane.remove(tabbedPane.getSelectedIndex());
                panelLabel.remove(selectedLabel); // Remove the tab from the panelLabel map as well
            }
        });

        // Create the tabbed pane and add it to the panel
        UIManager.put("TabbedPane.selected", Color.decode("#675D50"));
        SwingUtilities.updateComponentTreeUI(tabbedPane);
        tabbedPane.setBounds(0, 0, 1280, 720);
        frame.add(tabbedPane);

        // Show the JFrame
        frame.setTitle("Tubes 2 OOP");
        frame.setSize(1280, 750);
        frame.getContentPane().setBackground(Color.decode("#F3DEBA"));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
