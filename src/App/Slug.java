package App;

import java.awt.Color;
import java.awt.Graphics2D;

public class Slug {

    private  int x;
    private final int y;
    private int width;
    private int height;
    private int speed;

    public Slug(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, width, height);

        x += speed;

        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    public void move() {

    }
}
