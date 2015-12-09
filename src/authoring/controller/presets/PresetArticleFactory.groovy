/*
 *  NOTE: THIS CLASS IS MEANT TO HELP US SAVE TIME ON THE DEMO.
 *  
 *  I am aware there is a lot of duplicated code, but it is meant to attach as a module onto the authoring controller
 *  
 *  Each line of code is meant to replace a user function on the front end!!
 *  
 *  In this way we are allowed to keep the massive amount of flexibility but to save user time
 * 
 */

package authoring.controller.presets;

import authoring.controller.AuthoringController
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
	private ModelController myModelController;
	private AuthoringController myAuthoringController;

	public PresetArticleFactory(ModelController mc, AuthoringController ac) {
		myModelController = mc;
		myAuthoringController = ac;
	}

	public void platformMovement(Article article) {
		//modelController.addNewCollisionType("A");
		//modelController.addNewCollisionType("B");

		article.setCollisionType("Platform");

		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myLevelManager", null);
		// tempMap.put("myDisplacement", (double) 20);
		Executable ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableNextLevel", tempMap);

		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();
		Event ev = myAuthoringController.callEvent("OtherController", "makeEvent","event", listCondition, listExecutable);
		myModelController.addCollision("Left", "Platform", "Enemy", ev);
	}

	public void goombaMovement(Article article) {
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0);
		Executable ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateVertical", tempMap);

		Map<String, Object> poopMap = new HashMap<String, Object>();
		poopMap.put("myActor", article);
		poopMap.put("myDisplacement", (double) 10);
		Executable moveEx = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableMoveHorizontal", poopMap);

		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(moveEx);
		List<Condition> listCondition = new ArrayList<Condition>();
		// Event ev = authoringController.callEvent("OtherController","makeEvent","event", listCondition,
		// listExecutable);

		Event moveTest = myAuthoringController.callEvent("OtherController","makeEvent","poop", listCondition, listExecutable);

		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(moveTest);
		// modelController.addActiveEvent(ev);

		myAuthoringController.callEvent("OtherController","mapKey","A", listEvent);

		article.setYVelocity(0);

		article.setCollisionType("Enemy");
	}

	public void playerMovement(Article article) {
		
		//Key Press move left
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) -1);
		Executable ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();
		Event ev = myAuthoringController.callEvent("OtherController","makeEvent","event1", listCondition, listExecutable);
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.mapKey("A", listEvent);

		
		//Key Press move right
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) 1);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event2", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.mapKey("D", listEvent);

		
		//key press move up
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) -1);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event3", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.mapKey("W", listEvent);

		//key press move down 
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) 1);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event4", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.mapKey("S", listEvent);

		//decel left
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) -0.05);

		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", 0.1);
		Condition con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		//stop left
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) 0);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", 0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", 0);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		//decel right
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0.05);

		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", -0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		//stop right
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) 0);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", -0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", 0);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		//decel down
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0.05);

		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateVertical", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", -0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		//stop down
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) 0);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", -0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", 0);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		//decel up
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) -0.05);

		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateVertical", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", 0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		//stop up
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) 0);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", 0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "YVelocity");
		tempMap.put("myComparison", "GreaterThan");
		tempMap.put("myCompareValue", 0);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		//ViewPoint move from left 

		Article myViewpoint = myModelController.getViewpoint();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", myViewpoint);
		tempMap.put("myDisplacement", (double) 1);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableMoveHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myViewpoint", myViewpoint);
		tempMap.put("myFraction", 0.9);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionRightOfPositionOnScreen", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","eventKevin", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		//ViewPoint move from right 

		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", myViewpoint);
		tempMap.put("myDisplacement", (double) -1);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableMoveHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myViewpoint", myViewpoint);
		tempMap.put("myFraction", 0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionLeftOfPositionOnScreen", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","eventPoop", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", myViewpoint);
		tempMap.put("myDisplacement", (double) 1);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableMoveVertical", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myViewpoint", myViewpoint);
		tempMap.put("myFraction", 0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionBelowPositionOnScreen", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","eventDown", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", myViewpoint);
		tempMap.put("myDisplacement", (double) -1);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableMoveVertical", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myViewpoint", myViewpoint);
		tempMap.put("myFraction", 0.9);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionAbovePositionOnScreen", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","eventUp", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		
		
	}
}
