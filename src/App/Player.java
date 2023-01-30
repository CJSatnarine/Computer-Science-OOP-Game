package App;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Player {
    
    //Variables
    private Color purple = new Color(123, 50, 150);
    private double angle;
    private int x;
    private int y;
    private int size;
    private int speed;
    private KeyHandler k;
    private MouseMovement mouseMove;

    public Player(int x, int y, int size, int speed, double angle, KeyHandler k, MouseMovement mouseMove) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
        this.angle = angle;
        this.k = k;
        this.mouseMove = mouseMove;
    }

    public int getPlayerX() {
        return x;
    }

    public int getPlayerY() {
        return y;
    }

    public void draw(Graphics2D g2) {
        AffineTransform reset = g2.getTransform();

        g2.rotate(angle, x + (size / 2), y + (size / 2));
        g2.setColor(purple);
        g2.fillRect(x, y, size, size);
        g2.rotate(-angle, x + (size / 2), y + (size / 2));
        g2.setTransform(reset);

        //g2.dispose(); //causes the JFrame window to be destroyed and cleaned up by the operating system.
    }

    //Movement based on keyboard input. 
    public void move() {

        //Formula to make the rectangle rotate properly.
        angle = Math.atan2(y - mouseMove.returnMouseY(), x - mouseMove.returnMouseX());

        if (k.upPressed) {
            //y -= speed; //Moves up when W is pressed. 

            //This makes the rectangle revolve around the mouse cursor. It looks funny. 
            // x += speed * Math.sin(angle);
            // y -= speed * Math.cos(angle);

            y -= speed * Math.sin(angle);
            x -= speed * Math.cos(angle);
        } 
        
        else if (k.downPressed) {
            //y += speed; //Moves down when S is pressed. 

            y += speed * Math.sin(angle);
            x += speed * Math.cos(angle);
        } 

        else if (k.leftPressed) {
            //x -= speed; //Moves left when A is pressed. 

             y -= speed * Math.sin(angle);
             x += speed * Math.cos(angle);
        }
        else if (k.rightPressed) {
            //x += speed; //Moves right when D is pressed. 
            
            y += speed * Math.sin(angle);
            x -= speed * Math.cos(angle);
        }
    }
}