package model.processes;

import java.util.Map;

import model.article.Article;

public class ExecutableMoveWithActor extends Executable {

	protected Article actorToFollow;
	
	public ExecutableMoveWithActor(Map<String, Object> parameters) {
		super(parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		myActor.setXVelocity(actorToFollow.getXVelocity());
		myActor.setYVelocity(actorToFollow.getYVelocity());
	}

}
