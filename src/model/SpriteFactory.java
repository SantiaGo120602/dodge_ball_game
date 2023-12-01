package src.model;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class SpriteFactory {

    private static HashMap<SpriteID, Sprite> spriteMap = new HashMap<>();

    static {
        for (SpriteID spriteID : SpriteID.values()){
            ImageIcon originalIcon = new ImageIcon("src/resources/sprites/" + spriteID.name().toLowerCase() + ".gif");

            int width = 70;
            int height = 90;
            if ((spriteID == SpriteID.BALL_MOVING) || (spriteID == SpriteID.BALL_STATIC)){
                width = 30;
                height = 30;
            } else if (spriteID == SpriteID.FIELD){
                width = 1920;
                height = 980;
            }

            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(scaledImage);

            spriteMap.put(spriteID, new Sprite(icon));
        }
    }

    public static Sprite getSprite(SpriteID id){
        return spriteMap.get(id);
    }
    
}
