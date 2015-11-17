package model;

import java.util.List;

/**
 * Hierarchy of classes that will define rules for the game
 * @author danielpak
 *
 */
public abstract class Rule {
	
	private String myName;
	protected List<Article> myDependencies;
	
	public Rule (String name, List<Article> dependencies){
		myName = name;
		myDependencies = dependencies;
	}
	
	public void removeDependency(Article article){
		myDependencies.remove(article);
	}
	
	public void addDependency(Article art){
		myDependencies.add(art);
	}
	
	public abstract void update(Article art);
}
