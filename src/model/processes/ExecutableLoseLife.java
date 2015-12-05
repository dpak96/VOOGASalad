package model.processes;

import java.util.Map;

public class ExecutableLoseLife extends Executable{

	public ExecutableLoseLife(Map<String, Object> parameters){
		super(parameters);
	}
	
	@Override
	public void execute() {
		myActor.removeLife();
	}

}
