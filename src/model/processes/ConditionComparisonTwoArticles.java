 package model.processes;
import java.lang.reflect.*;
import java.util.Map;

import model.Maths;
import model.article.Article;
public class ConditionComparisonTwoArticles extends Condition{
	
	protected String myFirstVariable;
	protected String mySecondVariable;
	protected String myComparison;
	
	
	
	public ConditionComparisonTwoArticles(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		try{
			Method method1 = myFirst.getClass().getMethod("get"+myFirstVariable);
			Method method2 = mySecond.getClass().getMethod("get"+mySecondVariable);
			double firstValue = (double) method1.invoke(myFirst);
			double secondValue = (double) method2.invoke(mySecond);
			
			Maths m = new Maths();
			Method compare = m.getClass().getMethod(myComparison, double.class, double.class);
			return (boolean) compare.invoke(m, firstValue, secondValue);
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
	}
	*/

}
