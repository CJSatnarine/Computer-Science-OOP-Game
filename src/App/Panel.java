package App;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JPanel;

public class Panel extends JPanel 
{
    Panel()
    {
        this.setPreferredSize(new Dimension(400, 400));
    }

    public void paint(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g; 

        g2D.setPaint(new Color(123, 50, 250));
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(0, 0, 400, 400);

        g2D.fillRect(0, 0, 50, 50);
    }
}
