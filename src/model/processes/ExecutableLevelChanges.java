package model.processes;

import java.util.Map;

import level.manager.LevelManager;

public abstract class ExecutableLevelChanges extends Executable {
	
	protected LevelManager myLevelManager;
	
	public ExecutableLevelChanges(Map<String, Object> parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}
	
	public void initialize(LevelManager levelManager) {
		myLevelManager = levelManager;
	}
}
