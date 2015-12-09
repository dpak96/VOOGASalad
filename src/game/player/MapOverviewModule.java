package game.player;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import action.controller.ActionController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.article.Article;

public class MapOverviewModule extends HUDModule {
	
	private Canvas myMap;
	private GraphicsContext myGC;
	private Text myText;
	
	public MapOverviewModule(){
		super();
		myText = new Text("Overview");
	}

	@Override
	public void init(double offset) throws IOException, ParserConfigurationException, SAXException {
		this.setStyle("-fx-background-color: rgba(0,0,255,0.5)");
		myMap = new Canvas(offset*3.0/4.0, offset*3.0/5.0);
		myGC = myMap.getGraphicsContext2D();
		myMap.setVisible(true);
		this.getChildren().addAll(myText,myMap);
		
	}

	@Override
	public void update(List<Article> arg,Article character, ActionController ac) {
		myGC.setFill(Color.rgb(0, 255,0,0.5));
		myGC.clearRect(myMap.getLayoutX(), myMap.getLayoutY(), myMap.getWidth(), myMap.getHeight());
		myGC.fillRect(5, character.getY()*myMap.getHeight()/this.getScene().getHeight(), 4, 4);
		myGC.setFill(Color.rgb(255, 255,0,0.5));
		for(Article i: arg){
			myGC.fillRect((i.getX()*myMap.getWidth()/this.getScene().getWidth()-character.getX()*myMap.getWidth()/this.getScene().getWidth()+5)/2, (i.getY()*myMap.getHeight()/this.getScene().getHeight()-character.getY()*myMap.getHeight()/this.getScene().getHeight()), 4, 4);
		}
	}

}
