package model;
import java.util.*;

import gameengine.CollisionTypeEditor;
import model.article.Article;
import model.generationutility.*;
import model.processes.Condition;
import model.processes.Executable;

public class Model extends Observable{
	
	private Map<String, List<Event>> myButtonMap;
	private List<Article> myArticles;
	private List<Executable> myExecutables;
	private List<Condition> myConditions;
	private List<Event> allEvents;
	private List<Event> myActiveEvents;
	private Article myViewpoint;
	private Article myCharacter;
	private CollisionTypeEditor myCollisionTypeEditor;
	private String myBackgroundImage;
	
	private AbstractGenerationUtility randomGenerator;
	
	public Model(){
		allEvents = new ArrayList<Event>();
		myActiveEvents = new ArrayList<Event>();
		myButtonMap = new HashMap<String, List<Event>>();
		myButtonMap.put("default", new ArrayList<Event>());
		myArticles = new ArrayList<Article>();
		myExecutables = new ArrayList<Executable>();
		myConditions = new ArrayList<Condition>();
		myViewpoint = new Article("Goomba", 100, 100);
		myCharacter = new Article("Platform", 400, 400, true);
		randomGenerator = new NullGenerationUtility();
	}
	
	public void update(){
		randomGenerator.update();
	}
	
	public void setRandomGenerator(Map<Article, Double> probabilities){
		randomGenerator = new RandomGenerationUtility(probabilities, myArticles, myViewpoint);
	}

	public List<Event> getAllEvents(){
		return allEvents;
	}
	
	public void removeExecutableFromEvent(Event ev, Executable exec){
		ev.removeExecutable(exec);
	}
	
	public void removeConditionFromEvent(Event ev, Condition cond){
		ev.removeCondition(cond);
	}
	
	public List<Article> getArticles(){
	  setChanged();
		return myArticles;
	}
	
	public Article getArticleFromCoordinates(double x, double y){
		double xAdjusted = x + myViewpoint.getX();
		double yAdjusted = y + myViewpoint.getY();
		//System.out.println(myViewpoint.getX() + ", " +  myViewpoint.getY());
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
	
	public void destroyModel() {
		allEvents = null;
		myActiveEvents = null;
		myButtonMap = null;
		myArticles = null;
		myExecutables = null;
		myConditions = null;
		myViewpoint = null;
		myCharacter = null;
		myCollisionTypeEditor = null;
	}
	public void initialize() {
		allEvents = new ArrayList<Event>();
		myActiveEvents = new ArrayList<Event>();
		myButtonMap = new HashMap<String, List<Event>>();
		myButtonMap.put("default", new ArrayList<Event>());
		myArticles = new ArrayList<Article>();
		myExecutables = new ArrayList<Executable>();
		myConditions = new ArrayList<Condition>();
		myViewpoint = new Article("Goomba", 100, 100);
		myCharacter = new Article("Platform", 500, 500, true);
		myCollisionTypeEditor = new CollisionTypeEditor();
	}
	private boolean articleContainsPoint(Article article, double x, double y) {
		return x > article.getX() && x < article.getX()+article.getWidth()
		&& y > article.getY() && y < article.getY()+article.getHeight();
	}
	public Article getViewpoint(){
		return myViewpoint;
	}
	
	public void setViewpoint(Article viewpoint) {
		myViewpoint = viewpoint;
	}
	
	public Article getCharacter(){
		return myCharacter;
	}
	
	public void addAllButtonMap(Map<String, List<Event>> buttonMap) {
		myButtonMap.putAll(buttonMap);
	}
	public Map<String, List<Event>> getButtonMap() {
		return myButtonMap;
	}
	public void setCharacter(Article character) {
		myCharacter = character;
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
	public void addAllArticles(List<Article> articles) {
		myArticles.addAll(articles);
	}
	public void removeArticle(Article article) {
		myArticles.remove(article);		
	}

	public void addExecutable(Executable executable) {
		myExecutables.add(executable);
	}
	
	public void addAllExecutables(List<Executable> executables) {
		myExecutables.addAll(executables);
	}
	
	public List<Executable> getExecutables() {
		return myExecutables;
	}
	
	public void removeExecutable(Executable executable){
		myExecutables.remove(executable);
	}
	
	public void addCondition(Condition condition){
		myConditions.add(condition);
	}
	
	public void addAllConditions(List<Condition> conditions) {
		myConditions.addAll(conditions);
	}
	
	public List<Condition> getConditions() {
		return myConditions;
	}
	
	public void removeCondition(Condition condition){
		myConditions.remove(condition);
	}

	public void addEvent(Event newEvent) {
		allEvents.add(newEvent);
	}
	
	public void addAllEvents(List<Event> events) {
		allEvents.addAll(events);
	}
	
	public void removeEvent(Event event){
		if(allEvents.contains(event)){
			allEvents.remove(event);
		}
		if(myActiveEvents.contains(event)){
			myActiveEvents.remove(event);
		}
		for(String k: myButtonMap.keySet()){
			if(myButtonMap.get(k).contains(event)){
				myButtonMap.get(k).remove(event);
			}
		}
		//ADD REMOVE FROM COLLISION EVENTS!!!!
	}
	
	public void setBackgroundImage(String backgroundImage){
		myBackgroundImage = backgroundImage;
	}
	
	public String getBackgroundImage(){
		return myBackgroundImage;
	}

	public List<Event> getActiveEvents() {
		return myActiveEvents;
	}

	public void setActiveEvents(List<Event> activeEvents) {
		myActiveEvents = activeEvents;
	}
	
	public void addActiveEvent(Event event){
		myActiveEvents.add(event);
	}
	
	public void initializeCollision(){
		PresetCollision preset = new PresetCollision(myCollisionTypeEditor);
		preset.intialize();
		myCollisionTypeEditor = preset.getCollisonTypeEditor();
	}
	
	public void addNewCollisionType(String type){
		myCollisionTypeEditor.add(type);
	}
	
	public void addCollision(String direction, String nameOne, String nameTwo, Event event){
		myCollisionTypeEditor.add(direction, nameOne, nameTwo, event);
	}
	
	public List<String> getAllCollisionTypes(){
		return myCollisionTypeEditor.getCollisionTypeList();
	}
	
	public List<Event> getCollisionEvents(String direction, String nameOne, String nameTwo){
		return myCollisionTypeEditor.getEvents(direction, nameOne, nameTwo);
	}
}
