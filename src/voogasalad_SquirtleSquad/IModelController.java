package voogasalad_SquirtleSquad;

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
	public void setRules(/**[AE FILL IN WHAT YOU INPUT]**/);
	
	/**
	 * Removes a given rule from the model
	 */
	public void removeRule(/**AE**/);
	
	/**
	 * Adds a new game object to the model
	 */
	public void addArticle(/**[AE FILL IN WHAT YOU INPUT]**/);
	
	/**
	 * Removes a game object to the model
	 */
	public void removeArticle(/**[AE]**/);
	
}
