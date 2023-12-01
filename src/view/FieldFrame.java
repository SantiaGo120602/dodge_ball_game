package src.view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import src.model.FieldEntity;
import src.model.GameEntity;

public class FieldFrame extends JFrame {
    private JLabel localScore;
    private JLabel otherScore;
    private JLabel timeLeft;
    private FieldEntity fieldEntity;
    private ArrayList<GameEntity> entities;  

    public FieldFrame(String localScore, String otherScore, String timeLeft, FieldEntity fieldEntity, ArrayList<GameEntity> entities){
        setTitle("field frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 980);
        //setLayout(null);

        JLabel scoreLabel = new JLabel("Score:");
        scoreLabel.setBounds(2, 2, 100, 50);
        add(scoreLabel);

        this.localScore = new JLabel(localScore);
        this.localScore.setBounds(52, 2, 100, 50);
        add(this.localScore);

        JLabel sepatador = new JLabel("//");
        sepatador.setBounds(76, 2, 100, 50);
        add(sepatador);

        this.otherScore = new JLabel(otherScore);
        this.otherScore.setBounds(90, 2, 100, 50);
        add(this.otherScore);

        JLabel tiempoLabel = new JLabel("Tiempo restante:");
        tiempoLabel.setBounds(140, 2, 150, 50);
        add(tiempoLabel);

        this.timeLeft = new JLabel(timeLeft);
        this.timeLeft.setBounds(282, 2, 100, 50);
        add(this.timeLeft);

        this.entities = entities;
        for (GameEntity entity : entities) {
            add(entity);
        }

        this.fieldEntity = fieldEntity;
        add(fieldEntity);
    }

    public JLabel getLocalScore() {
        return localScore;
    }
    public void setLocalScore(JLabel localScore) {
        this.localScore = localScore;
    }
    public JLabel getOtherScore() {
        return otherScore;
    }
    public void setOtherScore(JLabel otherScore) {
        this.otherScore = otherScore;
    }
    public JLabel getTimeLeft() {
        return timeLeft;
    }
    public void setTimeLeft(JLabel timeLeft) {
        this.timeLeft = timeLeft;
    }
    public FieldEntity getFieldEntity() {
        return fieldEntity;
    }
    public void setFieldEntity(FieldEntity fieldEntity) {
        this.fieldEntity = fieldEntity;
    }
    public ArrayList<GameEntity> getEntities() {
        return entities;
    }
    public void setEntities(ArrayList<GameEntity> entities) {
        this.entities = entities;
    }
    

}
