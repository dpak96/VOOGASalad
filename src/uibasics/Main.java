package uibasics;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ResourceBundle resource = ResourceBundle.getBundle("properties/english");
		//Setup setup = new Setup(primaryStage, resource);
		//primaryStage.setScene(setup.getScene());
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
