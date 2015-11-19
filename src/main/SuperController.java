package main;

import action.controller.ActionController;
import gameengine.GameEngine;
import javafx.scene.Scene;
import model.Model;
import model.controller.ModelController;
import observer.controller.ObserverController;
import resourcemanager.ResourceManager;
import startscreen.GameCreation;
import uibasics.UIBasics;
import uibasics.UICore;


import java.util.ResourceBundle;


public class SuperController {
  private ActionController actionController;
  private ObserverController observerController;
  private GameEngine gameEngine;
  private ModelController modelController;
  private Model model;
  private GraphicHandler myGraphicHandler;
  private ResourceManager resourceManager;

  private UICore uiCore;
  
  public SuperController(GraphicHandler graphicHandler){
    myGraphicHandler = graphicHandler;
    resourceManager = new ResourceManager();
    uiCore = new UICore(myGraphicHandler, resourceManager);
    modelController = new ModelController(model, resourceManager);
    gameEngine = new GameEngine(modelController, resourceManager);
    actionController = new ActionController(gameEngine, resourceManager);
    observerController = new ObserverController(model, uiCore.getUIBasics(), resourceManager);
  }

  public Scene init(GameCreation gameCreation){
      Scene mainScene = uiCore.getScene();
      return mainScene;
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

  public UICore getUICore() {
    return uiCore;
  }

  public void setUICore(UICore uICore) {
    uiCore = uICore;
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

  public ResourceManager getResourceManager() {
    return resourceManager;
  }

  public void setResourceManager(ResourceManager resourceManager) {
    this.resourceManager = resourceManager;
  }

}
