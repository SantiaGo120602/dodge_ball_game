package src.model;

public class ApplicationState {
    private static ApplicationState applicationInstance;
    private GameState gameState;
    private Menu currentMenu;

    private ApplicationState(GameState gameState, Menu currentMenu) {
        this.gameState = gameState;
        this.currentMenu = currentMenu;
    }

    public static ApplicationState getInstance(GameState gameState, Menu currentMenu) {
        if (applicationInstance== null) {
            // If the applicationInstanceis not created, create it
            applicationInstance= new ApplicationState(gameState, currentMenu);
        }
        return applicationInstance;
    }

    public static ApplicationState getInstance() {
        if (applicationInstance== null) {
            // If the applicationInstanceis not created, create it
            applicationInstance= new ApplicationState(null, null);
        }
        return applicationInstance;
    }

    public static void setApplicationInstance(ApplicationState applicationInstance) {
        ApplicationState.applicationInstance = applicationInstance;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    

}
