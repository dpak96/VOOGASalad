package model.controller;

import gameengine.*;

import java.util.List;

import model.*;
import model.factory.*;


public class ModelController implements IModelController {
	private Model myModel;
	private ModelFactory myModelFactory;
	
	public ModelController(Model model){
		myModel = model;
		myModelFactory = new ModelFactory();
	}
	
	public void createArticle(String fileName, double x, double y, boolean direction, List<Event> events){
		Article newArticle = myModelFactory.createArticle(fileName, x, y, direction, events);
		addArticle(newArticle);
	}
	
	public void createArticle(String fileName, double x, double y, boolean direction){
		Article newArticle = myModelFactory.createArticle(fileName, x, y, direction);
		addArticle(newArticle);
	}
	
	
	/*public void createRule(String name, double value, Article ruleOwner){
		Rule newRule = myModelFactory.createRule(name, value);
		//ruleOwner.addRule(newRule); FIX TO EVENTS
	}
	
	public void createRule(String name, double value, List<Article> dependencies, Article ruleOwner){
		Rule newRule = myModelFactory.createRule(name, value, dependencies);
		//ruleOwner.addRule(newRule); FIX TO EVENTS
	}*/

	@Override
	public List<Event> getEvents() {
		return myModel.getEvents();
	}

	@Override
	public List<Article> getArticles() {
		return myModel.getArticles();
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
		return myModel.getButtonRules(button);
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

	@Override
	public void removeArticleFromEvent(Event event, Article article) {
		// TODO Auto-generated method stub
		
	}

}
