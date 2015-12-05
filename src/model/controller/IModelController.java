package model.controller;

import model.Event;
import model.article.Article;

import java.util.List;

public interface IModelController {
	/**
	 * Gets the rules from the model and returns them 
	 * @return
	 */
	public List<Event> getEvents();
	
	/**
	 * Gets the different objects from the model and returns them
	 * @return
	 */
	public List<Article> getArticles();
		
	/**
	 * Adds a new game object to the model
	 */
	public void addArticle(Article article);
	
	/**
	 * Removes a game object to the model
	 */
	public void removeArticle(Article article);

	public List<Event> getButtonEvents(String button);

	public void remapButton(String button, List<Event> events);

	
}
