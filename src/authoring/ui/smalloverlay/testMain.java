package authoring.ui.smalloverlay;
/**
 * Created by Rob on 11/14/15.
 */

import authoring.ui.smalloverlay.OverlayController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        OverlayControllerEx oc = new OverlayControllerEx();
        oc.init();
        Scene baseScene = new Scene(oc.getModule(), 400,400);
        baseScene.getStylesheets().add("authoring/ui/smalloverlay/Overlay.css");
        primaryStage.setTitle("Test");
        primaryStage.setScene(baseScene);
        primaryStage.show();
    }
}