package App;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Slug {

    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
    private Random rand = new Random();

    public Slug(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void draw(Graphics2D g2, int num) {
        //Rectangle[] rects = new Rectangle[num];
        ArrayList <Rectangle> rect = new ArrayList<Rectangle>();

        //For loop to create/draw num amount of enemies
        for (int i = 0; i <= num; i++) {
            //rects[i] = new Rectangle(x, y, width, height);
            rect.add(new Rectangle(x, y, width, height));

            g2.setColor(Color.WHITE);
            g2.fill(rect.get(i));
            //g2.fillRect(x, y + 100, width, height);
            //g2.fill(rects[i]);
        }

        //y = rand.nextInt(0, 600);

        // g2.setColor(Color.white);
        // g2.fillRect(x, y + height + 200, width, height);

        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    public void createSprite(Graphics2D g2, int spriteX, int spriteY, int spriteWidth, int spriteHeight) {
        Rectangle r = new Rectangle(spriteX, spriteY, spriteWidth, spriteHeight);
    }

    public void move() {
        x += speed;
    }
}
