package src.model;

import javax.swing.JLabel;

public class Player extends GameEntity {
    private Team team;
    private Ball ball;
    private JLabel keyTag;
    public Player(SpriteID id, int x, int y, int speed, int direction, Team team, Ball ball, JLabel label, int Pid) {
        super(id, x, y, 70, 90, speed, direction, Pid);
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

