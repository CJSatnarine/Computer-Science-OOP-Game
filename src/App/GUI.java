package App;

import javax.swing.JFrame;
import java.awt.Color;

public class GUI extends JFrame
{
    Panel panel;
    GUI()
    {
        panel = new Panel();

        this.setTitle("SLugbury: Animal Edition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}
