package model;
import java.util.*;

import model.article.Article;
import model.processes.Condition;
import model.processes.Executable;

public class Event {

	private String myName;
	
	private List<Condition> myConditions;
	private List<Executable> myExecutables;
	
	public Event(String name, List<Condition> conditions, List<Executable> executables){
		myName = name;
		myConditions = conditions;
		myExecutables = executables;
	}
	
	
	public List<Condition> getConditions(){
		return myConditions;
	}
	
	public List<Executable> getExecutables(){
		return myExecutables;
	}
	
	public void addCondition(Condition cond){
		myConditions.add(cond);
	}
	
	public void addAllConditions(List<Condition> conds){
		myConditions.addAll(conds);
	}
	
	public void addExecutable(Executable exec){
		myExecutables.add(exec);
	}
	
	public void addAllExecutables(List<Executable> execs){
		myExecutables.addAll(execs);
	}
	
	public String getMyName(){
		return myName;
	}
	
	public void fire(){
		for(Condition c : myConditions){
			if(!c.isMet()) return;
		}
		for(Executable e : myExecutables){
			if(e.checkActive()){
				e.execute();
			}
		}
	}

	public void fire(Article first, Article second){
		for(Condition c : myConditions){
			Article firstTemp = c.getFirst();
			Article secondTemp = c.getSecond();
			c.setArticles(first, second);
			if(!c.isMet()){
				c.setArticles(firstTemp, secondTemp);
				return;
			}
			c.setArticles(firstTemp, secondTemp);
		}
		for(Executable e : myExecutables){
			Article tempActor = e.getMyActor();
			e.setMyActor(first);
			e.execute();
			e.setMyActor(tempActor);
		}
	}
	
	public void removeExecutable(Executable exec){
		myExecutables.remove(exec);
	}
	
	public void removeCondition (Condition cond){
		myConditions.remove(cond);
	}
	
}
