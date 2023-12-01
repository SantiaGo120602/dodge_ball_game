package src.view;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JFrame {

    public GameMenu() {
        setTitle("ImageButton Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);

        // Create buttons with PNGs
        ImageButton button1 = new ImageButton("/home/santiago/Documents/patrones1/dodge_ball_game/src/resources/ui_components/PlayButton.png", 100, 50);
        ImageButton button2 = new ImageButton("/home/santiago/Documents/patrones1/dodge_ball_game/src/resources/ui_components/NewgameButton.png", 100, 50);
        ImageButton button3 = new ImageButton("/home/santiago/Documents/patrones1/dodge_ball_game/src/resources/ui_components/SettingsButton.png", 100, 50);
        ImageButton button4 = new ImageButton("/home/santiago/Documents/patrones1/dodge_ball_game/src/resources/ui_components/ExitButton.png", 100, 50);


        // Add buttons to a panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        // Set the content pane with a background image
        setContentPane(new JLabel(new ImageIcon("/home/santiago/Documents/patrones1/dodge_ball_game/src/resources/ui_components/background.png")));
        setLayout(new BorderLayout());
        add(panel, BorderLayout.SOUTH);
    }


}
