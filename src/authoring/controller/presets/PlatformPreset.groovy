package authoring.controller.presets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import authoring.controller.AuthoringController;
import model.Event;
import model.article.Article;
import model.controller.ModelController;
import model.processes.Condition;
import model.processes.Executable;

public class PlatformPreset extends Preset {
	public PlatformPreset(AuthoringController ac, ModelController mc) {
		super(ac, mc);
		// TODO Auto-generated constructor stub
	}

	public void platformMovement(Article article) {
		// modelController.addNewCollisionType("A");
		// modelController.addNewCollisionType("B");

		article.setCollisionType("Platform");

		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
		tempMap.put("myLevelManager", null);
		// tempMap.put("myDisplacement", (double) 20);
		Executable ex = myAuthoringController.callEvent("OtherController", "makeExecutable", "ExecutableNextLevel",
				tempMap);

		List<Executable> listExecutable = new ArrayList<Executable>();
		listExecutable.add(ex);
		List<Condition> listCondition = new ArrayList<Condition>();
		Event ev = myAuthoringController.callEvent("OtherController", "makeEvent", "event", listCondition,
				listExecutable);
		myModelController.addCollision("Left", "Platform", "Enemy", ev);
	}
}
