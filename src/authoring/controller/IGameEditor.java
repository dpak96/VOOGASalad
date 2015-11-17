package authoring.controller;

import javafx.scene.image.Image;


public interface IGameEditor {
  public void setSplash(Image img);

  public void loadLevel();

  public void editKeyPress();
}
