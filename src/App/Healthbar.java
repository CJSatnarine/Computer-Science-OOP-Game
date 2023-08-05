package App;

import java.awt.Color;
import java.awt.Graphics2D;

public class Healthbar {
    int health;

    public Healthbar(int playerHealth) {
        health = playerHealth;
    }
    
    public void draw(Graphics2D g2) {
        int x = 10;
        int y = 10;
        int width = health * 10;
        int height = 20;

        g2.setColor(Color.RED);
        g2.fillRect(x, y, width, height);
    }
}
