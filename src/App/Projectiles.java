package App;

import java.awt.Color;
import java.awt.Graphics2D;

public class Projectiles extends Entity{
    //private Color brown = new Color(118, 52, 35);
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
        g2.fillOval(x, y, width, height);
    }

    //Movement for the projectile. 
    public void move(){
        double mouseX = m.getMouseX();
        double mouseY = m.getMouseY();

        angle = Math.atan2(y - mouseY, x - mouseX);

        y -= speed * Math.sin(angle);
        x -= speed * Math.cos(angle);
    }
}