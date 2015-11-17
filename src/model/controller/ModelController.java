package model.controller;

import gameengine.*;

import java.util.List;

import model.Article;
import model.Model;
import model.Rule;

public class ModelController implements IModelController {
	private Model myModel;
	
	public ModelController(Model model){
		myModel = model;
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

	@Override
	public void removeArticleFromRule(Rule rule, Article article) {
		// TODO Auto-generated method stub
		
	}

}
