package model;
import java.util.*;

public class Model extends Observable{
	
	private List<Rule> myRules;
	private Map<String, List<Rule>> myButtonMap;
	private List<Article> myArticles;
	private Article myViewpoint;
	private Article myCharacter;
	
	public List<Rule> getRules(){
		return myRules;
	}
	public List<Article> getArticles(){
		return myArticles;
	}
	
	public Article getArticleFromCoordinates(double x, double y){
		double xAdjusted = x + myViewpoint.getX();
		double yAdjusted = y + myViewpoint.getY();
		Article current = null;
		double smallestArea = Double.MAX_VALUE;
		for(Article article : myArticles){
			if(articleContainsPoint(article, xAdjusted, yAdjusted)){
				if(smallestArea > article.getWidth()*article.getHeight()){
					current = article;
					smallestArea = article.getWidth()*article.getHeight();
				}
			}
		}
		return current;
	}
	
	private boolean articleContainsPoint(Article article, double x, double y) {
		return x > article.getX() && x < article.getX()+article.getWidth()
		&& y > article.getY() && y < article.getY()+article.getHeight();
	}
	public Article getViewpoint(){
		return myViewpoint;
	}
	
	public Article getCharacter(){
		return myCharacter;
	}

	public void removeRuleFromArticle(Article article, Rule rule){
		article.getRules().remove(rule);
	}

	public void remapButton(String button, List<Rule> rules) {
		myButtonMap.put(button, rules);
	}
	
	public List<Rule> getButtonRules(String button){
		return myButtonMap.get(button);
	}
	public void addArticle(Article article) {
		myArticles.add(article);
	}
	public void removeArticle(Article article) {
		myArticles.remove(article);		
	}
}
