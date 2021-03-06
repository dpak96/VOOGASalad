package voogasalad_SquirtleSquad;

import java.util.List;

import model.article.Article;

public interface IModelController {

	
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
