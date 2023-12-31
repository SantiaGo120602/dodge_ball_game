package src.controller;

import java.util.ArrayList;
import java.util.Arrays;
import src.model.Ball;
import src.model.GameEntity;
import src.model.GameModel;
import src.model.Player;
import src.model.Team;
import src.view.GameView;

public class UDPController extends GameController {

    private AbstractUDPSocket socket;
    
    public UDPController(GameModel model, GameView view, AbstractUDPSocket socket) {
        super(model, view);
        this.socket = socket;
    }

    @Override
    public void updateView() {
        this.getView().updateView(this.getModel());;
    }

    public void updateModel(){

    }
    public void startRecieving(){
        String recivedData = socket.recieveData();
                ArrayList<String> restoredList = new ArrayList<>(Arrays.asList(recivedData.split(",")));
                System.out.println(recivedData);
                for (int i = 0; i < 4; i++){
                    for (GameEntity entity: this.getModel().getApplicationState().getGameState().getEntities()){
                        if (entity instanceof Player){
                        Player p = (Player) entity;
                        if (p.getTeam() == Team.OTHER_TEAM){
                            if ( ((i * 3) <= restoredList.size()) && p.getPlayerID() == Integer.parseInt(restoredList.get(i*3))){
                                System.out.println(Integer.parseInt(restoredList.get(i*3)));
                                p.setxSpeed(Integer.parseInt(restoredList.get((i*4) + 1)));
                                p.setySpeed(Integer.parseInt(restoredList.get((i*4) + 2)));
                            }
                        }

                    } else if (entity instanceof Ball){
                        Ball b = (Ball) entity;
                        if (b.getTeam() == Team.OTHER_TEAM){
                            if ( ((i * 3) <= restoredList.size()) && b.getPlayerID() == Integer.parseInt(restoredList.get(i*3))){
                                b.setxSpeed(Integer.parseInt(restoredList.get((i*4) + 1)));
                                b.setySpeed(Integer.parseInt(restoredList.get((i*4) + 2)));
                            }
                        }
                    }
                    }
                }
                updateView();
    }

    public void startCommunication(){
        while (true){
            System.out.println("hola");
            if (this.getModel().getApplicationState().getCurrentMenu() == null){
                ArrayList<String> originalList = new ArrayList<>();

                for (GameEntity entity: this.getModel().getApplicationState().getGameState().getEntities()){
                    if (entity instanceof Player){
                        Player p = (Player) entity;
                        if (p.getTeam() == Team.LOCAL_TEAM){
                            originalList.add(String.valueOf(p.getPlayerID() + 4));
                            originalList.add(String.valueOf(p.getxSpeed()));
                            originalList.add(String.valueOf(p.getySpeed()));
                        }

                    } else if (entity instanceof Ball){
                        Ball b = (Ball) entity;
                        if (b.getTeam() == Team.LOCAL_TEAM){
                            originalList.add(String.valueOf(b.getPlayerID() + 10));
                            originalList.add(String.valueOf(b.getxSpeed()));
                            originalList.add(String.valueOf(b.getySpeed()));
                        }
                    }
                }

                String singleString = String.join(",", originalList);
                System.out.println(singleString);
                socket.sendData(singleString);

                
            }
        }
    }
    
}
