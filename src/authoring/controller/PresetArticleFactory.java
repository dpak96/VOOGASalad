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
	}

	public void platformMovementDemo(Article article) {
		modelController.addNewCollisionType("A");
		modelController.addNewCollisionType("B");
		article.setCollisionType("B");

		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		Executable ex = authoringController.makeExecutable("ExecutableBounceVertical", tempMap);

		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();
		Event ev = authoringController.makeEvent("event", listCondition, listExecutable);

		modelController.addCollision("Left", "A", "B", ev);
	}
	
	public void goombaMovementDemo(Article article) {

		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0.2);
		Executable ex = authoringController.makeExecutable("ExecutableAccelerateVertical", tempMap);

		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();
		Event ev = authoringController.makeEvent("event", listCondition, listExecutable);
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(ev);
		modelController.addActiveEvent(ev);

		authoringController.mapKey("A", listEvent);

		article.setYVelocity(0);
		article.setCollisionType("A");
	}
}
