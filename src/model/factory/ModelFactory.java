package model.factory;
import java.lang.reflect.*;
import java.util.*;

import model.*;

public class ModelFactory {
	
	public Article createArticle(String fileName, double x, double y, boolean direction){
		try {
			Class<?> cls = Class.forName("model.Article");
			Class [] type = {String.class, Double.class, Double.class, Boolean.class};
			Constructor<?> cons = cls.getConstructors()[0];
			Object[] obj = {fileName, x, y, direction};
			Article test = (Article) cons.newInstance(obj);
			return test;
		} catch (ClassNotFoundException e) {
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
	
	public Article createArticle(String fileName, double x, double y, boolean direction, List<Rule> rules){
		Article temp = createArticle(fileName, x, y, direction);
		//temp.addAllRules(rules);
		return temp;
	}
	
	public Rule createRule(String name, double value){
		try {
			Class<?> cls = Class.forName(name);
			Class[] type = { String.class, Double.class };
			Constructor<?> cons = cls.getConstructors()[0];
			Object[] obj = { "test", value };
			Rule test = (Rule) cons.newInstance(obj);
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
	
	public Rule createRule(String name, double value, List<Article> articles){
		Rule temp = createRule(name,value);
		temp.addAllDependencies(articles);
		return temp;
	}
	
	public static void main(String args[]){
		ModelFactory m = new ModelFactory();
		RuleGravity test = (RuleGravity) m.createRule("model.RuleGravity", 240.0);
		ArrayList<Rule> ruleList = new ArrayList<Rule>();
		ruleList.add(test);
		Article testArticle = m.createArticle("test", 1.0, 2.0, false, ruleList);
		//System.out.println(testArticle.getRules().get(0).toString());
	}
}
 