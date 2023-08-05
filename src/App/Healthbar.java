package App;

import java.awt.Color;
import java.awt.Graphics2D;

public class Healthbar {
    int health;
    boolean hit;

    int x = 10;
    int y = 10;
    int width = health * 10;
    int height = 20;

    public Healthbar(int playerHealth, boolean isHit) {
        health = playerHealth;
        hit = isHit;
    }
    
    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect(x, y, width, height);
    }

    public void reduceHealthBar() {
        if(hit) {
            health -= 10;
            hit = false;
        }
    }
}
