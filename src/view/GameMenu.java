package src.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameMenu extends JFrame {

    public GameMenu() {
        setTitle("ImageButton Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 980);

        // Create buttons with PNGs
        ImageButton button1 = new ImageButton("src/resources/ui_components/PlayButton.png", 100, 50);
        ImageButton button2 = new ImageButton("src/resources/ui_components/NewgameButton.png", 100, 50);
        ImageButton button3 = new ImageButton("src/resources/ui_components/SettingsButton.png", 100, 50);
        ImageButton button4 = new ImageButton("src/resources/ui_components/ExitButton.png", 100, 50);


        // JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // panel.setLayout(new FlowLayout());
        // panel.add(button1);
        // panel.add(button2);
        // panel.add(button3);
        // panel.add(button4);

        // add(panel, BorderLayout.CENTER);
        setContentPane(new JLabel(new ImageIcon("src/resources/ui_components/background.jpg")));
        setLayout(new BorderLayout());
    }

}
