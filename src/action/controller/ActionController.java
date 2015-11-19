package action.controller;

import java.util.Observable;
import java.util.Observer;

import gameengine.GameEngine;
import resourcemanager.ResourceManager;

public class ActionController implements Observer {
	private GameEngine myGE;
	private ResourceManager resourceManager;
	
	public ActionController(GameEngine engine, ResourceManager resourceManager){
		myGE = engine;
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		myGE.update((String) arg1);	
	}

  public ResourceManager getResourceManager() {
    return resourceManager;
  }

  public void setResourceManager(ResourceManager resourceManager) {
    this.resourceManager = resourceManager;
  }

}
