package model.processes;

import java.util.Map;

import level.manager.LevelManager;

public class ExecutableSpecificLevel extends Executable {
	
	public ExecutableSpecificLevel(Map<String, Object> parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	protected LevelManager myLevelManager;
	protected int levelIndex;

	@Override
	public void execute() {
		//Switch levels based on index
		// myLevelManager.switchLevel(levlIndex);
	}

}
