package model.processes;
import java.util.*;

import model.article.Article;

public abstract class Executable extends Process{

	protected Article myActor;
	
	public Executable(Map<String, Object> parameters){
		super(parameters);
	}
	
	public Executable(String name, Article actor){
		super(name);
		myActor = actor;
	}
	public abstract void execute();
	
	public void setMyActor(Article article){
		myActor = article;
	}
}
