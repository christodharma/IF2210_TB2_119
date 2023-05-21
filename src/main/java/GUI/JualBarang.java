package GUI;

import App.Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class JualBarang extends JPanel {
    JLabel textLabel;
    private String path;
    private JLabel panelMain;
    public Map<JLabel, String> JualBarang() throws IOException {
        String path = "src/main/resources/images/Tab Jual Barang.png";
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        Map<JLabel, String> panelLabel = new java.util.HashMap<>();
        panelLabel.put(panelMain, path);

        JLabel gambarLabel = new JLabel("Gambar");
        gambarLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        gambarLabel.setForeground(Color.decode("#675D50"));
        gambarLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        gambarLabel.setVerticalTextPosition(JLabel.CENTER);
        gambarLabel.setHorizontalTextPosition(JLabel.CENTER);
        gambarLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gambarLabel.setBounds(20,25,133,43);
        panelMain.add(gambarLabel);

        JLabel namaBarangLabel = new JLabel("Nama Barang");
        namaBarangLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        namaBarangLabel.setForeground(Color.decode("#675D50"));
        namaBarangLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        namaBarangLabel.setVerticalTextPosition(JLabel.CENTER);
        namaBarangLabel.setHorizontalTextPosition(JLabel.CENTER);
        namaBarangLabel.setHorizontalAlignment(SwingConstants.CENTER);
        namaBarangLabel.setBounds(153,25,133,43);
        panelMain.add(namaBarangLabel);

        JLabel hargaLabel = new JLabel("Harga Barang");
        hargaLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        hargaLabel.setForeground(Color.decode("#675D50"));
        hargaLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        hargaLabel.setVerticalTextPosition(JLabel.CENTER);
        hargaLabel.setHorizontalTextPosition(JLabel.CENTER);
        hargaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        hargaLabel.setBounds(286,25,133,43);
        panelMain.add(hargaLabel);

        JLabel kategoriLabel = new JLabel("Kategori");
        kategoriLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        kategoriLabel.setForeground(Color.decode("#675D50"));
        kategoriLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        kategoriLabel.setVerticalTextPosition(JLabel.CENTER);
        kategoriLabel.setHorizontalTextPosition(JLabel.CENTER);
        kategoriLabel.setHorizontalAlignment(SwingConstants.CENTER);
        kategoriLabel.setBounds(419,25,133,43);
        panelMain.add(kategoriLabel);

        JLabel kuantitasLabel = new JLabel("Kuantitas");
        kuantitasLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        kuantitasLabel.setForeground(Color.decode("#675D50"));
        kuantitasLabel.setIcon(new ImageIcon("src/main/resources/images/Label Harga.png"));
        kuantitasLabel.setVerticalTextPosition(JLabel.CENTER);
        kuantitasLabel.setHorizontalTextPosition(JLabel.CENTER);
        kuantitasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        kuantitasLabel.setBounds(552,25,133,43);
        panelMain.add(kuantitasLabel);

        JLabel total = new JLabel("TOTAL : ");
        total.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        total.setForeground(Color.decode("#675D50"));
        total.setBounds(700, 439, 270, 40);
        panelMain.add(total);

        JLabel totalHarga = new JLabel("");
        totalHarga.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        totalHarga.setForeground(Color.decode("#675D50"));
        totalHarga.setHorizontalAlignment(SwingConstants.RIGHT);
        totalHarga.setBounds(970, 439, 262, 40);
        panelMain.add(totalHarga);

        String[][] data = new String[Main.Products.getProducts().size()][5];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = Main.Products.getProducts().get(i).getName();
            data[i][1] = Main.Products.getProducts().get(i).getCategory();
            data[i][2] = String.valueOf(Main.Products.getProducts().get(i).getPrice());
            data[i][3] = String.valueOf(Main.Products.getProducts().get(i).getBuyPrice());
            data[i][4] = String.valueOf(Main.Products.getProducts().get(i).getQuantity());
        }

        String[] namaBarang = new String[data.length];
        for (int k = 0; k < data.length; k++) {
            namaBarang[k] = data[k][0];
        }

        JPanel panelBill = new JPanel();
        panelBill.setLayout(new BoxLayout(panelBill, BoxLayout.Y_AXIS));
        panelBill.setBackground(Color.decode("#D9D9D9"));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.decode("#D9D9D9"));

        String[] idList = {"001","002"};
        String[][] saveBill = {{"002","1","Nasi Gila","1","13000"}, {"002","2","Risoles","5","15000"}};
        JPanel id = new JPanel();
        id.setBounds(970, 75, 262, 40);
        id.setLayout(new FlowLayout());
        id.setOpaque(false);
        id.add(new AutoSuggest(idList,262,40, saveBill, panelBill, totalHarga));
        panelMain.add(id);


        JPanel search = new JPanel();
        search.setBounds(20, 479, 665, 40);
        search.setLayout(new FlowLayout());
        search.setOpaque(false);
        search.add(new AutoSuggest(namaBarang,665,40, data, panel, panelBill, totalHarga));
        panelMain.add(search);

        for (int i = 0; i < data.length; i++) {
            setPanel(data, i, panel, panelBill, totalHarga);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(20, 182-90, 665, 367);
        scrollPane.setBackground(Color.decode("#D9D9D9"));
        scrollPane.setBorder(null);
        panelMain.add(scrollPane);

        JLabel labelBill = new JLabel("BILL");
        labelBill.setFont(MainGUI.poppinsSemiBold.deriveFont(30f));
        labelBill.setForeground(Color.decode("#675D50"));
        labelBill.setHorizontalAlignment(SwingConstants.CENTER);
        labelBill.setBounds(700, 25, 532, 50);
        panelMain.add(labelBill);

        JLabel labelAddCustomer = new JLabel("Add Customer : ");
        labelAddCustomer.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        labelAddCustomer.setForeground(Color.decode("#675D50"));
        labelAddCustomer.setBounds(700, 75, 270, 40);
        panelMain.add(labelAddCustomer);


        JPanel panelXBill = new JPanel();
        panelXBill.setLayout(new BoxLayout(panelXBill, BoxLayout.X_AXIS));
        panelXBill.setBounds(700, 125, 532, 50);
        panelMain.add(panelXBill);

        JLabel noBill = new JLabel("No");
        noBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        noBill.setForeground(Color.decode("#675D50"));
        noBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
        noBill.setVerticalTextPosition(JLabel.CENTER);
        noBill.setHorizontalTextPosition(JLabel.CENTER);
        noBill.setHorizontalAlignment(SwingConstants.CENTER);
        noBill.setPreferredSize(new Dimension(133,75));
        panelXBill.add(noBill);

        JLabel namaBill = new JLabel("Nama Barang");
        namaBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        namaBill.setForeground(Color.decode("#675D50"));
        namaBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
        namaBill.setVerticalTextPosition(JLabel.CENTER);
        namaBill.setHorizontalTextPosition(JLabel.CENTER);
        namaBill.setHorizontalAlignment(SwingConstants.CENTER);
        namaBill.setPreferredSize(new Dimension(133,75));
        panelXBill.add(namaBill);

        JLabel kuantitasBill = new JLabel("Kuantitas");
        kuantitasBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        kuantitasBill.setForeground(Color.decode("#675D50"));
        kuantitasBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
        kuantitasBill.setVerticalTextPosition(JLabel.CENTER);
        kuantitasBill.setHorizontalTextPosition(JLabel.CENTER);
        kuantitasBill.setHorizontalAlignment(SwingConstants.CENTER);
        kuantitasBill.setPreferredSize(new Dimension(133,75));
        panelXBill.add(kuantitasBill);

        JLabel hargaBill = new JLabel("Harga");
        hargaBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        hargaBill.setForeground(Color.decode("#675D50"));
        hargaBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
        hargaBill.setVerticalTextPosition(JLabel.CENTER);
        hargaBill.setHorizontalTextPosition(JLabel.CENTER);
        hargaBill.setHorizontalAlignment(SwingConstants.CENTER);
        hargaBill.setPreferredSize(new Dimension(133,75));
        panelXBill.add(hargaBill);

        panelXBill.setAlignmentX(Component.CENTER_ALIGNMENT);

        JScrollPane scrollPaneBill = new JScrollPane(panelBill);
        scrollPaneBill.setBounds(700, 165, 532, 274);
        scrollPaneBill.setBackground(Color.decode("#ABC4AA"));
        scrollPaneBill.setBorder(null);
        panelMain.add(scrollPaneBill);

        JButton chargeButton = new JButton();
        JLabel chargeText = new JLabel(" Charge");
        chargeText.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        chargeText.setForeground(Color.decode("#675D50"));
        chargeText.setAlignmentX(Component.CENTER_ALIGNMENT);
        chargeButton.add(chargeText);
        chargeButton.setBounds(700, 479, 266, 40);
        chargeButton.setIcon(new ImageIcon("src/main/resources/images/Charge.png"));
        panelMain.add(chargeButton);

        JButton saveBillButton = new JButton();
        JLabel saveBillText = new JLabel(" Save Bill");
        saveBillText.setFont(MainGUI.poppinsSemiBold.deriveFont(20f));
        saveBillText.setForeground(Color.decode("#FFFFFF"));
        saveBillText.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveBillButton.add(saveBillText);
        saveBillButton.setBounds(966, 479, 266, 40);
        saveBillButton.setIcon(new ImageIcon("src/main/resources/images/Save Bill.png"));
        panelMain.add(saveBillButton);

        return panelLabel;
    }

    public static void setPanel(String[][] data, int i, JPanel panel, JPanel panelBill, JLabel totalHarga) {
        JPanel panelX = new JPanel();
        panelX.setLayout(new BoxLayout(panelX, BoxLayout.X_AXIS));
        panelX.setBackground(Color.decode("#D9D9D9"));

        JLabel gambar = new JLabel("");
        gambar.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        gambar.setForeground(Color.decode("#675D50"));
        gambar.setIcon(new ImageIcon("src/main/resources/images/"+data[i][0]+".png"));
        gambar.setVerticalTextPosition(JLabel.CENTER);
        gambar.setHorizontalTextPosition(JLabel.CENTER);
        gambar.setHorizontalAlignment(SwingConstants.CENTER);
        panelX.add(gambar);

        JLabel nama = new JLabel(data[i][0]);
        nama.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        nama.setForeground(Color.decode("#675D50"));
        nama.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
        nama.setVerticalTextPosition(JLabel.CENTER);
        nama.setHorizontalTextPosition(JLabel.CENTER);
        nama.setHorizontalAlignment(SwingConstants.CENTER);
        nama.setPreferredSize(new Dimension(133,75));
        panelX.add(nama);

        JLabel harga = new JLabel(data[i][3]);
        harga.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        harga.setForeground(Color.decode("#675D50"));
        harga.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
        harga.setVerticalTextPosition(JLabel.CENTER);
        harga.setHorizontalTextPosition(JLabel.CENTER);
        harga.setHorizontalAlignment(SwingConstants.CENTER);
        harga.setPreferredSize(new Dimension(133,75));
        panelX.add(harga);

        JLabel kategori = new JLabel(data[i][1]);
        kategori.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        kategori.setForeground(Color.decode("#675D50"));
        kategori.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
        kategori.setVerticalTextPosition(JLabel.CENTER);
        kategori.setHorizontalTextPosition(JLabel.CENTER);
        kategori.setHorizontalAlignment(SwingConstants.CENTER);
        kategori.setPreferredSize(new Dimension(133,75));
        panelX.add(kategori);

        int max = Integer.parseInt(data[i][4]);
        SpinnerModel value = new SpinnerNumberModel(0, 0, max, 1);
        JSpinner kuantitasSpinner = new JSpinner(value);
        JFormattedTextField txt = ((JSpinner.NumberEditor)kuantitasSpinner.getEditor()).getTextField();
        ((NumberFormatter)txt.getFormatter()).setAllowsInvalid(false);
        txt.setColumns(5);
        kuantitasSpinner.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
        kuantitasSpinner.setForeground(Color.decode("#675D50"));
        kuantitasSpinner.setMaximumSize(new Dimension(133, 75));
        kuantitasSpinner.setMinimumSize(new Dimension(133, 75));
        kuantitasSpinner.setPreferredSize(new Dimension(133, 75));
        panelX.add(kuantitasSpinner);

        int finalI = i;
        kuantitasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = (int) kuantitasSpinner.getValue();
                int harga = Integer.parseInt(data[finalI][3])*value;
                JPanel panelXBill = new JPanel();
                panelXBill.setLayout(new BoxLayout(panelXBill, BoxLayout.X_AXIS));

                JLabel noBill = new JLabel(String.valueOf(panelBill.getComponentCount()+1));
                noBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
                noBill.setForeground(Color.decode("#675D50"));
                noBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
                noBill.setVerticalTextPosition(JLabel.CENTER);
                noBill.setHorizontalTextPosition(JLabel.CENTER);
                noBill.setHorizontalAlignment(SwingConstants.CENTER);
                noBill.setPreferredSize(new Dimension(133,75));
                panelXBill.add(noBill);

                JLabel namaBill = new JLabel(data[finalI][0]);
                namaBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
                namaBill.setForeground(Color.decode("#675D50"));
                namaBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
                namaBill.setVerticalTextPosition(JLabel.CENTER);
                namaBill.setHorizontalTextPosition(JLabel.CENTER);
                namaBill.setHorizontalAlignment(SwingConstants.CENTER);
                namaBill.setPreferredSize(new Dimension(133,75));
                panelXBill.add(namaBill);

                JLabel kuantitasBill = new JLabel(String.valueOf(value));
                kuantitasBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
                kuantitasBill.setForeground(Color.decode("#675D50"));
                kuantitasBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
                kuantitasBill.setVerticalTextPosition(JLabel.CENTER);
                kuantitasBill.setHorizontalTextPosition(JLabel.CENTER);
                kuantitasBill.setHorizontalAlignment(SwingConstants.CENTER);
                kuantitasBill.setPreferredSize(new Dimension(133,75));
                panelXBill.add(kuantitasBill);

                JLabel hargaBill = new JLabel(String.valueOf(harga));
                hargaBill.setFont(MainGUI.poppinsSemiBold.deriveFont(15f));
                hargaBill.setForeground(Color.decode("#675D50"));
                hargaBill.setIcon(new ImageIcon("src/main/resources/images/Label Jual Barang.png"));
                hargaBill.setVerticalTextPosition(JLabel.CENTER);
                hargaBill.setHorizontalTextPosition(JLabel.CENTER);
                hargaBill.setHorizontalAlignment(SwingConstants.CENTER);
                hargaBill.setPreferredSize(new Dimension(133,75));
                panelXBill.add(hargaBill);

                // Check if item already exists in panelBill
                boolean itemFound = false;
                for (Component component : panelBill.getComponents()) {
                    if (component instanceof JPanel) {
                        JPanel panelXBillExisting = (JPanel) component;
                        JLabel namaBillExisting = (JLabel) panelXBillExisting.getComponent(1);
                        JLabel kuantitasBillExisting = (JLabel) panelXBillExisting.getComponent(2);
                        JLabel hargaBillExisting = (JLabel) panelXBillExisting.getComponent(3);
                        if (namaBillExisting.getText().equals(namaBill.getText())) {
                            kuantitasBillExisting.setText(String.valueOf(value));
                            hargaBillExisting.setText(String.valueOf(harga));
                            itemFound = true;
                        }
                        if (kuantitasBillExisting.getText().equals("0")) {
                            System.out.println("Item removed");
                            panelBill.remove(panelXBillExisting);
//                                update noBill
                            for (int i = 0; i < panelBill.getComponentCount(); i++) {
                                panelXBill = (JPanel) panelBill.getComponent(i);
                                noBill = (JLabel) panelXBill.getComponent(0);
                                noBill.setText(String.valueOf(i + 1));
                            }
                        }
                    }
                }

                if (!itemFound && value > 0) {
                    System.out.println("Item not found");
                    // Item does not exist, add new item panel
                    panelBill.add(panelXBill);
                }

                int totalHargaInt = 0;
                for (int i = 0; i < panelBill.getComponentCount(); i++) {
                    panelXBill = (JPanel) panelBill.getComponent(i);
                    hargaBill = (JLabel) panelXBill.getComponent(3);
                    totalHargaInt += Integer.parseInt(hargaBill.getText());
                }
                totalHarga.setText(String.valueOf(totalHargaInt));

                panelBill.revalidate();
                panelBill.repaint();
            }
        });
        panel.add(panelX);
    }
}
