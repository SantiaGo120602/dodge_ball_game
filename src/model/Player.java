package src.model;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Player extends GameEntity {
    private Team team;
    private Ball ball;
    private String keyTag;
    private long punchStartTime;
    public Player(SpriteID id, int x, int y, int speed, int direction, Team team, Ball ball, String label, int Pid) {
        super(id, x, y, 70, 90, speed, direction, Pid);
        this.team = team;
        this.ball = ball;
        this.keyTag = label;
    }

    @Override
    public void update(GameState gameState) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - punchStartTime < 2000) {
                        if (this.getTeam() == Team.LOCAL_TEAM){
                    this.setSprite(SpriteFactory.getSprite(SpriteID.PLAYER_RIGHT_SHOT));
                } else {
                    this.setSprite(SpriteFactory.getSprite(SpriteID.PLAYER_LEFT_SHOT)); 
                }
        }

        for (GameEntity entity : gameState.getEntities()){
            if (this.getBounds().intersects(entity.getBounds())){
                if ((entity instanceof Ball)){
                    Ball mball = (Ball) entity;
                    if (mball.getTeam() != this.getTeam()){
                        Container parent = entity.getParent();
                        parent.remove(this);
                        parent.repaint();
                        mball.setxSpeed(0);
                        mball.setySpeed(0);
                        if (mball.getTeam() == Team.LOCAL_TEAM){
                            mball.setTeam(Team.OTHER_TEAM);
                        } else{
                            mball.setTeam(Team.LOCAL_TEAM);
                        }
                    } else if(this.getBall() == null){
                        mball.setTeam(this.getTeam());
                        this.setBall(mball);
                        mball.setX(mball.getX() + 60);
                    }
                    
                }
            }
        }
    }

    @Override
    public void updateSprite() {
        if ((this.getxSpeed() == 0) && (this.getySpeed() == 0)){
            if (this.getTeam() == Team.LOCAL_TEAM){
                this.setSprite(SpriteFactory.getSprite(SpriteID.PLAYER_RIGHT_IDLE));
            } else {
                this.setSprite(SpriteFactory.getSprite(SpriteID.PLAYER_LEFT_IDLE));
            }
        } else if (this.getxSpeed() > 0){
            this.setSprite(SpriteFactory.getSprite(SpriteID.PLAYER_RIGHT_RUNNING));
        } else if (this.getxSpeed() < 0){
            this.setSprite(SpriteFactory.getSprite(SpriteID.PLAYER_LEFT_RUNNING));
        } else if (this.getTeam() == Team.LOCAL_TEAM){
            this.setSprite(SpriteFactory.getSprite(SpriteID.PLAYER_RIGHT_RUNNING));
        } else {
            this.setSprite(SpriteFactory.getSprite(SpriteID.PLAYER_LEFT_RUNNING));
        }
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public String getKeyTag() {
        return keyTag;
    }

    public void setKeyTag(String keyTag) {
        this.keyTag = keyTag;
    }
    
    public void throwBall(){
        if (ball != null) {

            // Calculate the direction based on the player's facing direction
            int throwDirection = (team == Team.LOCAL_TEAM) ? 1 : -1;

            // Set the ball's initial speed based on the throw direction
            int throwSpeed = 20; // Adjust the throw speed as needed
            ball.setxSpeed(throwSpeed * throwDirection);
            ball.setySpeed(0);

            // Remove the ball from the player's possession
            ball = null;

            punchStartTime = System.currentTimeMillis();

            // Set up a timer to stop the punch animation after 2 seconds
            
            Timer punchTimer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Stop the punch animation-related actions here
                    Player.this.updateSprite();
                }
            });
            punchTimer.setRepeats(false); // Set to non-repeating
            punchTimer.start();
        }
    }

    public void catchBall(){
        
    }
}

