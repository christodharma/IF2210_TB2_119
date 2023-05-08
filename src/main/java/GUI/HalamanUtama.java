package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HalamanUtama extends JPanel {
    private Clock clock;
    private JLabel textLabel;
    private JLabel NIMLabel;

    public Map<JLabel, String> HalamanUtama() throws IOException {
        JLabel panelMain = new JLabel();
        ImageIcon bg = new ImageIcon("src/main/resources/images/Background.png");
        panelMain.setBounds(0, 90, 1280, 630);
        panelMain.setIcon(bg);

        // Create the clock label and set its position
        clock = new Clock();
        clock.setBounds(172, 182-90, 935, 150);
        clock.setForeground(Color.decode("#675D50"));
        clock.setHorizontalAlignment(SwingConstants.CENTER);
        panelMain.add(clock);

        textLabel = new JLabel("<html>Christophorus Dharma Winata<br>Syarifa Dwi Purnamasari<br>Agsha Athalla Nurkareem<br>M Malik I Baharsyah<br>Jauza Lathifah Annassalafi</html>");
        textLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(25f));
        textLabel.setBounds(294, 379-90, 485, 189);
        textLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(textLabel);

        NIMLabel = new JLabel("<html>13521009<br>13521018<br>13521027<br>13521029<br>13521030</html>");
        NIMLabel.setFont(MainGUI.poppinsSemiBold.deriveFont(25f));
        NIMLabel.setBounds(848, 379-90, 485, 189);
        NIMLabel.setForeground(Color.decode("#675D50"));
        panelMain.add(NIMLabel);

        String path = "src/main/resources/images/Tab Halaman Utama.png";

        Map<JLabel, String> panelLabel = new HashMap<>();
        panelLabel.put(panelMain,path);

        return panelLabel;
    }

    // Clock class
    private class Clock extends JLabel implements Runnable {
        private DateFormat timeFormat;
        private DateFormat dateFormat;

        public Clock() {
            dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
            timeFormat = new SimpleDateFormat("hh:mm a");
            new Thread(this).start();
        }

        @Override
        public void run() {
            while (true) {
                Date date = new Date();
                String time = timeFormat.format(date);
                String dateStr = dateFormat.format(date);
                setFont(MainGUI.poppinsBold);
                setText("<html><center><span style='font-size: 40;'>" + dateStr + "</span><br><span style='font-size: 80;'>" + time + "</span></center></html>");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
