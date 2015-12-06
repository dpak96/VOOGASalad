package model.processes;

import java.util.Map;

import level.manager.LevelManager;

public class ExecutableDeath extends Executable {

	protected LevelManager myLevelManager;
	
	public ExecutableDeath(Map<String, Object> parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		myActor.removeLife();
		if(myActor.getLife() <= 0){
			myLevelManager.gameOver();
		}
		else myLevelManager.resetLevel();
	}

}
