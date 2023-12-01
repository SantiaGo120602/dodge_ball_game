package src.model;

import javax.swing.*;

public abstract class GameEntity extends JLabel {
    private int x, y, width, height, xSpeed, ySpeed, playerID;
    private Sprite sprite;

    public GameEntity(SpriteID id, int x, int y, int width, int height, int xSpeed, int ySpeed, int playerID) {
        super(SpriteFactory.getSprite(id).getIcon());
        this.sprite = SpriteFactory.getSprite(id);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
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

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
        super.setIcon(sprite.getIcon());
    }

    public void move() {
        this.x+= this.xSpeed;
        this.y+= this.ySpeed;
        if (this.x < 0){
            this.x = 0;
        } else if (this.x > (1920 - this.width)){
            this.x = 1920 - this.width;
        }
        if (this.y < 0){
            this.y = 0;
        } else if (this.y > (980 - this.height)){
            this.y = 980 - this.height;
        }

        if (this instanceof Player){
            Player p = (Player) this;
            if (p.getTeam() == Team.LOCAL_TEAM){
                if (this.x > (960)){
                    this.x = 960;
                }
            }
        }

        setBounds(x, y, width, height);
    }

    public abstract void update(GameState gameState);
    public abstract void updateSprite();

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
        updateSprite();
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
        updateSprite();
    }

}