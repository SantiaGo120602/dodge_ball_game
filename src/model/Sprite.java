package src.model;

import javax.swing.ImageIcon;

public class Sprite {
    private ImageIcon icon;
    
    public Sprite(ImageIcon icon) {
        this.icon = icon;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
