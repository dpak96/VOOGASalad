package action.controller;

import java.util.Observable;
import java.util.Observer;

import gameengine.GameEngine;

public class ActionController implements Observer {
	private GameEngine myGE;
	
	public ActionController(GameEngine ge){
		myGE = ge;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		myGE.update((String) arg1);	
	}

}
