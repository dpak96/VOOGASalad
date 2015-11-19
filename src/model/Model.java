package model;
import java.util.*;

public class Model extends Observable{
	
	private List<Event> myEvents;
	private Map<String, List<Event>> myButtonMap;
	private List<Article> myArticles;
	private List<Executable> myExecutables;
	private List<Condition> myConditions;
	private Article myViewpoint;
	private Article myCharacter;


	
	public List<Event> getEvents(){
		return myEvents;
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
	
	public void initialize() {
		myEvents = new ArrayList<Event>();
		myButtonMap = new HashMap<String, List<Event>>();
		myButtonMap.put("default", new ArrayList<Event>());
		myArticles = new ArrayList<Article>();
		myExecutables = new ArrayList<Executable>();
		myConditions = new ArrayList<Condition>();
		myViewpoint = new Article("Goomba", 100, 100);
		myCharacter = new Article("Goomba", 100, 100);
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
		return myButtonMap.getOrDefault(button,myButtonMap.get("default"));
	}
	public void addArticle(Article article) {
		myArticles.add(article);
		setChanged();
	}
	public void removeArticle(Article article) {
		myArticles.remove(article);		
	}

	public void addExecutable(Executable executable) {
		myExecutables.add(executable);
	}
	
	public void removeExecutable(Executable executable){
		myExecutables.remove(executable);
	}
	
	public void addCondition(Condition condition){
		myConditions.add(condition);
	}
	
	public void removeCondition(Condition condition){
		myConditions.remove(condition);
	}

	public void addEvent(Event newEvent) {
		myEvents.add(newEvent);
	}
	
	public void removeEvent(Event event){
		myEvents.remove(event);
	}
	
}
