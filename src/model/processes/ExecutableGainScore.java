package model.processes;

import java.util.Map;

public class ExecutableGainScore extends Executable{

	public ExecutableGainScore(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute() {
		myActor.gainScore();
	}

}
