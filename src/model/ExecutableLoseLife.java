package model;

public class ExecutableLoseLife extends Executable{

	public ExecutableLoseLife(String name, Article actor) {
		super(name, actor);
	}

	@Override
	public void execute() {
		myActor.removeLife();
	}

}
