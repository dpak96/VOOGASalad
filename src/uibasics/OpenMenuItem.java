//This entire file is a part of my masterpiece
//Alex Rice
package uibasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class OpenMenuItem extends AbstractMenuItem {

	public OpenMenuItem(ResourceBundle resource, Stage stage) {
		super(resource, stage);
		this.setText(myResource.getString("OPEN"));
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));

	}

	@Override
	public void handle() {
		myFileChooser.setTitle(myResource.getString("OPEN"));
		File file = myFileChooser.showOpenDialog(myStage);

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
}
