package GUI;

import javax.swing.*;
import java.util.Map;

public class TabbedPane extends JTabbedPane {

    public void addTabs(Map<JLabel, String> panelLabelMap) {
        for (Map.Entry<JLabel, String> entry : panelLabelMap.entrySet()) {
            addTab("", new ImageIcon(entry.getValue()), entry.getKey());
        }
    }

//    public void removeTabs(Map<JLabel, String> panelLabelMap, JLabel selectedLabel) {

}
