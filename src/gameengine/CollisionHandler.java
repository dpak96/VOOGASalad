package gameengine;

import java.util.ArrayList;
import java.util.List;

import model.Article;
import model.Condition;
import model.ConditionCollisionFromAbove;
import model.ConditionCollisionFromLeft;
import model.ConditionCollisionFromRight;

public class CollisionHandler {
	Article myArticle;
	Article myCollided;
	CollisionInformation myCollisionInformation;
	public CollisionHandler(Article article, Article collided, CollisionInformation collisionInformation) {
		// TODO Auto-generated constructor stub
		myArticle = article;
		myCollided = collided;
		myCollisionInformation = collisionInformation;
	}
	


	public void collide(){
		List<Condition> leftCollide = new ArrayList<Condition>();
		leftCollide.add(new ConditionCollisionFromLeft("leftCollide",myCollisionInformation));
		List<Condition> rightCollide = new ArrayList<Condition>();
		rightCollide.add(new ConditionCollisionFromRight("rightCollide",myCollisionInformation));
		List<Condition> aboveCollide = new ArrayList<Condition>();
		aboveCollide.add(new ConditionCollisionFromAbove("aboveCollide",myCollisionInformation));
		List<Condition> bottomCollide = new ArrayList<Condition>();
		bottomCollide.add(new ConditionCollisionFromLeft("bottomCollide",myCollisionInformation));
		// NEED TO WORK ON EXECUTABLES
	}
	
}
