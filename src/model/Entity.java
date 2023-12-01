package src.model;

import javax.swing.*;

public abstract class Entity extends JLabel {
    private int x, y, width, height, speed, direction;
    private Sprite sprite;

    public Entity(SpriteID id, int x, int y, int width, int height, int speed, int direction) {
        super(SpriteFactory.getSprite(id).getIcon());
        this.sprite = SpriteFactory.getSprite(id);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
        setBounds(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
        setBounds(x, y, width, height);
    }

    public abstract void update(GameState GameState);

}