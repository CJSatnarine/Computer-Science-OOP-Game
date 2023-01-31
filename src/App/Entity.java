package App;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity {
    //Entity variables.
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speed;
    protected Rectangle hitBox;

    public Entity(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public double getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //Draws the entity;
    public abstract void draw(Graphics2D g2);
}
