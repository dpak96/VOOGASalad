package game.player;

import java.io.IOException;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.article.Article;
import resourcemanager.ResourceManager;

public class HighScoresModule extends HUDModule {
	
	private Button myButton;
	private HighScoresDialog myHighScores;
	private HighScoreInputDialog myInputScore;
	private String myGameName;
	
	public HighScoresModule(String gameName){
		super();
		myButton = new Button();
		myHighScores = new HighScoresDialog(gameName);
		myGameName = gameName;
	}
	
	@Override
	public void init(double offset) throws IOException, ParserConfigurationException, SAXException {
		Image img = (Image) ResourceManager.getResourceManager().getResource("ImageManager", "highScoreButton");
		ImageView buttonImg = new ImageView(img);
		buttonImg.setFitWidth(offset/2);
		buttonImg.setFitHeight(offset/5);
		myButton.setPadding(new Insets(0,0,0,0));
		myButton.setGraphic(buttonImg);
		myButton.setOnAction(e-> myHighScores.init());
		this.getChildren().add(myButton);
		
	}

	@Override
	public void update(Article character) {
		if(character.getLife()==0){
			myInputScore = new HighScoreInputDialog(myGameName,character.getScore());
			Optional<HighScoresXMLWriter> xml = myInputScore.showAndWait();
			if(xml.isPresent()){
				HighScoresXMLWriter xml2 = xml.get();
				xml2.makeXML();
			}
		}
	}
	public void tester() {
		//if(character.getLife()==0){
			myInputScore = new HighScoreInputDialog(myGameName,250);
			Optional<HighScoresXMLWriter> xml = myInputScore.showAndWait();
			if(xml.isPresent()){
				HighScoresXMLWriter xml2 = xml.get();
				xml2.makeXML();
			//}
		}
	}
	
}
