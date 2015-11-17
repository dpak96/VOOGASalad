package model;

public abstract class Executable {

	protected Article myActor;
	
	public Executable(Article actor){
		myActor = actor;
	}
	
	public abstract void execute();
}
