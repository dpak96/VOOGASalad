package menu;

import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import level.manager.XMLOrderer;
import main.GraphicHandler;
import model.Model;
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
    	game = gameCreation;
    	File gamesDir = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "SquirtleSquadGames");
    	if(!gamesDir.exists()){
    		gamesDir.mkdir();
    	}
    	FileChooser myFileChooser = new FileChooser();
    	myFileChooser.setTitle("New Game Folder");
    	myFileChooser.setInitialDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "SquirtleSquadGames" ));
        File dir = myFileChooser.showSaveDialog(myMainMenu.getScene().getWindow());
        try {
        	dir.mkdir();
        	game.setFolderPath(dir.getPath());
        	XMLOrderer levelOrder = new XMLOrderer();
        	levelOrder.makeXML(dir.getName());
        	game.setGame(dir.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveLevelCreation(GameCreation gameCreation){
    	game = gameCreation;
    	System.out.println("Alex is a homosexual " + gameCreation.getGameName());
    	System.out.println("Alex likes penis deep inside his asshole: " + gameCreation.getGameName() + " " + gameCreation.getFolderPath());
    	File levelDir = new File(gameCreation.getFolderPath());
    	FileChooser myFileChooser = new FileChooser();
    	myFileChooser.setTitle("New Level File");
		FileChooser.ExtensionFilter extensionFilter =
				new FileChooser.ExtensionFilter("Java files (*.xml)", "*.xml");
		myFileChooser.getExtensionFilters().add(extensionFilter);
    	myFileChooser.setInitialDirectory(levelDir);
        File dir = myFileChooser.showSaveDialog(myMainMenu.getScene().getWindow());
        try {
//        	dir.mkdir();
//        	game.setFolderPath(dir.getPath());
        	XMLOrderer levelOrder = new XMLOrderer(levelDir.getPath(),dir.getName());
        	levelOrder.makeXML(gameCreation.getName());
//        	game.setGame(game.getName());
        	myModelController.setModel(new Model());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveGame(){
        game = myGraphicHandler.getGameCreation();
        myModelController.save(myMainMenu.getScene().getWindow(), game.getName());
            
    }
    
    public void reorderGame(){
        game = myGraphicHandler.getGameCreation();
        XMLOrderer reorder = new XMLOrderer(game);
        reorder.makeXML(game.getName());
    }

    public void loadGame(){
//    	System.out.println("myMainMenu.getScene()");
//    	System.out.println(myMainMenu.getScene() == null);
//    	System.out.println("myMainMenu.getScene().getWindow()");
//    	System.out.println(myMainMenu.getScene().getWindow() == null);
        myModelController.load(myMainMenu.getScene().getWindow());
    }
    
    public void loadGame(GameCreation gameCreation, String file){
    	myModelController.load(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "SquirtleSquadGames" + System.getProperty("file.separator") + gameCreation.getGameName() + System.getProperty("file.separator") + file));
    }



    public MainMenu getMenu(){
        return myMainMenu;
    }


}
