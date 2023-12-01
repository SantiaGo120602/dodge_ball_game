package src.model;

import javax.swing.*;

public abstract class GameEntity extends JLabel {
    private int x, y, width, height, speed, direction, playerID;
    private Sprite sprite;

    public GameEntity(SpriteID id, int x, int y, int width, int height, int speed, int direction, int playerID) {
        super(SpriteFactory.getSprite(id).getIcon());
        this.sprite = SpriteFactory.getSprite(id);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
        this.playerID = playerID;
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

    public int getPlayerID() {
        return playerID;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
        setBounds(x, y, width, height);
    }

    public abstract void update(GameState GameState);

}