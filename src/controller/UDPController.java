package src.controller;

import src.model.GameModel;
import src.view.GameView;

public class UDPController extends GameController {

    private AbstractUDPSocket socket;
    
    public UDPController(GameModel model, GameView view) {
        super(model, view);
    }

    @Override
    public void updateView() {
        throw new UnsupportedOperationException("Unimplemented method 'updateView'");
    }

    public void updateModel(){

    }
    
}