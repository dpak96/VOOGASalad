package model.processes;

import java.util.Map;

public class ExecutableLoseHealth extends Executable {
	
	private double myDamage;

	public ExecutableLoseHealth(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute() {
		myActor.removeHealth(myDamage);
	}

}
