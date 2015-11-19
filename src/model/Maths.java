package model;

public class Maths {
	/**
	 * This class was created to be able to do math operations with reflection
	 * it is mainly used in ConditionComparisonOneArticle
	 * and in ConditionComparisonTwoArticles
	 */
	
	public boolean Equals(double a, double b){
		return a == b;
	}
	public boolean LessThan(double a, double b){
		return a < b;
	}
	public boolean GreaterThan(double a, double b){
		return a > b;
	}
	public boolean NotEquals(double a, double b){
		return a != b;
	}
}
