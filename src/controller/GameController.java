package src.controller;

import src.model.GameModel;
import src.view.GameView;

public abstract class GameController {
    private GameModel model;
    private GameView view;

    public abstract updateView();
}
