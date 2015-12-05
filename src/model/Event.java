package model;
import java.util.*;

import model.article.Article;
import model.conditions.Condition;
import model.executables.Executable;

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
	
	public String getName(){
		return myName;
	}
	
	public void fire(){
		for(Condition c : myConditions){
			if(!c.isMet()) return;
		}
		for(Executable e : myExecutables){
			e.execute();
		}
	}

	
	public void removeExecutable(Executable exec){
		myExecutables.remove(exec);
	}
	
	public void removeCondition (Condition cond){
		myConditions.remove(cond);
	}
	
	public void setExecutableArticle(Article article){
		for(Executable e : myExecutables){
			e.setMyActor(article);
		}
	}
	
}
