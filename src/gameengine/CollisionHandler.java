package gameengine;

import java.util.ArrayList;
import java.util.List;

import model.Article;
import model.Condition;
import model.ConditionCollisionFromAbove;
import model.ConditionCollisionFromLeft;
import model.ConditionCollisionFromRight;
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
		leftCollideExecutable.add(new ExecutableSetHorizontalVelocity);
		
		List<Condition> rightCollideCondition = new ArrayList<Condition>();
		rightCollideCondition.add(new ConditionCollisionFromRight("rightCollide",myCollisionInformation));
		List<Condition> aboveCollideCondition = new ArrayList<Condition>();
		aboveCollideCondition.add(new ConditionCollisionFromAbove("aboveCollide",myCollisionInformation));
		List<Condition> bottomCollideCondition = new ArrayList<Condition>();
		bottomCollideCondition.add(new ConditionCollisionFromLeft("bottomCollide",myCollisionInformation));
		List<Condition> damageCollideCondition = new ArrayList<Condition>();
		// NEED TO WORK ON EXECUTABLES
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
