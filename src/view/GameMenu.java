package src.view;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JFrame {

    public GameMenu() {
        setTitle("ImageButton Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 980);

        BackgroundImagePanel backgroundImagePanel = new BackgroundImagePanel("src/resources/ui_components/background.jpg");

        ImageButton button1 = new ImageButton("src/resources/ui_components/PlayButton.png", 200, 100);
        ImageButton button2 = new ImageButton("src/resources/ui_components/NewgameButton.png", 200, 100);
        ImageButton button3 = new ImageButton("src/resources/ui_components/SettingsButton.png", 200, 100);
        ImageButton button4 = new ImageButton("src/resources/ui_components/ExitButton.png", 200, 100);

        backgroundImagePanel.setBackground(new Color(0, 0, 0, 0));
        backgroundImagePanel.add(button1);
        backgroundImagePanel.add(button2);
        backgroundImagePanel.add(button3);
        backgroundImagePanel.add(button4);

        add(backgroundImagePanel);
    }
    private static class BackgroundImagePanel extends JPanel {
        private Image backgroundImage;

        public BackgroundImagePanel(String fileName) {
            this.backgroundImage = new ImageIcon(fileName).getImage();
            setLayout(new GridLayout(0, 1, 0, 0));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
