package startscreen;

import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class NewGameDialog extends Dialog {
	
	protected GridPane myGridPane;
	protected ButtonType myOKer;
	protected TextField myGameName;
	
	public NewGameDialog(){
		this.setTitle("New Game");
		this.setResizable(true);
		myGameName = new TextField();
		Label gameName = new Label("Game Name: ");
		myGridPane = new GridPane();
		myGridPane.add(gameName, 1, 1);
		myGridPane.add(myGameName, 2, 1);
		myOKer = new ButtonType("OK",ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(myOKer);
		this.getDialogPane().setContent(myGridPane);
		this.setResultConverter(new Callback<ButtonType,String>(){
			public String call(ButtonType ok){
				if(ok == myOKer){
					return (String) myGameName.getText();
				}
				return "";
	}
		});
		}
}
