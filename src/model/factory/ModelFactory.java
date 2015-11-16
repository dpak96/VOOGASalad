package model.factory;
import java.lang.reflect.*;
import java.util.*;

import model.*;

public class ModelFactory {
	
	public Object createArticle(String name){
		return null;
	}
	
	public Object createRule(String name, double value){
		try {
			Class<?> cls = Class.forName(name);
			Class[] type = { String.class, Double.class };
			
			Constructor cons = cls.getConstructors()[0];
			Object[] obj = { "test", value };
			Object test = cons.newInstance(obj);
			return test;
		            //for (int i = 0; i < fieldlist.length; i++) {
		            //   Field fld = fieldlist[i];
		            //   System.out.println("name = " + fld.getName());
		            //   System.out.println("decl class = " +  fld.getDeclaringClass());
		            //   System.out.println("type  = " + fld.getType());
		            //   int mod = fld.getModifiers();
		            //   System.out.println("modifiers = " +  Modifier.toString(mod));
		            //   System.out.println("-----");
		            // }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String args[]){
		ModelFactory m = new ModelFactory();
		RuleGravity test = (RuleGravity) m.createRule("model.RuleGravity", 240.0);
		System.out.println(test.getYAcceleration());
	}
}
 