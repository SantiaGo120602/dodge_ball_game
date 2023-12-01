package src.model;

import java.util.HashMap;

import javax.swing.ImageIcon;

public class SpriteFactory {

    private static HashMap<SpriteID, Sprite> spriteMap;

    static {
        for (SpriteID spriteID : SpriteID.values()){
            spriteMap.put(spriteID, new Sprite(new ImageIcon("src/resources/sprites/" + spriteID.name().toLowerCase() + ".gif")));
        }
    }

    
}
