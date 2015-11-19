package observer.controller;

import model.Model;
import resourcemanager.ResourceManager;
import uibasics.UIBasics;

public class ObserverController {
  private ResourceManager resourceManager;
  
	public ObserverController(Model modelMap, UIBasics uiBasics, ResourceManager rm) {
		//modelMap.addObserver(uiBasics); temporarily off
	  setResourceManager(rm);
	}

  public ResourceManager getResourceManager() {
    return resourceManager;
  }

  public void setResourceManager(ResourceManager resourceManager) {
    this.resourceManager = resourceManager;
  }

}
