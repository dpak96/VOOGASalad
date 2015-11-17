package authoring.backend;

public interface IPlayerEditor {
  public void addPlayer();
  
  public void editPlayerLocation(double x, double y);
  
  public void editPlayerImage();
  
  public void editPlayerImageOrientation();
}
