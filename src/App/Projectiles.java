package App;

import java.awt.Color;
import java.awt.Graphics2D;

public class Projectiles extends Entity{
    private Color brown = new Color(118, 52, 35);
    private double angle;
    private MouseMovement m;

    public Projectiles(int x, int y, int width, int height, int speed, MouseMovement m) {
        super(x, y, width, height, speed);
        this.m = m;
    }

    //Draws the projectile.
    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        //g2.setColor(brown);
        g2.fillOval(x, y, width, height);
    }

    //Movement for the projectile. 
    public void move() {
        double mouseX = m.getMouseX();
        double mouseY = m.getMouseY();

        double dirX = mouseX - x;
        double dirY = mouseY - y;
        
        angle = Math.atan2(dirY, dirX);

        //angle = Math.atan2(y - mouseY, x - mouseX);
        // double direction = Math.sin(angle) + Math.cos(angle);

        // y += speed * direction;
        // x += speed * direction;

        x += speed * Math.sin(angle);
        y += speed * Math.cos(angle);

        System.out.println("Angle: " + angle);

    }
}