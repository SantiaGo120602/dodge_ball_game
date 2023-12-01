package src.model;

import java.util.ArrayList;
import java.util.HashMap;

public class GameState {
    private ArrayList<GameEntity> entities;
    private FieldEntity field;
    public HashMap<Team, Integer> score;
    public Team winner;
    public int timeLeft;

    public GameState(int timeLeft) {
        this.entities = new ArrayList<>();
        int lasty = 220;
        for (int i = 0; i < 4; i++){
            Ball ball = null;
            if (i < 2){
                ball = new Ball(100, lasty, 0, 0, Team.LOCAL_TEAM, i+10);
            }
            entities.add(new Player(SpriteID.PLAYER_RIGHT_IDLE, 100, lasty, 0, 0, Team.LOCAL_TEAM, ball, null, i));
            if (ball != null){
                entities.add(ball);
            }
            lasty += 110;
        }
        lasty = 220;
        for (int i = 4; i < 8; i++){
            Ball ball = null;
            if (i > 1){
                ball = new Ball(1720, lasty, 0, 0, Team.LOCAL_TEAM, i+10);
            }
            entities.add(new Player(SpriteID.PLAYER_LEFT_IDLE, 1720, lasty, 0, 0, Team.OTHER_TEAM, ball, null, i));
            if (ball != null){
                entities.add(ball);
            }
            lasty += 110;
        }
        this.field = new FieldEntity();
        this.score = new HashMap<>();
        this.score.put(Team.LOCAL_TEAM, 0);
        this.score.put(Team.OTHER_TEAM, 0);
        this.winner = null;
        this.timeLeft = timeLeft;
    }

    public void registerEntity(GameEntity e){
        entities.add(e);
    }
    
    public void unregisterEntity(GameEntity e){
        entities.remove(e);
    }

    public void notifyEntities(){
        for (GameEntity entity : entities){
            entity.update(this);
        }
    }

    public ArrayList<GameEntity> getEntities() {
        return entities;
    }

    public FieldEntity getField() {
        return field;
    }

    public HashMap<Team, Integer> getScore() {
        return score;
    }

    public Team getWinner() {
        return winner;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setWinner(Team team) {
        winner = team;
    }
}
