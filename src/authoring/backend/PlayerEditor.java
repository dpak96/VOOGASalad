package authoring.backend;

import model.Player;

public class PlayerEditor implements IPlayerEditor {
  private Player player;
  
  public PlayerEditor(){
    
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  @Override
  public void addPlayer() {
    // TODO Auto-generated method stub
    
  }
}
