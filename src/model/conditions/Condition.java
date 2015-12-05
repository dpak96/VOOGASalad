package model.conditions;
import java.util.*;

import model.Process;

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
