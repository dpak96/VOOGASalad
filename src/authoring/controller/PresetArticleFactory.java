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
		modelController.addNewCollisionType("A");
		modelController.addNewCollisionType("B");
		
		article.setCollisionType("A");

		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		//tempMap.put("myDisplacement", (double) 20);
		Executable ex = authoringController.makeExecutable("ExecutableNextLevel", tempMap);

		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();
		Event ev = authoringController.makeEvent("event", listCondition, listExecutable);
		modelController.addCollision("Left", "A", "B", ev);
	}
	
	public void goombaMovement(Article article) {
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myAcceleration", (double) 0);
		Executable ex = authoringController.makeExecutable("ExecutableAccelerateVertical", tempMap);
		
		Map<String, Object> poopMap = new HashMap<String, Object>();
		poopMap.put("myActor", article);
		poopMap.put("myDisplacement", (double) 10);
		Executable moveEx = authoringController.makeExecutable("ExecutableMoveHorizontal", poopMap);
		
		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(moveEx);
		List<Condition> listCondition = new ArrayList<Condition>();
		//Event ev = authoringController.makeEvent("event", listCondition, listExecutable);
		
		Event moveTest = authoringController.makeEvent("poop", listCondition, listExecutable);
		
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(moveTest);
		//modelController.addActiveEvent(ev);

		authoringController.mapKey("A", listEvent);

		article.setYVelocity(0);
		article.setCollisionType("B");

	}
}
