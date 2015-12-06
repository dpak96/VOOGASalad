package menu;

import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import level.manager.XMLOrderer;
import main.GraphicHandler;
import model.Model;
import model.controller.ModelController;
import startscreen.GameCreation;
import uibasics.UIStackPane;

import java.io.*;

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

    public boolean saveGameCreation(GameCreation gameCreation){
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
            return false;
        }
        return true;
    }
    
    public void saveLevelCreation(GameCreation gameCreation){
    	game = gameCreation;
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
            
        }
    }

    public void saveGame(){
    	try {
	        game = myGraphicHandler.getGameCreation();
	        myModelController.save(myMainMenu.getScene().getWindow(), game.getName());
    	} catch (Exception e) {
    	}
    }
    
    public void reorderGame(){
        game = myGraphicHandler.getGameCreation();
        XMLOrderer reorder = new XMLOrderer(game);
        reorder.makeXML(game.getName());
    }

    public void loadGame(){
    	try {
//        	System.out.println("myMainMenu.getScene()");
//        	System.out.println(myMainMenu.getScene() == null);
//        	System.out.println("myMainMenu.getScene().getWindow()");
//        	System.out.println(myMainMenu.getScene().getWindow() == null);
            myModelController.load(myMainMenu.getScene().getWindow());
    	} catch (NullPointerException e) {
			//User canceled from a load
    	}

    }
    
    public void loadGame(GameCreation gameCreation, String file){
    	try {
	    	myModelController.load(new File(System.getProperty("user.home") + System.getProperty("file.separator") 
	    	+ "SquirtleSquadGames" + System.getProperty("file.separator") + gameCreation.getGameName() 
	    	+ System.getProperty("file.separator") + file));
    	} catch (NullPointerException e) {
			//User canceled from a load
    	}
    }



    public MainMenu getMenu(){
        return myMainMenu;
    }


}
