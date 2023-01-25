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
        int newY = y;
        ArrayList <Rectangle> rect = new ArrayList<Rectangle>();

        //For loop to create/draw num amount of enemies
        for (int i = 0; i <= num; i++) {
            rect.add(new Rectangle(x, newY, width, height));

            g2.setColor(Color.WHITE);
            g2.fill(rect.get(i));

            if (newY == y) {
                newY = rand.nextInt(300) + height;
            }

            //Sets the colour of the rectangles to the background colour, because I couldn't "remove" them.
            if (x < 300) {
                g2.setColor(Color.BLACK);
                g2.fill(rect.get(i));
            }
        }

        //y = rand.nextInt(600);
        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
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
