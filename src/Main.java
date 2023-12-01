package src;

import javax.swing.JFrame;

import src.controller.UDPController;
import src.controller.UserInputController;
import src.model.ApplicationState;
import src.model.GameModel;
import src.model.GameState;
import src.model.Menu;
import src.view.GameView;

public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel(ApplicationState.getInstance(new GameState(100), Menu.MAIN_MENU));
        GameView view = new GameView(model);
        UserInputController userInputController = new UserInputController(model, view);
        UDPController udpController = new UDPController(model, view);
        JFrame frame = userInputController.getView().getDisplayFrame();
        frame.setVisible(true);
        Thread movementThread = new Thread(model.getApplicationState().getGameState().getLabelMovementTask());
        movementThread.start();
        Thread gameThread = new Thread(() -> model.getApplicationState().getGameState().runGameLoop());
            gameThread.start();
        Thread communicationThread = new Thread(() -> udpController.startCommunication());
            communicationThread.start();
    }

   
}
