package src;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import src.model.SpriteID;
import src.view.GameMenu;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameMenu frame = new GameMenu();
            frame.setVisible(true);
        });

    }
}
