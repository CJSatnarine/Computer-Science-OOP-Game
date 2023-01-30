package App;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.Random;

public class AdvancedEnemy extends Enemy {
    private Random random = new Random();
    private double angle;
    // private Player p; //IThis is null.  

    // //I need to somehow get playerX and playerY positions. 
    // private int playerXPos = p.getPlayerX();
    // private int playerYPos = p.getPlayerY();


    public AdvancedEnemy(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        y = random.nextInt(600 - height);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect(x - 50, y + 50, width, height);
    }

    // public void move() {
    //     angle = Math.atan2(y - playerYPos, x - playerXPos);
        
    //     y -= speed * Math.sin(angle);
    //     x -= speed * Math.cos(angle);
    // }
}