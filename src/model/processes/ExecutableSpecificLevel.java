package model.processes;

import java.util.Map;

import level.manager.LevelManager;

public class ExecutableSpecificLevel extends Executable {
	
	protected LevelManager myLevelManager;
	protected int levelIndex;
	
	public ExecutableSpecificLevel(Map<String, Object> parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		myLevelManager.changeLevelTo(levelIndex);
	}

}
