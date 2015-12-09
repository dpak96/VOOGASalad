package game.player;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import action.controller.ActionController;
import javafx.scene.layout.VBox;
import model.article.Article;

public abstract class HUDModule extends VBox {
	
	public HUDModule(){
		super();
	}
	
	public abstract void init(double offset) throws IOException, ParserConfigurationException, SAXException;
	
	public abstract void update(List<Article> arg, Article character, ActionController ac);
}
