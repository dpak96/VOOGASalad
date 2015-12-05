package menu;

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

    public void something(ResourceBundle resourceBundle, FileChooser myFileChooser){ //what does this do?
        myFileChooser.setTitle(resourceBundle.getString("OPEN"));
        File file = myFileChooser.showOpenDialog(myMainMenu.getScene().getWindow());
        try {
            if (file != null) {
                FileInputStream f = new FileInputStream(file);
                ObjectInputStream o = new ObjectInputStream(f);
//				Data newDat = (Data) o.readObject();
                o.close();
//				newDat.recreate();
//				myController.getGuiManager().getTurtScene();
//				myController.getGuiManager().getMyHistory().clear();
//				myController.getMyScene().setData(0, newDat);
//				for (String i : newDat.getUserHistory()) {
//					myController.getGuiManager().getMyHistory().addCommand(i);
//				}
//				for (String j : newDat.getUserCommandMap().keySet()) {
//					myController.getGuiManager().getMyUserCommands().addCommand(j);
//				}
//				for (String k : newDat.getVariableMap().keySet()) {
//					myController.getGuiManager().getMyUserCommands().addCommand(k);
//				}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void trySave(FileChooser fileChooser, String saveName) {
           /* try {
                saveGame(fileChooser, saveName);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }*/
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
