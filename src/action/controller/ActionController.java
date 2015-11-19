package action.controller;

import java.util.Observable;
import java.util.Observer;

import gameengine.GameEngine;
import resourcemanager.ResourceManager;

public class ActionController{
	private GameEngine myGE;
	private ResourceManager resourceManager;
	
	public ActionController(GameEngine engine, ResourceManager resourceManager){
		myGE = engine;
		
	}

	public void update(String arg1) {
		myGE.update(arg1);
	}

  public ResourceManager getResourceManager() {
    return resourceManager;
  }

  public void setResourceManager(ResourceManager resourceManager) {
    this.resourceManager = resourceManager;
  }

}
