package model;

public abstract class Condition {
	
	private String myName;
	
	public Condition(String name){
		myName = name;
	}
	
	public abstract boolean isMet();
}
