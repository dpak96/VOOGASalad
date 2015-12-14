package main;

import action.controller.ActionController;
import gameengine.GameEngine;
import javafx.scene.Scene;
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
  
  private UICore uiCore;

  public SuperController(GraphicHandler graphicHandler) {
	  myGraphicHandler = graphicHandler;
	  newEverything();
  }

  private void newEverything() {
    model = new Model();
    modelController = new ModelController(model);
    gameEngine = new GameEngine(modelController);
    actionController = new ActionController(gameEngine);
    uiCore = new UICore(myGraphicHandler, actionController, modelController);
    observerController = new ObserverController(model, uiCore.getUIStackPane());
  }
  
  public Scene init(GameCreation gameCreation, String levelFile) {
    Scene mainScene = uiCore.getScene();
    uiCore.initPanels(gameCreation);
    uiCore.getMenu().loadGame(gameCreation, levelFile);
    modelController.makeLevelManager(gameCreation);
    modelController.makeXMLUtility();
    return mainScene;
  }
  
  public Scene initNew(GameCreation gameCreation, Scene oldScene){
	  	if (uiCore.getMenu().saveGameCreation(gameCreation)) {
	  		modelController.makeNewModel();
	  		modelController.makeLevelManager(gameCreation);
	  		Scene mainScene = uiCore.getScene();
	  		uiCore.initPanels(gameCreation);
	  		return mainScene;
	  	}
	    return oldScene;
  }
  
  public Scene initNewLevel(GameCreation gameCreation) {
	  modelController.makeNewModel();
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
  
  public void reorderLevels(){
	  getUICore().getMenu().reorderGame();
  }
  
  public void deleteLevels() {
	  getUICore().getMenu().deleteGame();
  }

}
