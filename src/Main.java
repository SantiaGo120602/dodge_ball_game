package src;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import src.model.ApplicationState;
import src.model.Ball;
import src.model.FieldEntity;
import src.model.GameEntity;
import src.model.GameModel;
import src.model.GameState;
import src.model.Menu;
import src.model.Player;
import src.model.SpriteID;
import src.model.Team;
import src.view.FieldFrame;
import src.view.GameMenu;
import src.view.GameView;

public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel(ApplicationState.getInstance(new GameState(100), Menu.MAIN_MENU));
        GameView view = new GameView(model);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = view.getDisplayFrame();
            frame.setVisible(true);
        });

    }
}
