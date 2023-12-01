package src;

import javax.swing.JFrame;

import src.controller.UDPController;
import src.controller.UDPServer;
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
        UDPServer server = null;
        try {
            server = new UDPServer("168.228.124.133", 9876);
        } catch (Exception e) {
            // TODO: handle exception
        }
        UDPController udpController = new UDPController(model, view, server);
        JFrame frame = userInputController.getView().getDisplayFrame();
        frame.setVisible(true);
        Thread movementThread = new Thread(model.getApplicationState().getGameState().getLabelMovementTask());
        movementThread.start();
        Thread gameThread = new Thread(() -> model.getApplicationState().getGameState().runGameLoop());
            gameThread.start();
        Thread communicationThread = new Thread(() -> udpController.startCommunication());
            communicationThread.start();
        Thread pThread = new Thread(() -> udpController.startRecieving());
            pThread.start();
    }

   
}
