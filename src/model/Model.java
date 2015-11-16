package model;
import java.util.*;
import gameengine.Rule;
import gameengine.Article;

public class Model {
	
	private List<Rule> myRules;
	//private Map<String, Action> myButtonMap;
	private List<Article> myArticles;
	
	public List<Rule> getRules(){
		return myRules;
	}
	public List<Article> getArticles(){
		return myArticles;
	}

}
