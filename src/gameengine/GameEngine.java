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
			double x = article.getX();
			double y = article.getY();
			double width = article.getWidth();
			double height = article.getHeight();
			double viewpointX = myViewpoint.getX();
			double viewpointY = myViewpoint.getY();
			double viewpointWidth = myViewpoint.getWidth();
			double viewpointHeight = myViewpoint.getHeight();
			double xBuffer = article.getXBuffer();
			double yBuffer = article.getYBuffer();
			if(rectanglesOverlap(viewpointX - xBuffer, viewpointX + viewpointWidth + xBuffer,
					viewpointY - yBuffer, viewpointY + viewpointHeight + yBuffer + yBuffer,
					x, x + width, y, y + height)){
				myArticles.add(article);
			}
					
		}
		return activeArticles;
	}
	
	private boolean rectanglesOverlap(double minX1, double maxX1, double minY1, double maxY1,
			double minX2, double maxX2, double minY2, double maxY2){
		return rectangleContainsPoint(minX1, maxX1, minY1, maxY1, minX2, minY2) ||
			   rectangleContainsPoint(minX1, maxX1, minY1, maxY1, minX2, maxY2) ||
			   rectangleContainsPoint(minX1, maxX1, minY1, maxY1, maxX2, minY2) ||
			   rectangleContainsPoint(minX1, maxX1, minY1, maxY1, maxX2, maxY2);
	}
	
	private boolean rectangleContainsPoint(double minX, double maxX, double minY, double maxY, double x, double y){
		return x > minX && x < maxX && y > minY && y < maxY;
	}

}