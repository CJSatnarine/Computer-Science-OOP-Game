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

    /*
    Description: Method to draw a new rectangle and stores each rectangle to an array list. 
    @g2: Uses the Graphics2D
    @num: is used to set the number of rectangles to draw 
    */

    //Issue: cannot make rectangles draw in different, static y-positions. 
    public void draw(Graphics2D g2, int num) {
        //Rectangle[] rects = new Rectangle[num];
        ArrayList <Rectangle> rect = new ArrayList<Rectangle>();

        //For loop to create/draw num amount of enemies
        for (int i = 0; i <= num; i++) {;
            rect.add(new Rectangle(x, y, width, height));

            g2.setColor(Color.WHITE);
            g2.fill(rect.get(i));
            //y = rand.nextInt(10);
        }

        //y = rand.nextInt(0, 600);
        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    public void createSprite(Graphics2D g2, int spriteX, int spriteY, int spriteWidth, int spriteHeight) {
        Rectangle r = new Rectangle(spriteX, spriteY, spriteWidth, spriteHeight);
    }

    public void move() {
        x -= speed;
    }
}
