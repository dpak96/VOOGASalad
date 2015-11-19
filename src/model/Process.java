package model;
import java.util.*;
import java.lang.reflect.Field;

public abstract class Process {
	
	protected String myName;

	public Process(Map<String, Object> parameters){
		Class<?> cls = this.getClass();
		while(!cls.toString().equals("class java.lang.Object")){
			for(Field field : this.getClass().getDeclaredFields()){
				try {
					field.set(this, parameters.get(field.getName()));
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			cls = cls.getSuperclass();
		}
	}

	public String getName(){
		return myName;
	}
}
