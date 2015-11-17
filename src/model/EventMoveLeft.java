package model;

import java.util.List;

public class EventMoveLeft extends Event{

	private double myAcceleration;
	
	public EventMoveLeft(List<Article> actors, double acceleration) {
		super(actors);
		myAcceleration = acceleration;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(){
		for(Article actor : myActors){
			actor.setYVelocity(actor.getYVelocity() - myAcceleration);
		}
	}
}
