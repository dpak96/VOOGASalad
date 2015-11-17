package model;
import java.util.*;

public class Model {
	
	private List<Rule> myRules;
	private Map<String, List<Rule>> myButtonMap;
	private List<Article> myArticles;
	private Article myViewpoint;
	private Article myCharacter;
	
	public List<Rule> getRules(){
		return myRules;
	}
	public List<Article> getArticles(){
		return myArticles;
	}
	
	public Article getViewpoint(){
		return myViewpoint;
	}
	
	public Article getCharacter(){
		return myCharacter;
	}

	public void removeRuleFromArticle(Article article, Rule rule){
		article.getRules().remove(rule);
	}

	public void remapButton(String button, List<Rule> rules) {
		myButtonMap.put(button, rules);
	}
	
	public List<Rule> getButtonRules(String button){
		return myButtonMap.get(button);
	}
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		
	}
	public void removeArticle(Article article) {
		// TODO Auto-generated method stub
		
	}
	

}
