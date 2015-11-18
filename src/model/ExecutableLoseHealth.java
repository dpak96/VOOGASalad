package model;

public class ExecutableLoseHealth extends Executable {
	
	private double myDamage;

	public ExecutableLoseHealth(String name, Article actor, double damage) {
		super(name, actor);
		myDamage = damage;
	}

	@Override
	public void execute() {
		myActor.removeHealth(myDamage);
	}

}
