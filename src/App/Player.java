package App;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Player {
    
    //Variables
    private Color purple = new Color(123, 50, 150);
    private double angle;
    private int x;
    private int y;
    private int size;
    private int speed;
    private KeyHandler k;
    private MouseMovement mouseMove;

    public Player(int x, int y, int size, int speed, double angle, KeyHandler k, MouseMovement mouseMove) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
        this.angle = angle;
        this.k = k;
        this.mouseMove = mouseMove;
    }

    public void drawPlayer(Graphics2D g2) {
        AffineTransform reset = g2.getTransform();

        g2.rotate(angle, x + (size / 2), y+ (size / 2));
        g2.setColor(purple);
        g2.fillRect(x, y, size, size);
        g2.rotate(-angle, x + (size / 2), y+ (size / 2));
        g2.setTransform(reset);

        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    //Movement based on keyboard input. 
    public void move() {
        //angle = Math.atan2(mouseMove.returnX() - ((y + size) / 2), mouseMove.returnY() - ((x + size) / 2));
        //angle = Math.atan2(mouseMove.returnX() - (y + (size / 2)), mouseMove.returnY() - (x + (size / 2)));
        angle = Math.atan2(y - mouseMove.returnY(), x - mouseMove.returnX());
        
        if (k.upPressed) {
            y -= speed;
        } 
        
        else if (k.downPressed) {
            y += speed;
        } 

        else if (k.leftPressed) {
            x -= speed;
        }
        else if (k.rightPressed) {
            x += speed;
        }
    }

}
