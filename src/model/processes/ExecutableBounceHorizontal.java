package model.processes;

import java.util.Map;

public class ExecutableBounceHorizontal extends Executable{

	public ExecutableBounceHorizontal(Map<String, Object> parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		myActor.setXVelocity(myActor.getXVelocity() * -1);
		System.out.println(myActor.getImageFile() + "a");
		
	}

}
