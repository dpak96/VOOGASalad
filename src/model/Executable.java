package model;

public abstract class Executable{

	protected Article myActor = new Article();
	protected String myName = "";
	
	public Executable(String name, Article actor){
		myName = name;
		myActor = actor;
	}
	
	public abstract void execute();
}
