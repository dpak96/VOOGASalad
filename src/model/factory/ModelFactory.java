package model.factory;
import java.lang.reflect.*;
import java.util.*;

import authoring.backend.*;
import model.*;
import model.Executable;

public class ModelFactory {

	public Article createArticle(String fileName, double x, double y, boolean direction){
		try {
			Class<?> cls = Class.forName("model.Article");
			Class [] type = {String.class, Double.class, Double.class, Boolean.class};
			Constructor<?> cons = cls.getConstructors()[0];
			Object[] obj = {fileName, x, y, direction};
			Article test = (Article) cons.newInstance(obj);
			return test;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Article createArticle(String fileName, double x, double y, boolean direction, List<Event> events){
		Article temp = createArticle(fileName, x, y, direction);
		for(Event event : events){
			event.setExecutableArticle(temp);
		}
		return temp;
	}

	public Map<String, Class<?>> getParameters(String className){
		Class<?> cls = String.class;
		try {
			cls = Class.forName(className);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Class<?>> parameterMap = new HashMap<String, Class<?>>();
		while(!cls.toString().equals("class java.lang.Object")){
			for(Field field : cls.getDeclaredFields()) {
			    parameterMap.put(field.getName(), field.getType());
			}
			cls = cls.getSuperclass();
		}
		return parameterMap;
	}

	public Event createEvent(String name, List<Condition> conditions, List<Executable> executables){
		try {
			Class<?> cls = Class.forName("model.Event");
			Constructor<?> cons = cls.getConstructors()[0];
			Object[] obj = {name, conditions, executables};
			Event test = (Event) cons.newInstance(obj);
			test.addAllConditions(conditions);
			test.addAllExecutables(executables);
			return test;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Condition createCondition(String name, Map<String, Object> data){
		try {
			Class<?> cls = Class.forName(name);
			Constructor<?> trialCons = cls.getConstructor(Map.class);
			Constructor<?> cons = cls.getConstructor(Map.class);
			Condition test = (Condition) trialCons.newInstance(data);
			return test;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Executable createExecutable(String name, Map<String, Object> data){
		try {
			Class<?> cls = Class.forName(name);
			Constructor<?> cons = cls.getConstructor(Map.class);
			Executable test = (Executable) cons.newInstance(data);
			return test;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
