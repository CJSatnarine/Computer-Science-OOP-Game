package App;

import javax.swing.JFrame;
import java.awt.Color;

public class GUI extends JFrame
{
    Panel panel;
    MouseMovement mouseMovement = new MouseMovement();
    GUI()
    {
        panel = new Panel();

        this.setTitle("Slugbury: Animal Edition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(panel);
        this.setBackground(Color.BLACK);
        this.pack();
        this.setVisible(true);
        this.addMouseListener(mouseMovement);
    }
}
