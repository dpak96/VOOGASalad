package model;

import java.util.Map;

public class ExecutableGainHealth extends Executable {
	
	private double myHealthGain;

	public ExecutableGainHealth(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute() {
		myActor.gainHealth(myHealthGain);
	}

}
