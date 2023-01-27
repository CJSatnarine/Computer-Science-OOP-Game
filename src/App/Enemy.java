package App;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
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
    public void drawEnemy(Graphics2D g2, int num) {
        ArrayList <Rectangle> rect = new ArrayList<Rectangle>();
        boolean isEnough = false;
        
        //For loop to create/draw num amount of enemies
        for (int i = 0; i <= num; i++) {
            rect.add(new Rectangle(x, y, width, height));
            //rect.add(createSprite(g2, x, y, width, height));

            g2.setColor(Color.WHITE);
            g2.fill(rect.get(i));

            if (isEnough = false) {
                y = rand.nextInt(300) + height;
                if (i == num) {
                    isEnough = true;
                }
            }

            //Sets the colour of the rectangles to the background colour, because I couldn't "remove" them.
            if (x < 100) {
                g2.setColor(Color.BLACK);
                g2.fill(rect.get(i));
            }
        }
        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    public Rectangle createSprite(Graphics2D g2, int spriteX, int spriteY, int spriteWidth, int spriteHeight) {
        Rectangle r = new Rectangle(spriteX, spriteY, spriteWidth, spriteHeight);
        return r;
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
