package App;

import java.awt.Color;
import java.awt.Graphics2D;

public class Projectiles extends Entity {
    private double angle;
    private double magnitude;

    public Projectiles(int x, int y, int width, int height, int speed, double magnitude, MouseMovement m) {
        super(x, y, width, height, speed);
        this.magnitude = magnitude;   

        // Calculating the angle.
        double mouseX = m.getMouseX();
        double mouseY = m.getMouseY();
        double dirX = mouseX - x;
        double dirY = mouseY - y;
        angle = Math.atan2(dirY, dirX); 
    }

    //Draws the projectile.
    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillOval(x, y, width, height);
    }

    //Movement for the projectile. 
    public void move() {
        double deltaX = magnitude * speed * Math.cos(angle);
        double deltaY = magnitude * speed * Math.sin(angle);

        x += (int) deltaX;
        y += (int) deltaY;
    }
}