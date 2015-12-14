// This entire file is part of my masterpiece.
// Alex Rice
package game.player;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import action.controller.ActionController;
import javafx.scene.layout.VBox;
import model.article.Article;
import resourcemanager.ResourceManager;

public abstract class AbstractVHUDModule extends VBox implements IHUDModule {
	
	protected ResourceBundle myRB = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "english");

	public AbstractVHUDModule(){
		super();
	}
	
	public abstract void init(double offset) throws IOException, ParserConfigurationException, SAXException;
	
	public abstract void update(List<Article> arg, Article character, ActionController ac);
}
