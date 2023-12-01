package src;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import src.model.Ball;
import src.model.FieldEntity;
import src.model.GameEntity;
import src.model.Player;
import src.model.SpriteID;
import src.model.Team;
import src.view.FieldFrame;
import src.view.GameMenu;

public class Main {
    public static void main(String[] args) {
        ArrayList<GameEntity> entities = new ArrayList<>();
        int lasty = 220;
        for (int i = 0; i < 4; i++){
            Ball ball = null;
            if (i < 2){
                ball = new Ball(100, lasty, 0, 0, Team.LOCAL_TEAM);
            }
            entities.add(new Player(SpriteID.PLAYER_RIGHT_IDLE, 100, lasty, 0, 0, Team.LOCAL_TEAM, ball, null));
            if (ball != null){
                entities.add(ball);
            }
            lasty += 110;
        }
        lasty = 220;
        for (int i = 0; i < 4; i++){
            Ball ball = null;
            if (i > 1){
                ball = new Ball(1720, lasty, 0, 0, Team.LOCAL_TEAM);
            }
            entities.add(new Player(SpriteID.PLAYER_LEFT_IDLE, 1720, lasty, 0, 0, Team.OTHER_TEAM, ball, null));
            if (ball != null){
                entities.add(ball);
            }
            lasty += 110;
        }
        SwingUtilities.invokeLater(() -> {
            FieldFrame frame = new FieldFrame("01", "01", "100", new FieldEntity(), entities);
            frame.setVisible(true);
        });

    }
}
