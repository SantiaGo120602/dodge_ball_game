package src.model;

import javax.swing.JLabel;

public class Player extends Entity {
    private Team team;
    private Ball ball;
    private JLabel keyTag;
    public Player(SpriteID id, int x, int y, int width, int height, int speed, int direction, Team team, Ball ball, JLabel label) {
        super(id, x, y, width, height, speed, direction);
        this.team = team;
        this.ball = ball;
        this.keyTag = label;
    }

    @Override
    public void update(GameState GameState) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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

    public JLabel getKeyTag() {
        return keyTag;
    }

    public void setKeyTag(JLabel keyTag) {
        this.keyTag = keyTag;
    }
    
    
}

