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
		temp.addAllEvents(events);
		return temp;
	}

	public Map<String, Class> getParameters(String className){
		Class<?> cls;
		try {
			cls = Class.forName(className);
			Constructor<?> cons = cls.getConstructor();
			Process temp = (Process) cons.newInstance();
			//return temp.getParameters();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Event creatEvent(String name, List<Condition> conditions, List<Executable> executables){
		try {
			Class<?> cls = Class.forName(name);
			Constructor<?> cons = cls.getConstructors()[0];
			//Object[] obj = new Object[Replace with getSize from dataObject];
			/*for each piece of data in the object, add it to the obj array*/
			Object[] obj = {/* Fill with data from object*/};
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

	public Condition createCondition(String name, String cond, FactoryData data){
		try {
			Class<?> cls = Class.forName(name);
			Constructor<?> trialCons = cls.getConstructor(Map.class);
			Constructor<?> cons = cls.getConstructors()[0];
			//Object[] obj = new Object[Replace with getSize from dataObject];
			/*for each piece of data in the object, add it to the obj array*/
			Object[] obj = {/* Fill with data from object*/};
			Condition test = (Condition) trialCons.newInstance(/*data.getMap()*/);
			return test;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return null;
	}


	public Executable createExecutable(String name, double value, Article actor, FactoryData data){
		try {
			HashMap<String, Class> asdf = new HashMap<String, Class>();
			asdf.put("poop", String.class);
			Class<?> cls = Class.forName(name);
			Constructor<?> cons = cls.getConstructors()[0];
			//Object[] obj = new Object[Replace with getSize from dataObject];
			/*for each piece of data in the object, add it to the obj array*/
			Object[] obj = data.getExecutableArray();
			Executable test = (Executable) cons.newInstance(obj);
			return test;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}
