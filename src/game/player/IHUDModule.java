// This entire file is part of my masterpiece.
// Alex Rice
package game.player;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import action.controller.ActionController;
import model.article.Article;

public interface IHUDModule {

	public void init(double value) throws IOException, ParserConfigurationException, SAXException;
	
	public void update(List<Article> arg, Article character, ActionController ac);
}
