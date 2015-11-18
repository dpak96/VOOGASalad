package main;

import action.controller.ActionController;
import gameengine.GameEngine;
import model.Model;
import model.controller.ModelController;
import observer.controller.ObserverController;
import uibasics.UIBasics;


public class SuperController {
  private UIBasics uibasics;
  private ActionController actionController;
  private ObserverController observerController;
  private GameEngine gameEngine;
  private ModelController modelController;
  private Model model;
  
  public SuperController(){
    uibasics = new UIBasics();
    modelController = new ModelController(model);
    gameEngine = new GameEngine(modelController);
    actionController = new ActionController(gameEngine);
    observerController = new ObserverController(model, uibasics);
  }

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

  public Model getModel() {
    return model;
  }

  public void setModel(Model model) {
    this.model = model;
  }

}
