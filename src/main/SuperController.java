package main;

import action.controller.ActionController;
import gameengine.GameEngine;
import javafx.scene.Scene;
import level.manager.LevelManager;
import model.Model;
import model.controller.ModelController;
import observer.controller.ObserverController;
import startscreen.GameCreation;
import uibasics.UICore;


public class SuperController {
  private ActionController actionController;
  private ObserverController observerController;
  private GameEngine gameEngine;
  private ModelController modelController;
  private Model model;
  private GraphicHandler myGraphicHandler;
  private LevelManager myLevelManager;

  private UICore uiCore;

  public SuperController(GraphicHandler graphicHandler) {
    model = new Model();
    myGraphicHandler = graphicHandler;
    modelController = new ModelController(model);
    gameEngine = new GameEngine(modelController);
    actionController = new ActionController(gameEngine);
    uiCore = new UICore(myGraphicHandler, actionController, modelController);
    observerController = new ObserverController(model, uiCore.getUIStackPane());
    myLevelManager = new LevelManager(graphicHandler, uiCore, modelController);
  }

  public Scene init(GameCreation gameCreation) {
    Scene mainScene = uiCore.getScene();
    uiCore.initPanels(gameCreation);
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

}
