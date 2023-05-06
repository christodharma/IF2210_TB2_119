package oop.tubes2;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class TabbedPane extends JTabbedPane {

    public TabbedPane(Map<JLabel, String> panelLabelMap) {
        addTabs(panelLabelMap);
    }

    public void addTabs(Map<JLabel, String> panelLabelMap) {
        for (Map.Entry<JLabel, String> entry : panelLabelMap.entrySet()) {
            addTab("", new ImageIcon(entry.getValue()), entry.getKey());
        }
    }

//    public void removeTabs(Map<JLabel, String> panelLabelMap, JLabel selectedLabel) {

}
