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

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(brown);
        g2.fillOval(x, y, width, height);
    }

    public void move(){
        double mouseX = m.returnMouseX();
        double mouseY = m.returnMouseY();

        angle = Math.atan2(y - mouseX, x - mouseX);

        y -= speed * Math.sin(angle);
        x -= speed * Math.cos(angle);
    }
}
