package App;

//Imports
import javax.swing.JFrame; 
import java.awt.Color;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        int frameWidth = 400;
        int frameHeight = 400;

        JFrame frame = new JFrame();
        frame.setTitle("SLugbury: Animal Edition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.black);
    }
}
