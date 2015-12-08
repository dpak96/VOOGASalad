package model.processes;

import java.util.Map;

public class ExecutableLoseScore extends Executable{

	public ExecutableLoseScore(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute() {
		myActor.removeScore();
	}

}
