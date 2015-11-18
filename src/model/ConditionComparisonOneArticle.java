 package model;
import java.lang.reflect.*;

public class ConditionComparisonOneArticle extends Condition{
	
	private Article myFirst;
	private String myFirstVariable;
	private double myCompareValue;
	private String myComparison;
	
	
	public ConditionComparisonOneArticle(String name, Article first, String firstVariable,
			double compareValue, String comparison) {
		super(name);
		myFirst = first;
		myFirstVariable = firstVariable;
		myCompareValue = compareValue;
		myComparison = comparison;
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
	
	private class Maths{
		public boolean Equals(double a, double b){
			return a == b;
		}
		public boolean LessThan(double a, double b){
			return a < b;
		}
		public boolean GreaterThan(double a, double b){
			return a > b;
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
