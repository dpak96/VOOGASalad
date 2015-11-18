package model;
import java.util.*;

public class Event {

	String myName;
	
	List<Condition> myConditions;
	List<Executable> myExecutables;
	
	public Event(String name, List<Condition> conditions, List<Executable> executables){
		myName = name;
		myConditions = conditions;
		myExecutables = executables;
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
