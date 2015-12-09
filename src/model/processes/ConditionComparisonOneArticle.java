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
}
