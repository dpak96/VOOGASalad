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

	
	public void removeArticle(Article article) {
		myArticles.remove(article);
		for(Rule r : myRules){
			removeArticleFromRule(r, article);
		}
		for(List<Rule> ruleList : myButtonMap.values()){
			for(Rule r : ruleList)removeArticleFromRule(r, article);
		}
	}
	public void remapButton(String button, List<Rule> rules) {
		myButtonMap.put(button, rules);
	}
	
	public List<Rule> getButtonRules(String button){
		return myButtonMap.get(button);
	}
	

}
