package gameengine;

import java.util.List;

/**
 * Hierarchy of classes that will define rules for the game
 * @author danielpak
 *
 */
public abstract class Rule {
	
	private String myName;
	private List<Article> myArticles;
	
	public Rule (String name){
		myName = name;
	}
	
	public void addArticle(Article art){
		myArticles.add(art);
	}
	
	public void addAllArticle(List<Article> articles){
		for(Article a: articles){
			addArticle(a);
		}
	}
	
	protected abstract void apply(Article art);
	
	public void update(){
		for(Article a: myArticles){
			apply(a);
		}
	}
}
