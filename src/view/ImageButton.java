package src.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageButton extends JButton {

    public ImageButton(String imagePath, int width, int height) {
        try {
            System.out.println(imagePath);
            BufferedImage image = ImageIO.read(getClass().getResource(imagePath));
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledImage));
            setBorderPainted(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setOpaque(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

