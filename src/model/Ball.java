package src.model;
public class Ball extends GameEntity {
    private Team team;
    public Ball(int x, int y, int speed, int direction, Team team, int id) {
        super(SpriteID.BALL_STATIC, x, y, 30, 30, speed, direction, id);
        this.team = team;
    }

    @Override
    public void update(GameState gameState) {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public void updateSprite() {
        if ((this.getxSpeed() != 0) || (this.getySpeed() != 0)){
            if (this.getSprite() == SpriteFactory.getSprite(SpriteID.BALL_STATIC)){
                this.setSprite(SpriteFactory.getSprite(SpriteID.BALL_MOVING));
            }
        } else {
            this.setSprite(SpriteFactory.getSprite(SpriteID.BALL_STATIC));
        }
    }

    
    
}
