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
	
	public Rule (String name){
		myName = name;
		myDependencies = null;
	}
	
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
	
	public void addAllDependencies(List<Article> articles){
		for(Article a: articles){
			myDependencies.add(a);
		}
	}
	
	public abstract void apply(Article art);
}
