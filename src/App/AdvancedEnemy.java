package App;

import java.awt.Color;
import java.awt.Graphics2D;

import java.util.Random;

public class AdvancedEnemy extends Enemy {
    private Random random = new Random();
    private double angle;

    public AdvancedEnemy(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        y = random.nextInt(600 - height);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect(x, y, width, height);

        if (x < 200) {
            disappear(g2);
        }
    }

    public void move(Player player) {
        int playerX = player.getPlayerX();
        int playerY = player.getPlayerY();

        angle = Math.atan2(y - playerY, x - playerX);

        y -= speed * Math.sin(angle);
        x -= speed * Math.cos(angle);
      }
}