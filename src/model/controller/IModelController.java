package model.controller;

import model.Article;
import model.Rule;

import java.util.List;

public interface IModelController {
	/**
	 * Gets the rules from the model and returns them 
	 * @return
	 */
	public List<Rule> getRules();
	
	/**
	 * Gets the different objects from the model and returns them
	 * @return
	 */
	public List<Article> getArticles();
	
	/**
	 * Adds a new rule to the model
	 */
	public void addRule(Rule rule);
	
	/**
	 * Removes a given rule from the model
	 */
	public void removeRule(Rule rule);
	
	/**
	 * Adds a new game object to the model
	 */
	public void addArticle(Article article);
	
	/**
	 * Removes a game object to the model
	 */
	public void removeArticle(Article article);

	public void removeArticleFromRule(Rule rule, Article article);

	public List<Rule> getButtonRules(String button);

	public void remapButton(String button, List<Rule> rules);


	
}
