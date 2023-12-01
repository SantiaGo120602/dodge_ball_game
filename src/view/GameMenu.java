package src.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameMenu extends JFrame {

    private ArrayList<ImageButton> buttons;

    public GameMenu(String name, ArrayList<ImageButton> buttons) {
        this.buttons = buttons;
        setTitle(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 980);

        BackgroundImagePanel backgroundImagePanel = new BackgroundImagePanel("src/resources/ui_components/background.jpg");
        
        backgroundImagePanel.setBackground(new Color(0, 0, 0, 0));

        for (ImageButton button : buttons){
            backgroundImagePanel.add(button);
        }

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

    public ArrayList<ImageButton> getButtons() {
        return buttons;
    }
}
