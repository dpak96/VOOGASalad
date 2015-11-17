package gameengine;

import java.util.*;

import model.Article;
import model.Rule;
import model.controller.ModelController;

import voogasalad_SquirtleSquad.IGameEngine;
import voogasalad_SquirtleSquad.Input;

public class GameEngine implements IGameEngine {
	private List<Article> myArticles;
	private ModelController myModelController;
	private Article myViewpoint;
	private Article myCharacter;
	
	public GameEngine(ModelController modelController){
		myModelController = modelController;
	}
	
	@Override
	public void update(){
		myArticles = myModelController.getArticles();
		myViewpoint = myModelController.getViewpoint();
		myCharacter = myModelController.getCharacter();
		
		
		myArticles = getActiveArticles();
		
		for(Article article : myArticles){
			List<Rule> articleRules = article.getRules();
			for(Rule rule : articleRules){
				rule.update(article);
			}
		}
	}
	
	private List<Article> getActiveArticles(){
		List<Article> activeArticles = new ArrayList<Article>();
		for(Article article : myModelController.getArticles()){
			if(isInViewpoint(article.getX(),article.getY()) || 
			   isInViewpoint(article.getX()+article.getWidth(),article.getY()) || 
			   isInViewpoint(article.getX(),article.getY()+article.getHeight()) ||
			   isInViewpoint(article.getX()+article.getWidth(),article.getY())){
				myArticles.add(article);
			}
					
		}
		return activeArticles;
	}
	
	private boolean isInViewpoint(double x, double y){
		return x > myViewpoint.getX() && x < myViewpoint.getX()+myViewpoint.getWidth()
			&& y > myViewpoint.getY() && y < myViewpoint.getY()+myViewpoint.getHeight();
	}

}