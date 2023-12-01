package src.model;

public class GameModel {
    private ApplicationState applicationState;

    public GameModel(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    public ApplicationState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }
    
}
