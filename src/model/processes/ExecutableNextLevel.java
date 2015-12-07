package model.processes;

import java.util.Map;

import level.manager.LevelManager;

public class ExecutableNextLevel extends ExecutableLevelChanges {

	public ExecutableNextLevel(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public void execute() {
		System.out.println(myLevelManager);
		System.out.println("GOING TO NEXT LEVEL");
		myLevelManager.nextLevel();
	}

}
