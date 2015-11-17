package main;
/**
 * Created by Rob on 11/14/15.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GraphicHandler graphics = new GraphicHandler();
        graphics.init(primaryStage);
    }
}