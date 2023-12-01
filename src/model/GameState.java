package src.model;

import java.util.ArrayList;
import java.util.HashMap;

public class GameState {
    private ArrayList<Entity> entities;
    private FieldEntity field;
    public HashMap<Team, Integer> score;
    public Team winner;
    public int timeLeft;

    public GameState(int timeLeft) {
        this.entities = new ArrayList<>();
        this.field = new FieldEntity(SpriteID.FIELD, 0, 0, 1920, 980, 0, 0);
        this.score = new HashMap<>();
        this.score.put(Team.LOCAL_TEAM, 0);
        this.score.put(Team.OTHER_TEAM, 0);
        this.winner = null;
        this.timeLeft = timeLeft;
    }

    public void registerEntity(Entity e){
        entities.add(e);
    }
    
    public void unregisterEntity(Entity e){
        entities.remove(e);
    }

    public void notifyEntities(){
        for (Entity entity : entities){
            entity.update(this);
        }
    }

    public ArrayList<Entity> getEntities() {
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
