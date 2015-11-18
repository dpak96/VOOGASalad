package model;
import java.util.*;

public class Model extends Observable{
	
	private Map<String, List<Event>> myButtonMap;
	private List<Article> myArticles;
	private Article myViewpoint;
	private Article myCharacter;
	
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

	public void removeEventFromArticle(Article article, Event event){
		article.getEvents().remove(event);
	}

	public void remapButton(String button, List<Event> events) {
		myButtonMap.put(button, events);
	}
	
	public List<Event> getButtonEvents(String button){
		return myButtonMap.get(button);
	}
	public void addArticle(Article article) {
		myArticles.add(article);
	}
	public void removeArticle(Article article) {
		myArticles.remove(article);		
	}
}
