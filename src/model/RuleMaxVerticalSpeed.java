package model;

import java.util.List;

public class RuleMaxVerticalSpeed extends Rule{

	double myMaxSpeed;
	
	public RuleMaxVerticalSpeed(String name, double maxSpeed) {
		super(name, null);
		myMaxSpeed = maxSpeed;
	}

	@Override
	public void apply(Article art) {
		double verticalVelocity = art.getYVelocity();
		if(Math.abs(verticalVelocity) <= myMaxSpeed) return;
		art.setYVelocity(myMaxSpeed*Math.signum(verticalVelocity));
	}

}
