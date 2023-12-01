package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import src.model.GameEntity;
import src.model.GameModel;
import src.model.Menu;
import src.model.Player;
import src.model.Team;
import src.view.GameView;

public class UserInputController extends GameController {

    public UserInputController(GameModel model, GameView view) {
        super(model, view);
        view.getPlayButton().addActionListener(new PlayButtonListener());
        view.getMainExitButton().addActionListener(new ExitButtonListener());
        view.getPauseExitButton().addActionListener(new ExitButtonListener());
        view.getMainSettingsButton().addActionListener(new MainSettingsButtonListener());
        view.getSettingsBackButton().addActionListener(new SettingsBackButtonListener());
        view.getFieldFrame().addKeyListener(new CustomKeyListener());
    }
        
    @Override
    public void updateView() {
        this.getView().updateView(this.getModel());;
    }

    public void updateModel(GameModel newModel){
        updateView();
    }

    private class PlayButtonListener implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent e) {
                UserInputController.this.getModel().getApplicationState().setCurrentMenu(null);
                updateView();
                //switchFrame("field");
            }
    }
    private class MainSettingsButtonListener implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent e) {
                UserInputController.this.getModel().getApplicationState().setCurrentMenu(Menu.CONFIGURATION_MENU);
                updateView();
                //switchFrame("menu");
            }
    }
    private class SettingsBackButtonListener implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent e) {
                UserInputController.this.getModel().getApplicationState().setCurrentMenu(Menu.MAIN_MENU);
                updateView();
                //switchFrame("menu");
            }
    }
    private class ExitButtonListener implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent e) {
                endGame();
            }
    }

    public void endGame(){
        GameView g = super.getView();
        g.getDisplayFrame().dispose();
        System.exit(0);
    }
    
    private class CustomKeyListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            // Adjust speed and direction based on key pressed
            switch (e.getKeyChar()) {
                case 'a':
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setxSpeed(-10);
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setySpeed(0);
                    if (UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall() != null){
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setxSpeed(-10);
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setySpeed(0);
                    }
                    break;
                case 'd':
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setxSpeed(10);
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setySpeed(0);
                    if (UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall() != null){
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setxSpeed(10);
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setySpeed(0);
                    }
                    break;
                case 'w':
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setxSpeed(0);
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setySpeed(-10);
                    if (UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall() != null){
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setxSpeed(0);
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setySpeed(-10);
                    }
                    break;
                case 's':
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setxSpeed(0);
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setySpeed(10);
                    if (UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall() != null){
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setxSpeed(0);
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setySpeed(10);
                    }
                    break;
                case 'j':
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().throwBall();
                    break;
                case 'k':
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().catchBall();
                    break;
                case 'u':
                for (GameEntity entity: UserInputController.this.getModel().getApplicationState().getGameState().getEntities()){
                    if (entity instanceof Player){
                    Player p = (Player) entity;
                    if ((p.getTeam() == Team.LOCAL_TEAM) && (p.getKeyTag().equals("u"))){
                        UserInputController.this.getModel().getApplicationState().getGameState().setFocusedPlayer(p);
                    }
                }
                }
                break;
                case 'i':
                for (GameEntity entity: UserInputController.this.getModel().getApplicationState().getGameState().getEntities()){
                    if (entity instanceof Player){
                    Player p = (Player) entity;
                    if ((p.getTeam() == Team.LOCAL_TEAM) && (p.getKeyTag().equals("i"))){
                        UserInputController.this.getModel().getApplicationState().getGameState().setFocusedPlayer(p);
                    }
                }
                }
                break;
                case 'o':
                for (GameEntity entity: UserInputController.this.getModel().getApplicationState().getGameState().getEntities()){
                    if (entity instanceof Player){
                    Player p = (Player) entity;
                    if ((p.getTeam() == Team.LOCAL_TEAM) && (p.getKeyTag().equals("o"))){
                        UserInputController.this.getModel().getApplicationState().getGameState().setFocusedPlayer(p);
                    }
                    }
                }
                break;
                case 'p':
                for (GameEntity entity: UserInputController.this.getModel().getApplicationState().getGameState().getEntities()){
                    if (entity instanceof Player){
                    Player p = (Player) entity;
                    if ((p.getTeam() == Team.LOCAL_TEAM) && (p.getKeyTag().equals("p"))){
                        UserInputController.this.getModel().getApplicationState().getGameState().setFocusedPlayer(p);
                    }
                }
                }
            break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Stop the movement when the key is released
                UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setxSpeed(0);
                UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().setySpeed(0);
                if (UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall() != null){
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setxSpeed(0);
                    UserInputController.this.getModel().getApplicationState().getGameState().getFocusedPlayer().getBall().setySpeed(0);
                }
                
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Not used in this example
        }
    }
}

