package model;
import java.util.*;

public class Event {

	List<Article> myActors;
	
	List<Condition> myConditions;
	List<Executable> myExecutables;
	
	public Event(List<Condition> conditions, List<Executable> executables){
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
