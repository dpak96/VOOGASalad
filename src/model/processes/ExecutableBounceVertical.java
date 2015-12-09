package model.processes;

import java.util.Map;

public class ExecutableBounceVertical extends Executable{

	public ExecutableBounceVertical(Map<String, Object> parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		myActor.setYVelocity(myActor.getYVelocity() * -1);
	}

}
