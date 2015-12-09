package authoring.controller.presets

import authoring.controller.AuthoringController
import model.Event
import model.article.Article;
import model.controller.ModelController;
import model.processes.Condition
import model.processes.Executable

class GoombaPreset extends Preset {
	public GoombaPreset(AuthoringController ac, ModelController mc) {
		super(ac, mc);
	}

	public void goombaMovement(Article article) {
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0);
		Executable ex = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableAccelerateVertical", tempMap);

		Map<String, Object> goombaMap = new HashMap<String, Object>();
		goombaMap.put("myActor", article);
		goombaMap.put("myDisplacement", (double) 10);
		Executable moveEx = myAuthoringController.callEvent("OtherController","makeExecutable","ExecutableMoveHorizontal", goombaMap);

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
}