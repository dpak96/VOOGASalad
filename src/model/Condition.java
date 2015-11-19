package model;

public abstract class Condition{

	protected String myName = "";
	
	public Condition(){
	}
	
	public Condition(String name){
		myName = name;
	}
	
	public abstract boolean isMet();
}
