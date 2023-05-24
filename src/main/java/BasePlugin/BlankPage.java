package BasePlugin;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class BlankPage extends JFrame {
    private String title;
    private JPanel panel;

    public BlankPage() {
        // Set up the frame properties
        setTitle("Blank Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        
        // Create a container panel
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        
        // Set the layout of the container panel
        panel.setLayout(new GridLayout(1, 1));
        this.panel = panel;
    }

    public void setGrid(int rows, int columns){
        this.panel.setLayout(new GridLayout(rows, columns));
    }

    public void setTitle(String title){
        this.title = title;
    }

    

    // public static void main(String[] args) {
    //     // Create an instance of your blank page
    //     BlankPage page = new BlankPage();
    //     page.setVisible(true);
    // }
}
