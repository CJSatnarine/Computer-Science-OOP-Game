package App;

import java.awt.Color;
import java.awt.Graphics2D;

public class Animal {
    
    //animal coordinates
    private int x;
    private int y;
    private int size;
    private int speed;
    private KeyHandler k;
    private Color purple = new Color(123, 50, 150);

    public Animal(int x, int y, int size, int speed, KeyHandler k) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
        this.k = k;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(purple);
        g2.fillRect(x, y, size, size);

        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    public void move() {
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
