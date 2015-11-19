package gameengine;

import java.util.ArrayList;
import java.util.List;

import model.Article;
import model.Condition;
import model.ConditionCollisionFromAbove;
import model.ConditionCollisionFromBottom;
import model.ConditionCollisionFromLeft;
import model.ConditionCollisionFromRight;
import model.Event;
import model.Executable;
import model.ExecutableSetHorizontalVelocity;
import model.LoadCollisionTypeFromXML;
import model.LoadMatrixFromXML;

public class CollisionHandler {
	private Article myArticle;
	private Article myCollided;
	private CollisionInformation myCollisionInformation;
	public CollisionHandler(Article article, Article collided, CollisionInformation collisionInformation) {
		// TODO Auto-generated constructor stub
		myArticle = article;
		myCollided = collided;
		myCollisionInformation = collisionInformation;
	}
	


	public void collide(){
		double leftValue = getValueFromMatrix("Left");
		List<Condition> leftCollideCondition = new ArrayList<Condition>();
		leftCollideCondition.add(new ConditionCollisionFromLeft("leftCollide",myCollisionInformation));		
		List<Executable> leftCollideExecutable = new ArrayList<Executable>();
		leftCollideExecutable.add(new ExecutableSetHorizontalVelocity("leftCollideExe", leftValue));
		Event leftCollisionEvent = new Event("leftCollision", leftCollideCondition, leftCollideExecutable);
		leftCollisionEvent.fire();
		
		double rightValue = getValueFromMatrix("Right");
		List<Condition> rightCollideCondition = new ArrayList<Condition>();
		rightCollideCondition.add(new ConditionCollisionFromRight("rightCollide",myCollisionInformation));		
		List<Executable> rightCollideExecutable = new ArrayList<Executable>();
		rightCollideExecutable.add(new ExecutableSetHorizontalVelocity("rightCollideExe", rightValue));
		Event rightCollisionEvent = new Event("rightCollision", rightCollideCondition, rightCollideExecutable);
		rightCollisionEvent.fire();
		
		double aboveValue = getValueFromMatrix("Above");
		List<Condition> aboveCollideCondition = new ArrayList<Condition>();
		aboveCollideCondition.add(new ConditionCollisionFromAbove("aboveCollide",myCollisionInformation));		
		List<Executable> aboveCollideExecutable = new ArrayList<Executable>();
		aboveCollideExecutable.add(new ExecutableSetHorizontalVelocity("aboveCollideExe", aboveValue));
		Event aboveCollisionEvent = new Event("aboveCollision", aboveCollideCondition, aboveCollideExecutable);
		aboveCollisionEvent.fire();
		
		double bottomValue = getValueFromMatrix("Bottom");
		List<Condition> bottomCollideCondition = new ArrayList<Condition>();
		bottomCollideCondition.add(new ConditionCollisionFromBottom("bottomCollide",myCollisionInformation));		
		List<Executable> bottomCollideExecutable = new ArrayList<Executable>();
		bottomCollideExecutable.add(new ExecutableSetHorizontalVelocity("bottomCollideExe", bottomValue));
		Event bottomCollisionEvent = new Event("bottomCollision", bottomCollideCondition, bottomCollideExecutable);
		bottomCollisionEvent.fire();
		
		double damageValue = getValueFromMatrix("Damage");
		List<Condition> damageCollideCondition = new ArrayList<Condition>();	
		List<Executable> damageCollideExecutable = new ArrayList<Executable>();
		damageCollideExecutable.add(new ExecutableSetHorizontalVelocity("damageCollideExe", damageValue));
		Event damageCollisionEvent = new Event("damageCollision", damageCollideCondition, damageCollideExecutable);
		damageCollisionEvent.fire();
	}
	
	public double getValueFromMatrix(String fileName){
		LoadCollisionTypeFromXML loadType = new LoadCollisionTypeFromXML();
		List<String> typeList = loadType.getCollisionTypeList();
		String myType = myArticle.getCollisionType();
		String collidedType = myCollided.getCollisionType();
		int rowIndex = typeList.indexOf(myType);
		int colIndex = typeList.indexOf(collidedType);
		LoadMatrixFromXML loadMatrix = new LoadMatrixFromXML(fileName);
		double[][] matrix = loadMatrix.getMatrix();
		
		return matrix[rowIndex][colIndex];
	}
}
