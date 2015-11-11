package usecases;

import java.util.List;

import voogasalad_SquirtleSquad.Article;
import voogasalad_SquirtleSquad.IGameEngine;
import voogasalad_SquirtleSquad.Input;
import voogasalad_SquirtleSquad.Rule;

public class UseCaseGameEngine implements IGameEngine{
	private UseCaseModelController controller;
	
	public UseCaseGameEngine (UseCaseModelController modelController){
		controller = modelController;
	}

	@Override
	public void update(List<Input> actions) {
		for(Input a: actions){
			a.run();
		}
		List<Rule> rules = controller.getRules();
		List<Article> articles = controller.getArticles();
		for(Rule r: rules){
			r.apply(articles);
		}
	}

}
