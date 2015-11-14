package gameengine;

import java.util.List;

/**
 * This is the hierarchy of classes of objects, or articles, for the games
 * @author danielpak
 *
 */
public class Article {
	
	private List<Rule> rules;	
	
	public void addRule(Rule rule){
		rules.add(rule);
	}
	
}
