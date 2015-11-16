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
	public void addRule(Rule rule) {
		myRules.add(rule);
	}
	public void removeRule(Rule rule) {
		myRules.remove(rule);
	}
	public void removeArticleFromRule(Rule rule, Article article) {
		rule.removeArticle(article);
	}
	public void addArticle(Article article) {
		myArticles.add(article);
		
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
