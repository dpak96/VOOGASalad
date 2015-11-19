package model;

import java.util.Map;

public class ExecutableMoveVertical extends Executable{
	
	double myDisplacement;

	public ExecutableMoveVertical(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute(){
		myActor.setY(myActor.getY() + myDisplacement);
	}

}
