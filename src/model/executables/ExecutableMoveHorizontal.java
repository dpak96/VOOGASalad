package model.executables;

import java.util.Map;

public class ExecutableMoveHorizontal extends Executable{

	protected double myDisplacement;
	
	public ExecutableMoveHorizontal(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute(){
		myActor.setX(myActor.getX() + myDisplacement);
	}

}
