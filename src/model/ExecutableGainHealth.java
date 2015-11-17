package model;

public class ExecutableGainHealth extends Executable {
	
	private double myHealthGain;

	public ExecutableGainHealth(String name, Article actor, double healthGain) {
		super(name, actor);
		myHealthGain = healthGain;
	}

	@Override
	public void execute() {
		myActor.gainHealth(myHealthGain);
	}

}
