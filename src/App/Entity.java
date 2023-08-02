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

    // Get and set x.
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    // Get and set y. 
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    // Get and set width. 
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    // Get and set height. 
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    // Get and set speed. 
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Draws the entity;
    public abstract void draw(Graphics2D g2);

    // Interects. 
    public boolean intersects(Entity entity) {
        Rectangle thisBounds = new Rectangle(x, y, width, height);
        Rectangle entityBounds = new Rectangle(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
        return thisBounds.intersects(entityBounds);
    }
}
