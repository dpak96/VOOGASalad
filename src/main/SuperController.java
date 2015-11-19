package main;

import action.controller.ActionController;
import gameengine.GameEngine;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import model.controller.ModelController;
import observer.controller.ObserverController;
import resourcemanager.ResourceManager;
import startscreen.GameCreation;
import uibasics.Setup;
import uibasics.UIBasics;
import java.util.ResourceBundle;


public class SuperController {
  private UIBasics uibasics;
  private ActionController actionController;
  private ObserverController observerController;
  private GameEngine gameEngine;
  private ModelController modelController;
  private Model model;
  private GraphicHandler myGraphicHandler;
  private ResourceManager resourceManager;

  public SuperController(GraphicHandler graphicHandler) {
    myGraphicHandler = graphicHandler;
    resourceManager = new ResourceManager();

    uibasics = new UIBasics();
    modelController = new ModelController(model, resourceManager);
    gameEngine = new GameEngine(modelController, resourceManager);
    actionController = new ActionController(gameEngine, resourceManager);
    observerController = new ObserverController(model, uibasics, resourceManager);
  }

  public Scene init(GameCreation gameCreation) {
    ResourceBundle resource = ResourceBundle.getBundle("properties/english");
    Scene mainScene = new Setup(myGraphicHandler, resource).getScene();
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

  public ResourceManager getResourceManager() {
    return resourceManager;
  }

  public void setResourceManager(ResourceManager resourceManager) {
    this.resourceManager = resourceManager;
  }

}
