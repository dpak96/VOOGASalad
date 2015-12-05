package menu;

import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.GraphicHandler;
import model.controller.ModelController;
import resourcemanager.ResourceManager;
import startscreen.GameCreation;
import startscreen.StartScreenController;
import uibasics.UIStackPane;

import java.io.*;
import java.util.ResourceBundle;

public class MenuController {
    private GraphicHandler myGraphicHandler;
    private MainMenu myMainMenu;
    private ModelController myModelController;
    private GameCreation game;


    public MenuController(GraphicHandler graphicHandler, ModelController modelController){
        myGraphicHandler = graphicHandler;
        myMainMenu = new MainMenu(this);
        myModelController = modelController;
    }
    
    public void switchOverlay() {
    	BorderPane core = (BorderPane) myMainMenu.getParent();
    	UIStackPane stack = (UIStackPane) core.getCenter();
    	stack.toggle();
    }
    	

    public void newStart(){
        myGraphicHandler.startScreen();
    }

    public void saveGameCreation(GameCreation gameCreation){
    	File gamesDir = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "SquirtleSquadGames");
    	if(!gamesDir.exists()){
    		gamesDir.mkdir();
    	}
    	FileChooser myFileChooser = new FileChooser();
    	myFileChooser.setTitle("New Game Folder");
        File dir = myFileChooser.showSaveDialog(myMainMenu.getScene().getWindow());
        try {
        	dir.mkdir();
        	gameCreation.setFolderPath(dir.getPath());
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveGame(){
            myModelController.save(myMainMenu.getScene().getWindow());
    }

    public void loadGame(){
        myModelController.load(myMainMenu.getScene().getWindow());
    }



    public MainMenu getMenu(){
        return myMainMenu;
    }


}
