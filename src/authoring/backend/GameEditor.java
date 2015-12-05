package authoring.backend;

import javafx.scene.image.Image;
import model.Game;
import model.controller.ModelController;


public class GameEditor extends Editor{
  public GameEditor(ModelController mc) {
    super(mc);
    // TODO Auto-generated constructor stub
  }

  private Game game;
  

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public void setSplash(Image img) {
    // TODO Auto-generated method stub
    
  }



  public void addNewLevel() {
    // TODO Auto-generated method stub
    
  }

  public void loadLevel() {
    // TODO Auto-generated method stub
    
  }
  
  public void setBackgroundImage(String name){
    myModelController.setBackgroundImage(name);
  }
  
  
}
