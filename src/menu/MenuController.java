package menu;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.GraphicHandler;
import resourcemanager.ResourceManager;
import startscreen.StartScreenController;

import java.io.*;
import java.util.ResourceBundle;

public class MenuController {
    private GraphicHandler myGraphicHandler;
    private MenuPanel myMenuPanel;


    public MenuController(GraphicHandler graphicHandler){
        myGraphicHandler = graphicHandler;
        myMenuPanel = new MenuPanel(this);
    }

    public void newStart(){
        myGraphicHandler.startScreen();
    }

    public void something(ResourceBundle resourceBundle, FileChooser myFileChooser){ //what does this do?
        myFileChooser.setTitle(resourceBundle.getString("OPEN"));
        File file = myFileChooser.showOpenDialog(myMenuPanel.getScene().getWindow());
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
            try {
                saveGame(fileChooser, saveName);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
    }

    public void saveGame(FileChooser fileChooser, String saveName) throws IOException {
        fileChooser.setTitle(saveName);
        File game = fileChooser.showSaveDialog(myMenuPanel.getScene().getWindow());
        if (!game.exists()) {
            game.createNewFile();
        }
        try {
            FileOutputStream f = new FileOutputStream(game);
            ObjectOutputStream o = new ObjectOutputStream(f);
//	      o.writeObject(myController.getMyScene().getAllData().get(0));
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MenuPanel getMenu(){
        return myMenuPanel;
    }


}
