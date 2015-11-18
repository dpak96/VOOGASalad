package model;
import java.util.*;

public class Event {

	private String myName;
	
	private List<Condition> myConditions;
	private List<Executable> myExecutables;
	
	public Event(String name, List<Condition> conditions, List<Executable> executables){
		myName = name;
		myConditions = conditions;
		myExecutables = executables;
	}
	
	public void addCondition(Condition cond){
		myConditions.add(cond);
	}
	
	public void addAllConditions(List<Condition> conds){
		myConditions.addAll(conds);
	}
	
	public void addExecutaale(Executable exec){
		myExecutables.add(exec);
	}
	
	public void addAllExecutables(List<Executable> execs){
		myExecutables.addAll(execs);
	}
	
	public void fire(){
		for(Condition c : myConditions){
			if(!c.isMet()) return;
		}
		for(Executable e : myExecutables){
			e.execute();
		}
	}
	
}
