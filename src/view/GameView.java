package src.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.model.GameModel;
import src.model.Menu;
import src.model.Team;

public class GameView {

    private HashMap<Menu, GameMenu> menuMap = new HashMap<>();
    
    private ImageButton audioSquareButton = new ImageButton("src/resources/ui_components/AudioSquareButton.png", 200, 200);
    private ImageButton quiestionMarkSquareButton = new ImageButton("src/resources/ui_components/QuestionmarkSquareButton.png", 200, 200);
    private ImageButton pauseBackButton = new ImageButton("src/resources/ui_components/BackButton.png", 200, 100);
    private ImageButton settingsBackButton = new ImageButton("src/resources/ui_components/BackButton.png", 200, 100);
    private ImageButton mainExitButton = new ImageButton("src/resources/ui_components/ExitButton.png", 200, 100);
    private ImageButton pauseExitButton = new ImageButton("src/resources/ui_components/ExitButton.png", 200, 100);
    private ImageButton newgameButton = new ImageButton("src/resources/ui_components/NewgameButton.png", 200, 100);
    private ImageButton playButton = new ImageButton("src/resources/ui_components/PlayButton.png", 200, 100);
    private ImageButton mainSettingsButton = new ImageButton("src/resources/ui_components/SettingsButton.png", 200, 100);
    private ImageButton pauseSettingsButton = new ImageButton("src/resources/ui_components/SettingsButton.png", 200, 100);
    private ImageButton quitButton = new ImageButton("src/resources/ui_components/QuitButton.png", 200, 100);
    
    private JFrame displayFrame;
    private GameMenu gameMenu;
    private FieldFrame fieldFrame;

    public GameView(GameModel model){
        ArrayList<ImageButton> mainMenuButtons = new ArrayList<>();
        mainMenuButtons.add(playButton);
        mainMenuButtons.add(newgameButton);
        mainMenuButtons.add(mainSettingsButton);
        mainMenuButtons.add(mainExitButton);
        menuMap.put(Menu.MAIN_MENU, new GameMenu("Main Menu", mainMenuButtons));


        ArrayList<ImageButton> pauseMenuButtons = new ArrayList<>();
        pauseMenuButtons.add(pauseBackButton);
        pauseMenuButtons.add(pauseSettingsButton);
        pauseMenuButtons.add(quitButton);
        pauseMenuButtons.add(pauseExitButton);
        menuMap.put(Menu.PAUSE_MENU, new GameMenu("Pause Menu", pauseMenuButtons));


        ArrayList<ImageButton> configurationMenuButtons = new ArrayList<>();
        configurationMenuButtons.add(quiestionMarkSquareButton);
        configurationMenuButtons.add(audioSquareButton);
        configurationMenuButtons.add(settingsBackButton);
        menuMap.put(Menu.CONFIGURATION_MENU, new GameMenu("Configuration Menu", configurationMenuButtons));


        this.fieldFrame = new FieldFrame(Integer.toString(model.getApplicationState().getGameState().getScore().get(Team.LOCAL_TEAM)),
                                        Integer.toString(model.getApplicationState().getGameState().getScore().get(Team.OTHER_TEAM)), 
                                        Integer.toString(model.getApplicationState().getGameState().getTimeLeft()), 
                                        model.getApplicationState().getGameState().getField(), 
                                        model.getApplicationState().getGameState().getEntities());

        if (model.getApplicationState().getCurrentMenu() != null){
            this.gameMenu = menuMap.get(model.getApplicationState().getCurrentMenu());
            this.displayFrame = this.gameMenu;
        }
        else {
            this.displayFrame = fieldFrame;
        }
    }

    public void updateView(GameModel modelv){
        fieldFrame.setLocalScore(modelv.getApplicationState().getGameState().getScore().get(Team.LOCAL_TEAM));
        fieldFrame.setOtherScore(modelv.getApplicationState().getGameState().getScore().get(Team.OTHER_TEAM));
        fieldFrame.setTimeLeft(modelv.getApplicationState().getGameState().getTimeLeft());
        if (modelv.getApplicationState().getCurrentMenu() != null){
            if (menuMap.get(modelv.getApplicationState().getCurrentMenu()) != this.gameMenu){
                this.displayFrame.dispose();
                this.gameMenu = menuMap.get(modelv.getApplicationState().getCurrentMenu());
                this.displayFrame = this.gameMenu;
                displayFrame.setVisible(true);
            }
            
            this.displayFrame = this.gameMenu;
        }
        else {
            this.displayFrame.dispose();
            this.displayFrame = fieldFrame;
            displayFrame.setVisible(true);
        }
    }

    public void setDisplayFrame(JFrame displayFrame) {
        this.displayFrame = displayFrame;
    }

    public ImageButton getAudioSquareButton() {
        return audioSquareButton;
    }

    public ImageButton getQuiestionMarkSquareButton() {
        return quiestionMarkSquareButton;
    }

    public ImageButton getPauseBackButton() {
        return pauseBackButton;
    }

    public ImageButton getSettingsBackButton() {
        return settingsBackButton;
    }

    public ImageButton getMainExitButton() {
        return mainExitButton;
    }

    public ImageButton getPauseExitButton() {
        return pauseExitButton;
    }

    public ImageButton getNewgameButton() {
        return newgameButton;
    }

    public ImageButton getPlayButton() {
        return playButton;
    }

    public ImageButton getMainSettingsButton() {
        return mainSettingsButton;
    }

    public ImageButton getPauseSettingsButton() {
        return pauseSettingsButton;
    }

    public ImageButton getQuitButton() {
        return quitButton;
    }

    public JFrame getDisplayFrame() {
        return displayFrame;
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public FieldFrame getFieldFrame() {
        return fieldFrame;
    }
}
