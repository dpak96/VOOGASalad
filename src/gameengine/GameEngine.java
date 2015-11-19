package gameengine;

import java.util.Arrays;
import java.util.List;

import java.util.*;

import model.Article;
import model.Event;
import model.controller.ModelController;
import resourcemanager.ResourceManager;
import voogasalad_SquirtleSquad.IGameEngine;
import voogasalad_SquirtleSquad.Input;
import model.Article;

public class GameEngine implements IGameEngine {
	private List<Article> myActiveArticles;
	private ModelController myModelController;
	private Article myViewpoint;
	private Article myCharacter;
	private CollisionManager myCollisionManager;
	
	public GameEngine(ModelController modelController){
		myModelController = modelController;
		myCollisionManager = new CollisionManager();
	}
	
	@Override
	public void update(String input){
		myViewpoint = myModelController.getViewpoint();
		setMyCharacter(myModelController.getCharacter());
		
		myActiveArticles = getActiveArticles();
		
		checkAndAddCollisions();
		runButtonPress(input);
		runArticleCollisions();
		runArticleEvents();
		runArticleUpdates();
		myModelController.notifyObservers();
		
	}
	
	private void checkAndAddCollisions(){
		for(Article article : myActiveArticles){
			article.clearCollisions();
		}
		
		for(int i = 0; i < myActiveArticles.size(); i++){
			Article first = myActiveArticles.get(i);
			for(int j = i + 1; j < myActiveArticles.size(); j++){
				Article second = myActiveArticles.get(j);
				CollisionInformation temp = myCollisionManager.didCollide(first,second);
				if(temp.isRealCollision()){
					first.addCollision(second, temp);
					second.addCollision(first, temp);
				}
			}
		}
	}
	
	private void runButtonPress(String input){
		List<Event> buttonEvents = myModelController.getButtonEvents(input);
		for(Event e : buttonEvents){
			e.fire();
		}
	}
	
	private void runArticleCollisions(){
		for(Article article : myActiveArticles){
			for(Article collided : article.getCollisionArticles()){
				//NEEDS COLLISION INFORMATION HERE
				CollisionHandler handler = new CollisionHandler(article, collided, article.getCollisionInformation(collided));
				handler.collide();
			}
		}
		
	}
	
	private void runArticleEvents(){
		for(Article article : myActiveArticles){
			List<Event> articleEvents = article.getEvents();
			for(Event e : articleEvents){
				e.fire();
			}
		}
	}
	
	private void runArticleUpdates(){
		for(Article article : myActiveArticles){
			article.update();
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
				myActiveArticles.add(article);
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

  public Article getMyCharacter() {
    return myCharacter;
  }

  public void setMyCharacter(Article myCharacter) {
    this.myCharacter = myCharacter;
  }
	
	/*
	public static void main(String args[]) {
		Article one = new Article("GoombaRefinedAgain.png");
		System.out.println(Arrays.deepToString((one.getBitMap().getByteArray())));
		for(int[] a: one.getBitMap().getByteArray()) {
			System.out.println(Arrays.toString(a));
		}
		CollisionManager temp = new CollisionManager();
		System.out.println(temp.didCollide(one, two));
	}
	*/
	

}