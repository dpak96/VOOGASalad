package authoring.controller.presets

import authoring.controller.AuthoringController
import model.Event
import model.article.Article;
import model.controller.ModelController;
import model.processes.Condition
import model.processes.Executable

class DoodleJumpPreset extends Preset {
	public DoodleJumpPreset(AuthoringController ac, ModelController mc) {

		super(ac, mc)
	}

	public void player(Article article) {

		//Key Press move left
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);

		tempMap.put("myXVelocity", (double) -7.0);

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

		tempMap.put("myXVelocity", (double) 7.0);
		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event2", listCondition, listExecutable);
		listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.callEvent("KeyPressController", "mapKey", "D", listEvent);

		//decel left
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) -0.1);

		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "GreaterThan");

		tempMap.put("myCompareValue", (double)0.1);

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
		tempMap.put("myCompareValue", (double) 0.1);
		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "GreaterThan");

		tempMap.put("myCompareValue", (double) 0.0);

		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);

		//decel right
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0.1);

		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateHorizontal", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "LessThan");
		tempMap.put("myCompareValue", (double) -0.1);
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

		tempMap.put("myCompareValue", (double)-0.1);

		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		tempMap = new HashMap<String, Object>();
		tempMap.put("myFirst", article);
		tempMap.put("myFirstVariable", "XVelocity");
		tempMap.put("myComparison", "LessThan");

		tempMap.put("myCompareValue", (double)0.0);

		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionComparisonOneArticle", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);

		//decel down
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0.1);

		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateVertical", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		tempMap = new HashMap<String, Object>();


		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);
		
		
		//VIEWPOINT
		
		
		Article myViewpoint = myModelController.getViewpoint();
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

		tempMap.put("myFraction",(double) 0.6);

		con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionAbovePositionOnScreen", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","eventKevin", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);

	}
}
