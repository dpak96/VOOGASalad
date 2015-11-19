package action.controller;

import java.util.Observable;
import java.util.Observer;

import gameengine.GameEngine;
import resourcemanager.ResourceManager;

public class ActionController{
	private GameEngine myGE;
	
	public ActionController(GameEngine engine){
		myGE = engine;
		
	}

	public void update(String arg1) {
		myGE.update(arg1);
	}

}
