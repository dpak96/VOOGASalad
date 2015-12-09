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
import model.processes.ExecutableBounceVertical;
import model.processes.ExecutableDelete;
import model.processes.ExecutableSetHorizontalVelocity;

public class PresetCollision {
	private CollisionTypeEditor myCollisionTypeEditor;
	private final String LEFT = "Left";
	private final String RIGHT = "Right";
	private final String TOP = "Top";
	private final String BOTTOM = "Bottom";
	private final String PLAYER = "Player";
	private final String PLATFORM = "Platform";
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
//		collideWithPlatform(PLAYER);
//		collideWithPlatform(ENEMY);	
		
		Event bounceHorizontal = getBounceHorizontalEvent();
		myCollisionTypeEditor.add(LEFT, ENEMY, ENEMY, bounceHorizontal);
		myCollisionTypeEditor.add(RIGHT, ENEMY, ENEMY, bounceHorizontal);
		myCollisionTypeEditor.add(LEFT, ENEMY, PLATFORM, bounceHorizontal);
		myCollisionTypeEditor.add(RIGHT, PLATFORM, ENEMY, bounceHorizontal);
		
		Event bounceVertical = getBounceVerticalEvent();
		myCollisionTypeEditor.add(TOP, ENEMY, ENEMY, bounceVertical);
		myCollisionTypeEditor.add(BOTTOM, ENEMY, ENEMY, bounceVertical);
		myCollisionTypeEditor.add(TOP, ENEMY, PLATFORM, bounceVertical);
		myCollisionTypeEditor.add(BOTTOM, PLATFORM, ENEMY, bounceVertical);
		
//		Event die = getDieEvent();
//		myCollisionTypeEditor.add(LEFT, PLAYER, ENEMY, die);
//		myCollisionTypeEditor.add(RIGHT, PLAYER, ENEMY, die);
//		myCollisionTypeEditor.add(TOP, PLAYER, ENEMY, die);
//		myCollisionTypeEditor.add(BOTTOM, PLAYER, ENEMY, die);
//		myCollisionTypeEditor.add(TOP, ENEMY, PLAYER, bounceVertical);		
	}

	private Event getBounceVerticalEvent() {
		// TODO Auto-generated method stub
		List<Condition> conditionList = new ArrayList<Condition>();
		HashMap<String, Object> temp = new HashMap<String, Object>();
		temp.put("myName", "Daniel");
		temp.put("myActor", null);
		ExecutableBounceVertical exe = new ExecutableBounceVertical(temp);
		List<Executable> exeList = new ArrayList<Executable>();
		exeList.add(exe);
		Event event = new Event("BounceVertical", conditionList, exeList);
		return event;
	}

	private Event getDieEvent() {
		// TODO Auto-generated method stub
		List<Condition> conditionList = new ArrayList<Condition>();
		HashMap<String, Object> temp = new HashMap<String, Object>();
		temp.put("myName", "Brandon");
		temp.put("myModel", null);
		temp.put("myActor", null);
		ExecutableDelete exe = new ExecutableDelete(temp);
		List<Executable> exeList = new ArrayList<Executable>();
		exeList.add(exe);
		Event event = new Event("Die", conditionList, exeList);
		return event;
	}

	public void collideWithPlatform(String str) {
		Event stopLeftVelocity = getStopVelocityEvent("XVelocity", "Greater");
		myCollisionTypeEditor.add(LEFT, str, PLATFORM, stopLeftVelocity);
		Event stopRightVelocity = getStopVelocityEvent("XVelocity", "Less");
		myCollisionTypeEditor.add(RIGHT, str, PLATFORM, stopRightVelocity);
		Event stopTopVelocity = getStopVelocityEvent("YVelocity", "Greater");
		myCollisionTypeEditor.add(TOP, str, PLATFORM, stopTopVelocity);
		Event stopBottomVelocity = getStopVelocityEvent("YVelocity", "Less");
		myCollisionTypeEditor.add(BOTTOM, str, PLATFORM, stopBottomVelocity);
	}

	private Event getBounceHorizontalEvent() {
		// TODO Auto-generated method stub
		List<Condition> conditionList = new ArrayList<Condition>();
		HashMap<String, Object> temp = new HashMap<String, Object>();
		temp.put("myName", "Daniel");
		temp.put("myActor", null);
		ExecutableBounceHorizontal exe = new ExecutableBounceHorizontal(temp);
		List<Executable> exeList = new ArrayList<Executable>();
		exeList.add(exe);
		Event event = new Event("BounceHorizontal", conditionList, exeList);
		return event;
	}

	private Event getStopVelocityEvent(String velocityDirection, String compare) {
		// TODO Auto-generated method stub
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myName", "ok");
		tempMap.put("myXVelocity", (double) 0);
//		ExecutableSetHorizontalVelocity exe = new ExecutableSetHorizontalVelocity("horizontalStop", null, 0);
		ExecutableSetHorizontalVelocity exe = new ExecutableSetHorizontalVelocity(tempMap);
		HashMap<String, Object> temp = new HashMap<String, Object>();
		temp.put("myName", "Wu");
		temp.put("myFirst", null);
		temp.put("mySecond", null);
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
