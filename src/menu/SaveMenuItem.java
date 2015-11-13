//This entire file is a part of my masterpiece
//Alex Rice
package menu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class SaveMenuItem extends AbstractMenuItem {
	
	public SaveMenuItem(ResourceBundle resource, Stage stage){
		super(resource, stage);
		this.setText(myResource.getString("SAVE"));
	    this.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));

	}
	@Override
	public void handle() {
		try {
	        saveGame();
	      } catch (Exception e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	      }
	}
	public void saveGame() throws IOException{
		myFileChooser.setTitle(myResource.getString("SAVE"));
	    File game = myFileChooser.showSaveDialog(myStage);
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
}
