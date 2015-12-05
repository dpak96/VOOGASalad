package model.executables;

import java.util.Map;

public class ExecutableGainLife extends Executable{

	public ExecutableGainLife(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute() {
		myActor.gainLife();
	}

}
