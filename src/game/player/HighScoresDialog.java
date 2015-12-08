package game.player;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class HighScoresDialog extends Dialog {
	
	private GridPane myScores;
	private String myGameName;
	
	public HighScoresDialog(){
		super();
		myScores = new GridPane();
		this.getDialogPane().setContent(myScores);
	}
	
	public void init(String name) throws SAXException, IOException, ParserConfigurationException{
		myGameName = name;
		HighScoresXMLReader read = new HighScoresXMLReader(myGameName);
		Map<Integer,String> scores = read.getScoreMap();
		//myScores.add
        //score.set
		
		
		
	}
}
