package App;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Panel extends JPanel {
    public int playerX = 0;
    public int playerY = 0;
    public int playerWidth = 30;
    public int playerHeight = 30;


    Panel() {
        this.setPreferredSize(new Dimension(400, 400));
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g; 
        
        g2D.fillRect(playerX, playerHeight, playerWidth, playerHeight);
    }
}
