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
import model.article.Article;

public class MapOverviewModule extends HUDModule {
	
	private Canvas myMap;
	private GraphicsContext myGC;
	
	public MapOverviewModule(){
		super();
	}

	@Override
	public void init(double offset) throws IOException, ParserConfigurationException, SAXException {
		this.setStyle("-fx-background-color: rgba(0,0,255,0.5)");
		myMap = new Canvas(offset*3.0/4.0, offset*3.0/5.0);
		myGC = myMap.getGraphicsContext2D();
		myGC.setFill(Color.rgb(0, 255,0,0.5));
		myMap.setVisible(true);
		this.getChildren().addAll(myMap);
		
	}

	@Override
	public void update(List<Article> arg,Article character, ActionController ac) {
		myGC.clearRect(myMap.getLayoutX(), myMap.getLayoutY(), myMap.getWidth(), myMap.getHeight());
		myGC.fillRect(5, character.getY()*myMap.getWidth()/this.getScene().getHeight(), 4, 4);
		for(Article i: arg){
			//if(i.getX()/myMap.getWidth())
		}
	}

}
