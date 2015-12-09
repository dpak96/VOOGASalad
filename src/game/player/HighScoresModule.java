package game.player;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import action.controller.ActionController;
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
	private HighScoreInputDialog myInputScore;
	private String myGameName;
	private int myPreviousLives; 
	
	public HighScoresModule(String gameName){
		super();
		myPreviousLives = 0;
		myButton = new Button();
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
		myButton.setOnAction(e-> new HighScoresDialog(myGameName).init());
		this.getChildren().add(myButton);
		
	}

	@Override
	public void update(List<Article> arg,Article character, ActionController ac) {
		if(character.getLife()==0 && myPreviousLives != 0){
			myInputScore = new HighScoreInputDialog(myGameName,character.getScore());
			ac.change_rate(0);
			Optional<HighScoresXMLWriter> xml = myInputScore.showAndWait();
			if(xml.isPresent()){
				HighScoresXMLWriter xml2 = xml.get();
				xml2.makeXML();
			}
		}
		myPreviousLives = character.getLife();
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
