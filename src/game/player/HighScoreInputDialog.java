package game.player;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import startscreen.GameCreation;

public class HighScoreInputDialog extends Dialog {
	
	private GridPane myLayout;
	private ButtonType myOKer;

	public HighScoreInputDialog(String gameName, double score){
		super();
		myLayout = new GridPane();
		this.setTitle("Input High Score!");
		Label addName = new Label("Input Player Name: ");
		TextField inputName = new TextField();
		myLayout.add(addName,1,1);
		myLayout.add(inputName, 2, 1);
		this.getDialogPane().setContent(myLayout);
		myOKer = new ButtonType("OK",ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(myOKer);
		this.setResultConverter(new Callback<ButtonType,HighScoresXMLWriter>(){
			public HighScoresXMLWriter call(ButtonType ok){
				if(ok == myOKer){
					Double score3 = score;
					Integer score2 = score3.intValue();
					HighScoresXMLWriter scoresFile;
					try {
						scoresFile = new HighScoresXMLWriter(gameName, score2.toString(), inputName.getText());
						return scoresFile;
					} catch (ParserConfigurationException | SAXException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				return new HighScoresXMLWriter();
	}
		});
		
	}
}
