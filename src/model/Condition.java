package model;
import java.util.*;

public abstract class Condition extends Process{

	protected String myName;
	
	public Condition(Map<String, Object> parameters){
		super(parameters);
	}
	
	public Condition(String name){
		super(name);
	}
	
	public abstract boolean isMet();
}
