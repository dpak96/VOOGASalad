package model.processes;

import java.util.Map;

import level.manager.LevelManager;

public class ExecutableNextLevel extends ExecutableLevelChanges {

	public ExecutableNextLevel(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public void execute() {
		myLevelManager.nextLevel();
	}

}
