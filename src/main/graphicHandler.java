package main;

import javafx.scene.Scene;
import javafx.stage.Stage;
import startscreen.StartScreen;
import startscreen.StartScreenController;

public class GraphicHandler {
    private Scene baseScene;
    private StartScreenController start;
    private SuperController superC;

    public GraphicHandler(){
        start = new StartScreenController();
    }

    public void init(Stage s){
        baseScene = new Scene(start.getStart());
        s.setTitle("Test");
        s.setScene(baseScene);
        start.init();
        s.show();
    }






}
