package App;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speed;
    private Random rand = new Random();

    public Enemy(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    /*
     * Method to draw a new rectangle and stores each rectangle in an array list.
     * 
     * @param g2 gains access to the Graphics2D object.
     * @param num is used to set the number of rectangles to draw. 
     * 
     * @return void
     */

    //Issue: cannot make rectangles draw in different, static y-positions. 
    public void draw(Graphics2D g2) {
        ArrayList <Rectangle> rect = new ArrayList<Rectangle>();
        
        //For loop to create/draw num amount of enemies
        // for (int i = 0; i <= num; i++) {
        //     rect.add(new Rectangle(x, y, width, height));
            //rect.add(createSprite(g2, x, y, width, height));

            g2.setColor(Color.WHITE);
            g2.fillRect(x, y, width, height);

            //Sets the colour of the rectangles to the background colour, because I couldn't "remove" them.
            if (x < 100) {
                disappear(g2);
            }
        // }
        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    public void disappear(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillRect(x, y, width, height);
    }

    public Rectangle createSprite(Graphics2D g2, int spriteX, int spriteY, int spriteWidth, int spriteHeight) {
        return new Rectangle(spriteX, spriteY, spriteWidth, spriteHeight);
    }

    /*
     * Moves the enemies.  
     * 
     * @return void. 
     */
    public void move() {
        x -= speed;
    }
}
