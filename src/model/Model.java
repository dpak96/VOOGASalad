package model;
import java.util.*;

public class Model {
	
	private List<Rule> myRules;
	private Map<String, List<Rule>> myButtonMap;
	private List<Article> myArticles;
	
	public List<Rule> getRules(){
		return myRules;
	}
	public List<Article> getArticles(){
		return myArticles;
	}

}
