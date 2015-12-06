package model.processes;

import java.util.Map;

import model.article.Article;

public class ExecutableSetHorizontalVelocity extends Executable{

	protected double myXVelocity;
	
	public ExecutableSetHorizontalVelocity(Map<String, Object> parameters){
		super(parameters);
	}
	
	public ExecutableSetHorizontalVelocity(String name, Article actor, double xVelocity){
		super(name, actor);
		myXVelocity = xVelocity;
	}

	@Override
	public void execute() {
		myActor.setXVelocity(myXVelocity);
	}

	
	
}
