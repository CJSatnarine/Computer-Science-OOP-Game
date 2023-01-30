package App;

import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speed;

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
     * 
     * @return void
     */

    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(x, y, width, height);

        //Sets the colour of the rectangles to the background colour, because I couldn't "remove" them.
        if (x == 70) {
            disappear(g2);
        }
        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    /*
     * Makes the current rectangle's colour be that of the background, making it "disappear".
     * 
     * @param g2 gains access to the Graphics2D object. 
     * 
     * @return void.
     */
    public void disappear(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillRect(x, y, width, height);
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
