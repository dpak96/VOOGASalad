package model;

public class ExecutableGainLife extends Executable{

	public ExecutableGainLife(String name, Article actor) {
		super(name, actor);
	}

	@Override
	public void execute() {
		myActor.gainLife();
	}

}
