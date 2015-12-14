// This entire file is part of my masterpiece.
// Alex Rice
package game.player;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import action.controller.ActionController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.article.Article;

public class MapOverviewModule extends AbstractVHUDModule {
	
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
		myMap.setVisible(true);
		this.getChildren().addAll(myMap);
		
	}

	@Override
	public void update(List<Article> arg,Article character, ActionController ac) {
		myGC.setFill(Color.rgb(0, 255,0,0.5));
		myGC.clearRect(myMap.getLayoutX(), myMap.getLayoutY(), myMap.getWidth(), myMap.getHeight());
		//character square
		myGC.fillRect(5, myMap.getHeight()/2, 4, 4);
		myGC.setFill(Color.rgb(255, 255,0,0.5));
		//surroundings squares
		for(Article i: arg){
			if(i!=character){
			myGC.fillRect(getXInMap(i,character), getYInMap(i,character), getWidthInMap(i), getHeightInMap(i));
			}
		}
	}
	
	private double getXInMap(Article art, Article character){
		return (art.getX()*myMap.getWidth()/this.getScene().getWidth()-character.getX()*myMap.getWidth()/this.getScene().getWidth()+5)/2;
	}
	
	private double getYInMap(Article art, Article character){
		return (art.getY()*myMap.getHeight()/this.getScene().getHeight()-character.getY()*myMap.getHeight()/this.getScene().getHeight()+myMap.getHeight()/2);
	}
	
	private double getWidthInMap(Article art){
		return (art.getWidth()*myMap.getWidth()/this.getScene().getWidth());
	}
	
	private double getHeightInMap(Article art){
		return (art.getHeight()*myMap.getHeight()/this.getScene().getHeight());
	}

}
