package authoring.backend;

import model.article.Article;
import model.article.Player;
import model.controller.ModelController;

public class PlayerEditor extends Editor{
  public PlayerEditor(ModelController mc) {
    super(mc);
    // TODO Auto-generated constructor stub
  }

  private Article myPlayer;
  


  public Article getPlayer() {
    return myPlayer;
  }

  public void setPlayer(Article player) {
    this.myPlayer = player;
    super.myModelController.setCharacter(player);
  }

  public void addPlayer() {
    // TODO Auto-generated method stub
    
  }

  public void editPlayerImage() {
    // TODO Auto-generated method stub
    
  }

  public void editPlayerImageOrientation() {
    // TODO Auto-generated method stub
    
  }

  public void editPlayerLocation(double x, double y) {
    // TODO Auto-generated method stub
    
  }
}
