package main;

import gameengine.GameEngine;
import model.controller.ModelController;


public class SuperController {
  // TODO: UI BASICS?
  // TODO: Action Controller
  // TODO: Observer Controller
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

}
