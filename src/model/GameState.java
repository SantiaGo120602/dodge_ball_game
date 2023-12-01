package src.model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingUtilities;

public class GameState {
    private ArrayList<GameEntity> entities;
    private Player focusedPlayer; 
    private FieldEntity field;
    public HashMap<Team, Integer> score;
    public Team winner;
    public int timeLeft;
    public LabelMovementTask labelMovementTask;

    public GameState(int timeLeft){
        String characters = "uiop";
        this.entities = new ArrayList<>();
        int lasty = 220;
        for (int i = 0; i < 4; i++){
            Ball ball = null;
            if (i < 2){
                ball = new Ball(160, lasty, 0, 0, Team.LOCAL_TEAM, i+10);
            }
            
            Player player = new Player(SpriteID.PLAYER_RIGHT_IDLE, 100, lasty, 0, 0, Team.LOCAL_TEAM, ball, Character.toString(characters.charAt(i)), i);
            if (i == 0){
                focusedPlayer = player; 
            }
            entities.add(player);
            if (ball != null){
                entities.add(ball);
            }
            lasty += 110;
        }
        lasty = 220;
        for (int i = 4; i < 8; i++){
            Ball ball = null;
            if (i > 5){
                ball = new Ball(1700, lasty, 0, 0, Team.OTHER_TEAM, i+10);
            }
            entities.add(new Player(SpriteID.PLAYER_LEFT_IDLE, 1720, lasty, 0, 0, Team.OTHER_TEAM, ball, Character.toString(characters.charAt(i-4)), i));
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
        this.labelMovementTask = new LabelMovementTask(entities);

    }

    public void registerEntity(GameEntity e){
        entities.add(e);
    }
    
    public void unregisterEntity(GameEntity e){
        entities.remove(e);
    }
    public Player getFocusedPlayer() {
        return focusedPlayer;
    }

    public void setFocusedPlayer(Player focusedPlayer) {
        this.focusedPlayer = focusedPlayer;
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

    public LabelMovementTask getLabelMovementTask() {
        return labelMovementTask;
    }

    public void setLabelMovementTask(LabelMovementTask labelMovementTask) {
        this.labelMovementTask = labelMovementTask;
    }

    public void runGameLoop() {
        // Your game loop logic goes here
        while (true) {
            // Update game state
            notifyEntities();

            // Perform other game-related tasks

            // Update Swing components on the event dispatch thread
            SwingUtilities.invokeLater(() -> {
                // Update Swing components based on the game state
                // This can include updating labels, drawing entities, etc.
            });

            // Sleep or delay for a short interval (e.g., 16 milliseconds for 60 FPS)
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
