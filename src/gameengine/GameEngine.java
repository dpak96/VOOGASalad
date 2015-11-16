package gameengine;

import java.util.List;

import model.Article;
import model.Rule;
import model.controller.ModelController;

import voogasalad_SquirtleSquad.IGameEngine;
import voogasalad_SquirtleSquad.Input;

public class GameEngine implements IGameEngine {
	private List<Rule> myRules;
	public GameEngine(ModelController myModelController){
		myRules = myModelController.getRules();
	}
	
	@Override
	public void update(){
		// TODO Auto-generated method stub
		for(Rule r : myRules){
			r.update();
		}
	}

}