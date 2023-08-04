package App;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

import java.util.Random;

public class AdvancedEnemy extends Enemy {
    //Variables
    private Random random = new Random();
    private double angle;

    public AdvancedEnemy(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        y = random.nextInt(600 - height);
    }

    //Draws the advanced enemy. 
    @Override
    public void draw(Graphics2D g2) {
        AffineTransform reset = g2.getTransform();
        g2.setColor(Color.RED);
        g2.rotate(angle, x + (width / 2), y + (height / 2));
        g2.fillRect(x, y, width, height);
        g2.rotate(-angle, x + (width / 2), y + (height / 2));
        g2.setTransform(reset);

    }

    //Moves the advanced enemy towards the player's position, making it following the player. 
    public void move(Player player) {
        int playerX = (int) player.getX();
        int playerY = (int) player.getY();

        angle = Math.atan2(y - playerY, x - playerX);

        y -= speed * Math.sin(angle);
        x -= speed * Math.cos(angle);
    }
}