package authoring.backend;

import javafx.scene.image.Image;
import model.Game;
import model.Rule;


public class GameEditor implements IGameEditor{
  private Game game;
  
  public GameEditor(){
    
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  @Override
  public void setSplash(Image img) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void editKeyPress(Rule rule) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void addKeyPress(String key, Rule rule) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void addNewLevel() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void loadLevel() {
    // TODO Auto-generated method stub
    
  }
  
  
}
