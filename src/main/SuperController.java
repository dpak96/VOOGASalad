package main;

import action.controller.ActionController;
import gameengine.GameEngine;
import model.controller.ModelController;
import observer.controller.ObserverController;
import uibasics.UIBasics;


public class SuperController {
  private UIBasics uibasics;
  private ActionController actionController;
  private ObserverController observerController;
  private GameEngine gameEngine;
  private ModelController modelController;

  public ModelController getModelController() {
    return modelController;
  }

  public void setModelController(ModelController modelController) {
    this.modelController = modelController;
  }

  public GameEngine getGameEngine() {
    return gameEngine;
  }

  public void setGameEngine(GameEngine gameEngine) {
    this.gameEngine = gameEngine;
  }

  public UIBasics getUIBasics() {
    return uibasics;
  }

  public void setUIBasics(UIBasics uIBasics) {
    uibasics = uIBasics;
  }

  public ObserverController getObserverController() {
    return observerController;
  }

  public void setObserverController(ObserverController observerController) {
    this.observerController = observerController;
  }

  public ActionController getActionController() {
    return actionController;
  }

  public void setActionController(ActionController actionController) {
    this.actionController = actionController;
  }

}
