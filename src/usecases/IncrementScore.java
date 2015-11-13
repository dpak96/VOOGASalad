package usecases;

//import voogaSalad_SquirtleSquad.Game;

public class IncrementScore {
  
  private double score;
  
//  public IncrementScore(Game currentGame){
//    this.score = currentGame.score();
//  }
  
  public void addScore(double inc){
    score += inc;
  }

}
