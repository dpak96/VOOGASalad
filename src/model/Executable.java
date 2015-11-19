package model;
import java.util.*;

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
}
