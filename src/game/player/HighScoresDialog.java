package game.player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class HighScoresDialog extends Dialog {
	
	private GridPane myScores;
	private String myGameName;
	private ScrollPane myScrollPane;
	private ButtonType myOKer;
	private HighScoresXMLReader myRead;
	
	public HighScoresDialog(String name){
		super();
		myScores = new GridPane();
		myScores.setVgap(5);
		myScores.setHgap(5);
		myScrollPane = new ScrollPane();
		myScrollPane.setMaxSize(100, 150);
		myScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		myScores.add(new Text("Rank"), 1,1);
		myScores.add(new Text("Player"), 2,1);
		myScores.add(new Text("Score"), 3,1);
		myScrollPane.setContent(myScores);
		myOKer = new ButtonType("OK",ButtonData.OK_DONE);
		myGameName = name;
		try {
			myRead = new HighScoresXMLReader(myGameName);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getDialogPane().getButtonTypes().add(myOKer);
		this.getDialogPane().setContent(myScrollPane);
	}
	
	public void init() {
		Map<Integer,String> scores = myRead.getScoreMap();
		ArrayList<Integer> ordered = new ArrayList<Integer>(scores.keySet());
		Collections.sort(ordered);
		Collections.reverse(ordered);
		for(int i = 0; i<ordered.size(); i++){
			Integer rank = i+1;
			myScores.add(new Text(rank.toString()), 1,i+2);
			Integer score = ordered.get(i);
			myScores.add(new Text(score.toString()), 3, i+2);
			myScores.add(new Text(scores.get(ordered.get(i))), 2,i+2);
		}		
		this.showAndWait();
	}
}
