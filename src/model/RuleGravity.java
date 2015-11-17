package model;

import java.util.List;

public class RuleGravity extends Rule{

	private double myGravity;
	
	public RuleGravity(String name, double gravity) {
		super(name, null);
		myGravity = gravity;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void apply(Article art) {
		art.setYVelocity(art.getYVelocity() + myGravity);
	}
	
	public void setYAcceleration(double gravity){
		myGravity = gravity;
	}
	
}
