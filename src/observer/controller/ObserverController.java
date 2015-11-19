package observer.controller;

import model.Model;
import resourcemanager.ResourceManager;
import uibasics.UIBasics;


public class ObserverController {
  public ObserverController(Model modelMap, UIBasics uiBasics) {
    modelMap.addObserver(uiBasics);
  }

}
