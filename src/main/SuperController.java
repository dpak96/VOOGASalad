package main;

import gameengine.GameEngine;
import model.controller.ModelController;
import observer.controller.ObserverController;
import uibasics.UIBasics;


public class SuperController {
  private UIBasics UIBasics;
  // TODO: Action Controller
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
    return UIBasics;
  }

  public void setUIBasics(UIBasics uIBasics) {
    UIBasics = uIBasics;
  }

}
