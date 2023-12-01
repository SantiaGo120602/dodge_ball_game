package src;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import src.controller.GameController;
import src.controller.UserInputController;
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
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel(ApplicationState.getInstance(new GameState(100), Menu.MAIN_MENU));
        GameView view = new GameView(model);
        UserInputController userInputController = new UserInputController(model, view);
        JFrame frame = userInputController.getView().getDisplayFrame();
        frame.setVisible(true);
        Thread movementThread = new Thread(model.getApplicationState().getGameState().getLabelMovementTask());
        movementThread.start();
        Thread gameThread = new Thread(() -> model.getApplicationState().getGameState().runGameLoop());
            gameThread.start();
        // SwingUtilities.invokeLater(() -> {
            
        // });

    }

   
}
