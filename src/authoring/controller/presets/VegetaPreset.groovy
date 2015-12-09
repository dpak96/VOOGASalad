package authoring.controller.presets

import authoring.controller.AuthoringController
import model.Event
import model.article.Article;
import model.controller.ModelController;
import model.processes.Condition
import model.processes.Executable


public class VegetaPreset extends Preset {
	public VegetaPreset(AuthoringController ac, ModelController mc) {
		super(ac, mc)
	}

	public void noClipMovement(Article article) {

		//Key Press move left
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) -1.0);
		Executable ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();
		Event ev = myAuthoringController.callEvent("OtherController","makeEvent","event1", listCondition, listExecutable);
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.callEvent("KeyPressController", "mapKey", "A", listEvent);


		//Key Press move right
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) 1.0);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event2", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.callEvent("KeyPressController", "mapKey", "D", listEvent);


		//key press move up
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) -1.0);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event3", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.callEvent("KeyPressController", "mapKey", "W", listEvent);

		//key press move down
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myYVelocity", (double) 1.0);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event4", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.callEvent("KeyPressController", "mapKey", "S", listEvent);

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
		tempMap.put("myXVelocity", (double) 0.0);
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
		tempMap.put("myCompareValue", 0.0);
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
		tempMap.put("myXVelocity", (double) 0.0);
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
		tempMap.put("myCompareValue", 0.0);
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
		tempMap.put("myYVelocity", (double) 0.0);
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
		tempMap.put("myCompareValue", 0.0);
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
		tempMap.put("myYVelocity", (double) 0.0);
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
		tempMap.put("myCompareValue", 0.0);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);

		//ViewPoint move from left

		Article myViewpoint = myModelController.getViewpoint();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", myViewpoint);
		tempMap.put("myDisplacement", (double) 1.0);
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
		tempMap.put("myDisplacement", (double) -1.0);
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
		tempMap.put("myDisplacement", (double) 1.0);
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
		tempMap.put("myDisplacement", (double) -1.0);
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
