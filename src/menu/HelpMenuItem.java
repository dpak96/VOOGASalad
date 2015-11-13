package menu;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;


public class HelpMenuItem extends AbstractMenuItem {
	
	public HelpMenuItem(ResourceBundle resource, Stage stage){
		super(resource, stage);
		this.setText(myResource.getString("HELP"));
	    this.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));

	}
	@Override
	public void handle() {
	    File html = new File("HelpPage.html");
	    try {
	      Desktop.getDesktop().browse(html.toURI());
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}

}
