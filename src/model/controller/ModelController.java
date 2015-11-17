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
	
	public void createArticle(String fileName, double x, double y, boolean direction, List<Rule> rules){
		Article newArticle = myModelFactory.createArticle(fileName, x, y, direction, rules);
		addArticle(newArticle);
	}
	
	public void createArticle(String fileName, double x, double y, boolean direction){
		Article newArticle = myModelFactory.createArticle(fileName, x, y, direction);
		addArticle(newArticle);
	}
	
	public void createRule(String name, double value, Article ruleOwner){
		Rule newRule = myModelFactory.createRule(name, value);
		ruleOwner.addRule(newRule);
	}
	
	public void createRule(String name, double value, List<Article> dependencies, Article ruleOwner){
		Rule newRule = myModelFactory.createRule(name, value, dependencies);
		ruleOwner.addRule(newRule);
	}

	@Override
	public List<Rule> getRules() {
		return myModel.getRules();
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
	public void remapButton(String button, List<Rule> rules){
		myModel.remapButton(button, rules);
	}
	
	@Override
	public List<Rule> getButonRules(String button){
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

	@Override
	public void removeArticleFromRule(Rule rule, Article article) {
		// TODO Auto-generated method stub
		
	}

}
