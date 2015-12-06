package model.processes;
import java.util.*;
import model.article.*;

public abstract class Condition extends Process{

	protected String myName;
	protected Article myFirst;
	protected Article mySecond;
	
	public Condition(Map<String, Object> parameters){
		super(parameters);
	}
	
	public Condition(String name){
		super(name);
	}
	
	public abstract boolean isMet();
	
	public void setArticles(Article first, Article second){
		myFirst = first;
		mySecond = second;
	}
	
	public Article getFirst(){
		return myFirst;
	}
	
	public Article getSecond(){
		return mySecond;
	}
}
