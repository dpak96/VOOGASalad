package main;

import javafx.scene.Scene;
import javafx.stage.Stage;
import startscreen.GameCreation;
import startscreen.StartScreen;
import startscreen.StartScreenController;

public class GraphicHandler {
    private Scene baseScene;
    private StartScreenController start;
    private SuperController superController;
    private Stage currentStage;

    public GraphicHandler(){
        start = new StartScreenController();
        superController = new SuperController(this);
    }

    public void init(Stage s){
        currentStage = s;
        startScreen();
    }


    public void startScreen(){
        start = new StartScreenController();
        baseScene = new Scene(start.getStart(), 400,400);
        baseScene.getStylesheets().add("startscreen/StartScreen.css");
        currentStage.setTitle("Test");
        currentStage.setScene(baseScene);
        start.init(currentStage, this);
        currentStage.show();
    }


    public void startUp(GameCreation gameCreation){
        currentStage.setScene(superController.init(gameCreation));
    }
    
    public void startUpNew(GameCreation gameCreation){
    	currentStage.setScene(superController.initNew(gameCreation));
    }
    
}
