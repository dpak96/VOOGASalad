package model;

import java.util.List;

/**
 * Hierarchy of classes that will define rules for the game
 * @author danielpak
 *
 */
public abstract class Rule {
	
	private String myName;
	protected List<Article> myArticles;
	
	public Rule (String name){
		myName = name;
	}
	
	public void removeArticle(Article article){
		myArticles.remove(article);
	}
	
	public void addArticle(Article art){
		myArticles.add(art);
	}
	
	public void addAllArticle(List<Article> articles){
		for(Article a: articles){
			addArticle(a);
		}
	}
	
	public abstract void update();

}
