package model.controller;

import gameengine.*;

import java.util.*;

import model.*;
import model.factory.*;
import resourcemanager.ResourceManager;


public class ModelController implements IModelController {
	private Model myModel;
	private ModelFactory myModelFactory;
	
	//WILL ADD CREATES FOR EVENTS AND STUFF AFTER WE DECIDE ON HOW TO PASS PARAMETERS
	 
	public ModelController(Model model){
		myModel = model;
		myModel.initialize();
		myModelFactory = new ModelFactory();
	}
	
	public Map<String, Class<?>> getParameters(String className){
		return myModelFactory.getParameters(className);
	}
	
	public void createArticle(String fileName, double x, double y, boolean direction, List<Event> events){
		Article myViewpoint = myModel.getViewpoint();
		double xAdjusted = x + myViewpoint.getX();
		double yAdjusted = y + myViewpoint.getY();
		Article newArticle = myModelFactory.createArticle(fileName, xAdjusted, yAdjusted, direction, events);
		addArticle(newArticle);
	}
	
	public void createArticle(String fileName, double x, double y, boolean direction){
		Article newArticle = myModelFactory.createArticle(fileName, x, y, direction);
		addArticle(newArticle);
	}
	
	public Executable createExecutable(String executableName, Map<String, Object> data){
		Executable newExecutable = myModelFactory.createExecutable(executableName, data);
		addExecutable(newExecutable);
		return newExecutable;
	}
	
	public Condition createCondition(String conditionName, Map<String, Object> data){
		Condition newCondition = myModelFactory.createCondition(conditionName, data);
		addCondition(newCondition);
		return newCondition;
	}
	
	public Event createEvent(String name, List<Condition> conditions, List<Executable> executables){
		Event newEvent = myModelFactory.createEvent(name, conditions, executables);
		addEvent(newEvent);
		return newEvent;
	}

	public void addEvent(Event newEvent) {
		myModel.addEvent(newEvent);
	}
	
	public void removeEvent(Event event){
		myModel.removeEvent(event);
	}

	@Override
	public List<Event> getEvents() {
		return myModel.getEvents();
	}
	public List<Article> getArticles() {
		return myModel.getArticles();
	}
	
	public void addExecutable(Executable executable){
		myModel.addExecutable(executable);
	}
	
	public void removeExecutable(Executable executable){
		myModel.removeExecutable(executable);
	}
	
	public void addCondition(Condition condition){
		myModel.addCondition(condition);
	}
	
	public void removeCondition(Condition condition){
		myModel.removeCondition(condition);
	}

	@Override
	public void addArticle(Article article) {
		myModel.addArticle(article);
	}

	@Override
	public void removeArticle(Article article) {
		myModel.removeArticle(article);
	}
	
	@Override
	public void remapButton(String button, List<Event> events){
		myModel.remapButton(button, events);
	}
	
	@Override
	public List<Event> getButtonEvents(String button){
		return myModel.getButtonEvents(button);
	}

	public Article getCharacter() {
		return myModel.getCharacter();
	}
	
	public Article getViewpoint(){
		return myModel.getViewpoint();
	}
	
	public Article getArticleFromCoordinates(double x, double y){
		return myModel.getArticleFromCoordinates(x, y);
	}
	
	public void notifyObservers(){
		myModel.notifyObservers();
	}

}
