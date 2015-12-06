package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import gameengine.CollisionTypeEditor;
import model.processes.Condition;
import model.processes.ConditionComparisonOneArticle;
import model.processes.Executable;
import model.processes.ExecutableBounceHorizontal;
import model.processes.ExecutableSetHorizontalVelocity;

public class PresetCollision {
	private List<List<List<List<Event>>>> collisionMatrix;
	private List<String> collisionTypeName;
	private CollisionTypeEditor myCollisionTypeEditor;
	private final String LEFT = "Left";
	private final String RIGHT = "Right";
	private final String TOP = "Top";
	private final String BOTTOM = "Bottom";
	private final String PLAYER = "Player";
	private final String PLATFORM = "platform";
	private final String ENEMY = "Enemy";
	
	private final List<String> DEFAULT_TYPES= new ArrayList<String>(Arrays.asList("Player","Platform","Enemy"));
	public PresetCollision(CollisionTypeEditor editor) {
		// TODO Auto-generated constructor stub
		myCollisionTypeEditor = editor;
	}
	
	public void intialize(){
		for (String s: DEFAULT_TYPES){
			myCollisionTypeEditor.add(s);
		}
		collideWithPlatform(PLAYER);
		collideWithPlatform(ENEMY);	
		
		Event bounce = getBounceEvent();
		myCollisionTypeEditor.add(LEFT, ENEMY, ENEMY, bounce);
		
		Event die = getDieEvent();
	}

	private Event getDieEvent() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void collideWithPlatform(String str) {
		Event stopLeftVelocity = getStopVelocityEvent("XVelocity", "Less");
		myCollisionTypeEditor.add(LEFT, str, PLATFORM, stopLeftVelocity);
		Event stopRightVelocity = getStopVelocityEvent("XVelocity", "Greater");
		myCollisionTypeEditor.add(RIGHT, str, PLATFORM, stopRightVelocity);
		Event stopTopVelocity = getStopVelocityEvent("YVelocity", "Less");
		myCollisionTypeEditor.add(TOP, str, PLATFORM, stopTopVelocity);
		Event stopBottomVelocity = getStopVelocityEvent("YVelocity", "Greater");
		myCollisionTypeEditor.add(BOTTOM, str, PLATFORM, stopBottomVelocity);
	}

	private Event getBounceEvent() {
		// TODO Auto-generated method stub
		List<Condition> conditionList = new ArrayList<Condition>();
		HashMap<String, Object> temp = new HashMap<String, Object>();
		temp.put("myName", "Daniel");
		temp.put("myActor", null);
		ExecutableBounceHorizontal exe = new ExecutableBounceHorizontal(temp);
		List<Executable> exeList = new ArrayList<Executable>();
		exeList.add(exe);
		Event event = new Event("Bounce", conditionList, exeList);
		return event;
	}

	private Event getStopVelocityEvent(String velocityDirection, String compare) {
		// TODO Auto-generated method stub
		ExecutableSetHorizontalVelocity exe = new ExecutableSetHorizontalVelocity("horizontalStop", null, 0);
		HashMap<String, Object> temp = new HashMap<String, Object>();
		temp.put("myName", "Wu");
		temp.put("myFirst", null);
		temp.put("myFirstVariable", velocityDirection);
		temp.put("myCompareValue", 0);
		temp.put("myComparison", compare);
		ConditionComparisonOneArticle checkFirstArticleHorizontalVelocity = new ConditionComparisonOneArticle(temp);
		List<Condition> conditionList = new ArrayList<Condition>();
		conditionList.add(checkFirstArticleHorizontalVelocity);
		List<Executable> exeList = new ArrayList<Executable>();
		exeList.add(exe);
		Event event = new Event("StopHorizontalVelocity",conditionList, exeList);
		return event;
	}
	
	public CollisionTypeEditor getCollisonTypeEditor(){
		return myCollisionTypeEditor;
	}

}
