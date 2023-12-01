package src.controller;

import src.model.GameModel;
import src.view.GameView;

public abstract class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view){
        this.model = model;
        this.view = view;
    }

    public abstract void updateView();

    public GameModel getModel() {
        return model;
    }

    public GameView getView() {
        return view;
    }

    
}
