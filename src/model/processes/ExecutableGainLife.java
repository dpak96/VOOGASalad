package model.processes;

import java.util.Map;

public class ExecutableGainLife extends Executable{

	public ExecutableGainLife(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute() {
		myActor.gainLife();
	}
	
	public void execute(int life) {
		myActor.gainLife(life);
	}
}
