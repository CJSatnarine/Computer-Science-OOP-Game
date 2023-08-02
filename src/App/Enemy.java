package App;

import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy extends Entity {

    public Enemy(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
    }

    /*
     * Method to draw a new rectangle and stores each rectangle in an array list.
     * 
     * @param g2 gains access to the Graphics2D object.
     */

    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(x, y, width, height);

        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    //Moves the enemy.
    public void move() {
        x -= speed;
    }
}
