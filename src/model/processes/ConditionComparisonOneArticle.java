 package model.processes;
import java.lang.reflect.*;
import java.util.Map;

import model.Maths;
import model.article.Article;

public class ConditionComparisonOneArticle extends Condition{
	
	protected String myFirstVariable;
	protected double myCompareValue;
	protected String myComparison;
	
	
	public ConditionComparisonOneArticle(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		System.out.println(myFirst.getClass());
		try{
			Method method1 = myFirst.getClass().getMethod("get"+myFirstVariable);
			double firstValue = (double) method1.invoke(myFirst);
			Maths m = new Maths();
			Method compare = m.getClass().getMethod(myComparison, double.class, double.class);
			return (boolean) compare.invoke(m, firstValue, myCompareValue);
		}
		catch(Exception e){
			return false;
		}
	}
	
	/*
	public static void main(String[] args){
		Article a = new Article("a", 0, 0, false);
		Article b = new Article("b", 0, 1, false);
		
		ConditionComparison c = new ConditionComparison("abc", a, "Y", b, "Y", "LessThan");
		System.out.println(c.isMet());
	}
	*/

}
