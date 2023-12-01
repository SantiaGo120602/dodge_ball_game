package src.model;

public class Ball extends GameEntity {
    private Team team;
    public Ball(int x, int y, int speed, int direction, Team team) {
        super(SpriteID.BALL_STATIC, x, y, 30, 30, speed, direction);
        this.team = team;
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

    
    
}
