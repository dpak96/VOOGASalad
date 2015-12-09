package gameengine;

import java.util.Arrays;
import java.util.List;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import model.Event;
import model.article.Position;
import model.article.Article;
import model.controller.ModelController;
import model.generationutility.AbstractGenerationUtility;
import model.processes.ExecutableLevelChanges;
import resourcemanager.ResourceManager;
import voogasalad_SquirtleSquad.IGameEngine;
import voogasalad_SquirtleSquad.Input;


public class GameEngine implements IGameEngine {
	private List<Article> myActiveArticles;
	private ModelController myModelController;
	private Article myViewpoint;
	private Article myCharacter;
	private CollisionManager myCollisionManager;
	private List<Article> allArticles;
	private AbstractGenerationUtility genUtil; 
	
	public GameEngine(ModelController modelController){
		myModelController = modelController;
		myCollisionManager = new CollisionManager();
	}
	
	@Override
	public void update(String input){
		myViewpoint = myModelController.getViewpoint();
		allArticles = myModelController.getArticles();
		setMyCharacter(myModelController.getCharacter());
		//myActiveArticles = getActiveArticles();
		updateActiveArticles();
		myActiveArticles = getActiveArticles();
		checkAndAddCollisions();
		runButtonPress(input);
		runArticleCollisions();
		runActiveEvents();
		runArticleUpdates();
		myModelController.update();		
		
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
					second.addCollision(first, temp.makeReverseDirectionObject());
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

				List<Event> events = myModelController.getCollisionEvents(article.getCollisionInformation(collided).getCollideDirection(), 
						article.getCollisionType(), collided.getCollisionType());
				for (Event e:events){
					e.fire(article, collided);
				}
			}
		}
		
	}
	
	private void runActiveEvents(){
		for(Event e : myModelController.getActiveEvents()){
			e.fire();
			//System.out.println(e.getMyName());
		}
	}
	
	private void runArticleUpdates(){
		for(Article article : myActiveArticles){
			article.update();
		}
	}
	
	/*
	 * Makes list of Active articles
	 */
	private List<Article> getActiveArticles() {
		List<Article> activeArticles = new ArrayList<Article>();

//		for(Article article : myModelController.getArticles()){
//			double x = article.getX();
//			double y = article.getY();
//			double width = article.getWidth();
//			double height = article.getHeight();
//			double viewpointX = myViewpoint.getX();
//			double viewpointY = myViewpoint.getY();
//			double viewpointWidth = myViewpoint.getWidth();
//			double viewpointHeight = myViewpoint.getHeight();
//			double xBuffer = article.getXBuffer();
//			double yBuffer = article.getYBuffer();
//			if(rectanglesOverlap(viewpointX - xBuffer, viewpointX + viewpointWidth + xBuffer,
//					viewpointY - yBuffer, viewpointY + viewpointHeight + yBuffer + yBuffer,
//					x, x + width, y, y + height)){
//				myActiveArticles.add(article);

		int size = allArticles.size();
		for(int i = 0; i < size; i++){
			try {
				if(allArticles.get(i).getStatus().equals(Article.Status.ACTIVE)) activeArticles.add(allArticles.get(i));
			} catch(Exception e){

			}
		}
		return activeArticles;
	}
	
	/*
	 * Updates articles within the viewpoint to active except for HardInactives
	 */
	private void updateActiveArticles(){
		for(Article article : allArticles){
			if(!article.getStatus().equals( Article.Status.HARDINACTIVE)){
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
					article.setActive();
				}
				else{
					article.setInactive();
				}
			}	
		}
	}
	
	private boolean rectanglesOverlap(double minX1, double maxX1, double minY1, double maxY1,
			double minX2, double maxX2, double minY2, double maxY2){
		return rectangleContainsPoint(minX1, maxX1, minY1, maxY1, minX2, minY2) ||
			   rectangleContainsPoint(minX1, maxX1, minY1, maxY1, minX2, maxY2) ||
			   rectangleContainsPoint(minX1, maxX1, minY1, maxY1, maxX2, minY2) ||
			   rectangleContainsPoint(minX1, maxX1, minY1, maxY1, maxX2, maxY2);
	}
	
	private void checker(double minX1, double maxX1, double minY1, double maxY1,
			double minX2, double maxX2, double minY2, double maxY2){
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
	
	
//	public static void main(String args[]) {
//		Article one = new Article("Goomba", 100, 100, true);
//		CollisionFinder test = new CollisionFinder(one.getBitMap().getByteArray());
////		while(test.hasNext()) {
////			Position temp = test.next();
////		}
//		
//		for(Position[] a: one.getBitMap().getByteArray()) {
//			for(Position p: a) {
//				if(p.isValidPosition()) {
//				} else {
//				}
//			}
//		}
//	}
	
	

}