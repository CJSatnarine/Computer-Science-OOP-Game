package App;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Player extends Entity{
    
    //Variables
    private Color purple = new Color(123, 50, 150);
    private int size;
    private double angle;
    public int health = 10;

    private KeyHandler k;
    private MouseMovement mouseMove;

    public Player(int x, int y, int size, int speed, double angle, KeyHandler k, MouseMovement mouseMove) {
        super(x, y, size, size, speed);
        this.size = size;
        this.angle = angle;
        this.k = k;
        this.mouseMove = mouseMove;
    }

    public void draw(Graphics2D g2) {
        AffineTransform reset = g2.getTransform();

        g2.rotate(angle, x + (size / 2), y + (size / 2));
        g2.setColor(purple);
        g2.fillRect(x, y, size, size);
        g2.setColor(Color.WHITE);
        g2.setTransform(reset);

        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    //Movement based on keyboard input. 
    public void move() {

        //Formula to make the rectangle rotate properly.
        angle = Math.atan2(y - mouseMove.getMouseY(), x - mouseMove.getMouseX());

        //Code to go forwards.
        if (k.upPressed) {
            y -= speed; //Moves up when W is pressed. 
        } 
        
        //Code to go backwards.
        else if (k.downPressed) {
            y += speed; //Moves down when S is pressed. 
        } 

        //Code to go the left.
        else if (k.leftPressed) {
            x -= speed; //Moves left when A is pressed.
        }

        //Code to go the right.
        else if (k.rightPressed) {
            x += speed; //Moves right when D is pressed.
        }
    }

    public void reduceHealth() {
        if (health > 0) health--;
        System.out.println(health);
    }
}