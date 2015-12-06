package main;

import javafx.scene.Scene;
import javafx.stage.Stage;
import level.manager.LevelManager;
import startscreen.GameCreation;
import startscreen.StartScreen;
import startscreen.StartScreenController;

public class GraphicHandler {
    private Scene baseScene;
    private StartScreenController start;
    private SuperController superController;
    private Stage currentStage;
    private LevelManager myLevelManager;
    
    
    public GraphicHandler(){
        superController = new SuperController(this);
        myLevelManager = new LevelManager(superController.getModelController());
        start = new StartScreenController(myLevelManager);
    }

    public void init(Stage s){
        currentStage = s;
        startScreen();
    }


    public void startScreen(){
        start = new StartScreenController(myLevelManager);
        baseScene = new Scene(start.getStart(), 400,400);
        baseScene.getStylesheets().add("startscreen/StartScreen.css");
        currentStage.setTitle("Test");
        currentStage.setScene(baseScene);
        start.init(currentStage, this);
        currentStage.show();
    }


    public void startUp(GameCreation gameCreation, String levelFile){
    	System.out.println("It should be making a new level");
    	System.out.println(levelFile);
    	gameCreation.setLevel(levelFile);
    	System.out.println(gameCreation.getLevel());
//    	myLevelManager.startGame(gameCreation);
        currentStage.setScene(superController.init(gameCreation, gameCreation.getLevel()));
    }
    
    public void updateLevels(GameCreation gameCreation) {
    	myLevelManager.updateLevels(gameCreation);
    }
    
    public void reorderLevels(){
    	superController.reorderLevels();
    }
    
    public void startUpNew(GameCreation gameCreation){
    	currentStage.setScene(superController.initNew(gameCreation));
    }
    
    public void startUpNewLevel(GameCreation gameCreation) {
    	currentStage.setScene(superController.initNewLevel(gameCreation));
    }
    
    public void setScene(Scene scene) {
    	currentStage.setScene(scene);

    }
    
    public GameCreation getGameCreation(){
    	return start.getGameCreation();
    }
}
