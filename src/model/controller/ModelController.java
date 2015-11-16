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
	public void setRules() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArticle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArticle() {
		// TODO Auto-generated method stub
		
	}
	
	
}
