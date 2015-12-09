package authoring.controller.presets

import authoring.controller.AuthoringController
import model.Event
import model.article.Article
import model.controller.ModelController
import model.processes.Condition
import model.processes.Executable

class FlappyPreset extends Preset {
	public FlappyPreset(AuthoringController ac, ModelController mc) {
		super(ac, mc);
	}

	public player(Article article){



		//decel down
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0.2);

		Executable ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateVertical", tempMap);
		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();


		Event ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);


		//key press move up
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);

		tempMap.put("myYVelocity", (double) -3.0);

		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetVerticalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event3", listCondition, listExecutable);
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		myAuthoringController.callEvent("KeyPressController", "mapKey", "W", listEvent);


		//MOVE RIGHT
		tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myXVelocity", (double) 0.5);

		ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableSetHorizontalVelocity", tempMap);
		listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		listCondition = new ArrayList<Condition>();
		ev = myAuthoringController.callEvent("OtherController","makeEvent","event99", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);






		//VIEWPOINT

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

		tempMap.put("myFraction",(double) 0.4);

		Condition con = myAuthoringController.callEvent("OtherController","makeCondition","ConditionRightOfPositionOnScreen", tempMap);
		listCondition.add(con);
		ev = myAuthoringController.callEvent("OtherController","makeEvent","eventKevin", listCondition, listExecutable);
		myModelController.addActiveEvent(ev);




	}
}
