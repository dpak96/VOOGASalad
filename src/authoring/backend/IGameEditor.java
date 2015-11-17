package authoring.backend;

import javafx.scene.image.Image;
import model.Rule;


public interface IGameEditor {
  public void setSplash(Image img);

  public void editKeyPress(Rule rule);
  
  public void addKeyPress(String key, Rule rule);
  
  public void addNewLevel();
  
  public void loadLevel();

}
