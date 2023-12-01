package src.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LabelMovementTask implements Runnable {
    private final List<GameEntity> GameEntitys;

    public LabelMovementTask(List<GameEntity> GameEntitys) {
        this.GameEntitys = GameEntitys;
    }

    @Override
    public void run() {
        // Create a Timer for periodic label updates
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update position for each label
                for (GameEntity GameEntity : GameEntitys) {
                    GameEntity.move();

                }
            }
        });

        timer.start();
    }
}