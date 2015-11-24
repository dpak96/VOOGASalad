package main;
/**
 * Created by Rob on 11/14/15.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import model.AddCollisionType;

public class Main extends Application {
    private SuperController squirtle;
  
    public static void main(String[] args) {
    	AddCollisionType a = new AddCollisionType("lmao");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GraphicHandler graphics = new GraphicHandler();
        graphics.init(primaryStage);
    }
}