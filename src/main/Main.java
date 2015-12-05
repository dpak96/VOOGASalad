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
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GraphicHandler graphics = new GraphicHandler();
        graphics.init(primaryStage);
        tester test = new tester();
        test.teste();
        yo hey = new yo();
        hey.hi();
    }
}