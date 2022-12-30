package App;

import javax.swing.JFrame;
import java.awt.Color;

public class GUI extends JFrame
{
    GUI()
    {
        int frameWidth = 400;
        int frameHeight = 400;
        
        this.setTitle("SLugbury: Animal Edition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(frameWidth, frameHeight);
        this.setVisible(true);

        //Makes a nice purple colour.
        this.getContentPane().setBackground(new Color(123, 50, 250));
    }
}
