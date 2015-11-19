package observer.controller;

import model.Model;
import resourcemanager.ResourceManager;
import uibasics.UIBasics;
import uibasics.UIStackPane;


public class ObserverController {
  public ObserverController(Model modelMap, UIStackPane uiStack) {
    modelMap.addObserver(uiStack);
  }

}
