package authoring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Event;
import model.article.Article;
import model.controller.ModelController;
import model.processes.Condition;
import model.processes.Executable;

public class PresetArticleFactory {
	private ModelController modelController;
	private AuthoringController authoringController;

	public PresetArticleFactory(ModelController mc, AuthoringController ac) {
		modelController = mc;
		authoringController = ac;
	}

	public void platformMovement(Article article) {
		//modelController.addNewCollisionType("A");
		//modelController.addNewCollisionType("B");

		article.setCollisionType("Platform");

		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myLevelManager", null);
		// tempMap.put("myDisplacement", (double) 20);
		Executable ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableNextLevel", tempMap);

		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();
		Event ev = authoringController.callEvent("OtherController", "makeEvent","event", listCondition, listExecutable);
		modelController.addCollision("Left", "Platform", "Enemy", ev);
	}

	public void goombaMovement(Article article) {
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0);
		Executable ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateVertical", tempMap);

		Map<String, Object> actorMap = new HashMap<String, Object>();
		actorMap.put("myActor", article);
		actorMap.put("myDisplacement", (double) 10);
		Executable moveEx = authoringController.callEvent("OtherController","makeExecutable","ExecutableMoveHorizontal", actorMap);

		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(moveEx);
		List<Condition> listCondition = new ArrayList<Condition>();
		// Event ev = authoringController.callEvent("OtherController","makeEvent","event", listCondition,
		// listExecutable);

		Event moveTest = authoringController.callEvent("OtherController","makeEvent","poop", listCondition, listExecutable);

		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(moveTest);
		// modelController.addActiveEvent(ev);

		authoringController.callEvent("OtherController","mapKey","A", listEvent);

		article.setYVelocity(0);

		article.setCollisionType("Enemy");
	}

	public void playerMovement(Article article) {
		
		//Key Press move left
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) -1);
		Executable ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();
		Event ev = authoringController.callEvent("OtherController","makeEvent","event1", listCondition, listExecutable);
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		authoringController.mapKey("A", listEvent);


		//Key Press move right
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) 1);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = authoringController.callEvent("OtherController","makeEvent","event2", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		authoringController.mapKey("D", listEvent);

		
		//key press move up
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) -1);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = authoringController.callEvent("OtherController","makeEvent","event3", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		authoringController.mapKey("W", listEvent);

		//key press move down 
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) 1);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = authoringController.callEvent("OtherController","makeEvent","event4", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		authoringController.mapKey("S", listEvent);

		//decel left
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) -0.05);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", 0.1);
		Condition con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		//stop left
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) 0);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", 0.1);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", 0);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		

		//decel right
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0.05);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", -0.1);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		//stop right
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) 0);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", -0.1);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", 0);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		//decel down

		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0.05);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateVertical", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", -0.1);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		//stop down
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) 0);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", -0.1);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", 0);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		//decel up
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) -0.05);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateVertical", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", 0.1);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		//stop up
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) 0);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", 0.1);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", 0);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		modelController.addActiveEvent(ev);

		
		//ViewPoint move from left 
		Article myViewpoint = modelController.getViewpoint();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", myViewpoint);
		tempMap.put("myDisplacement", (double) 1);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableMoveHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myViewpoint", myViewpoint);
		tempMap.put("myFraction", 0.9);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionRightOfPositionOnScreen", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","eventKevin", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		//ViewPoint move from right 

		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", myViewpoint);
		tempMap.put("myDisplacement", (double) -1);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableMoveHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myViewpoint", myViewpoint);
		tempMap.put("myFraction", 0.1);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionLeftOfPositionOnScreen", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","eventPoop", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", myViewpoint);
		tempMap.put("myDisplacement", (double) 1);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableMoveVertical", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myViewpoint", myViewpoint);
		tempMap.put("myFraction", 0.1);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionBelowPositionOnScreen", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","eventDown", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", myViewpoint);
		tempMap.put("myDisplacement", (double) -1);
		ex = authoringController.callEvent("OtherController","makeExecutable","ExecutableMoveVertical", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myViewpoint", myViewpoint);
		tempMap.put("myFraction", 0.9);
		con = authoringController.callEvent("OtherController","makeCondition","ConditionAbovePositionOnScreen", tempMap);
		listCondition.add(con);
		ev = authoringController.callEvent("OtherController","makeEvent","eventUp", listCondition, listExecutable);
		modelController.addActiveEvent(ev);
		
		
		
	}
}
