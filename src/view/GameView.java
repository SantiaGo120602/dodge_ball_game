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
    private ImageButton backButton = new ImageButton("src/resources/ui_components/BackButton.png", 200, 100);
    private ImageButton exitButton = new ImageButton("src/resources/ui_components/ExitButton.png", 200, 100);
    private ImageButton newgameButton = new ImageButton("src/resources/ui_components/NewgameButton.png", 200, 100);
    private ImageButton playButton = new ImageButton("src/resources/ui_components/PlayButton.png", 200, 100);
    private ImageButton settingsButton = new ImageButton("src/resources/ui_components/SettingsButton.png", 200, 100);
    private ImageButton quitButton = new ImageButton("src/resources/ui_components/QuitButton.png", 200, 100);
    
    private JFrame displayFrame;
    private GameMenu gameMenu;
    private FieldFrame fieldFrame;

    public GameView(GameModel model){
        ArrayList<ImageButton> mainMenuButtons = new ArrayList<>();
        mainMenuButtons.add(playButton);
        mainMenuButtons.add(newgameButton);
        mainMenuButtons.add(settingsButton);
        mainMenuButtons.add(exitButton);
        menuMap.put(Menu.MAIN_MENU, new GameMenu("Main Menu", mainMenuButtons));


        ArrayList<ImageButton> pauseMenuButtons = new ArrayList<>();
        pauseMenuButtons.add(backButton);
        pauseMenuButtons.add(settingsButton);
        pauseMenuButtons.add(quitButton);
        pauseMenuButtons.add(exitButton);
        menuMap.put(Menu.PAUSE_MENU, new GameMenu("Pause Menu", pauseMenuButtons));


        ArrayList<ImageButton> configurationMenuButtons = new ArrayList<>();
        configurationMenuButtons.add(quiestionMarkSquareButton);
        configurationMenuButtons.add(audioSquareButton);
        configurationMenuButtons.add(backButton);
        menuMap.put(Menu.CONFIGURATION_MENU, new GameMenu("Configuration Menu", configurationMenuButtons));

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hola");
                displayFrame = fieldFrame;
            }
        });


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

    public ImageButton getAudioSquareButton() {
        return audioSquareButton;
    }

    public ImageButton getQuiestionMarkSquareButton() {
        return quiestionMarkSquareButton;
    }

    public ImageButton getBackButton() {
        return backButton;
    }

    public ImageButton getExitButton() {
        return exitButton;
    }

    public ImageButton getNewgameButton() {
        return newgameButton;
    }

    public ImageButton getPlayButton() {
        return playButton;
    }

    public ImageButton getSettingsButton() {
        return settingsButton;
    }

    public ImageButton getQuitButton() {
        return quitButton;
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }
    public void setGameMenu(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }
    public FieldFrame getFieldFrame() {
        return fieldFrame;
    }
    public void setFieldFrame(FieldFrame fieldFrame) {
        this.fieldFrame = fieldFrame;
    }

    public JFrame getDisplayFrame() {
        return displayFrame;
    }

    public void setDisplayFrame(JFrame displayFrame) {
        this.displayFrame = displayFrame;
    }
}
