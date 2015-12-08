package game.player;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.scene.layout.VBox;
import model.article.Article;

public abstract class HUDModule extends VBox {
	
	public HUDModule(){
		super();
	}
	
	public abstract void init(double offset) throws IOException, ParserConfigurationException, SAXException;
	
	public abstract void update(Article character);
}
