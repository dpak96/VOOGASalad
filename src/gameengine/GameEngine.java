package gameengine;

import java.util.List;

import model.Article;
import model.Rule;
import model.controller.ModelController;

import voogasalad_SquirtleSquad.IGameEngine;
import voogasalad_SquirtleSquad.Input;

public class GameEngine implements IGameEngine {
	private List<Article> myArticles;
	private ModelController myModelController;
	public GameEngine(ModelController modelController){
		myModelController = modelController;
	}
	
	@Override
	public void update(){
		myArticles = myModelController.getArticles();
		for(Article article : myArticles){
			List<Rule> articleRules = article.getRules();
			for(Rule rule : articleRules){
				rule.update(article);
			}
		}
	}

}