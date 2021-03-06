package model.processes;

import java.util.Map;

public class ExecutableMoveVertical extends Executable{
	
	protected double myDisplacement;

	public ExecutableMoveVertical(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute(){
		myActor.setY(myActor.getY() + myDisplacement);
	}

}
