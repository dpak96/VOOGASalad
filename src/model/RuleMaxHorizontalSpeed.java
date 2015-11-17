package model;

import java.util.List;

public class RuleMaxHorizontalSpeed extends Rule{

	double myMaxSpeed;
	
	public RuleMaxHorizontalSpeed(String name, double maxSpeed) {
		super(name, null);
		myMaxSpeed = maxSpeed;
	}

	@Override
	public void update(Article art) {
		double horizontalVelocity = art.getXVelocity();
		if(Math.abs(horizontalVelocity) <= myMaxSpeed) return;
		art.setXVelocity(myMaxSpeed*Math.signum(horizontalVelocity));
	}

}
