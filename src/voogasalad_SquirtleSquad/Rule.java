package voogasalad_SquirtleSquad;

import java.util.List;

/**
 * Hierarchy of classes that will define rules for the game
 * @author danielpak
 *
 */
public class Rule {
	
	private String myName;
	private List<Article> myArticles;
	
	public Rule (String name){
		myName = name;
	}
	
	public void addArticle(Article art){
		myArticles.add(art);
	}
	
	public void apply(Article art){
		//Applies the rule on a given article
	}
	
	public void update(){
		for(Article a: myArticles){
			apply(a);
		}
	}
}
