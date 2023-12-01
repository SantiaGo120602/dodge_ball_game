package src.model;

public class Ball extends Entity {
    private Team team;
    public Ball(SpriteID id, int x, int y, int width, int height, int speed, int direction, Team team) {
        super(id, x, y, width, height, speed, direction);
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
