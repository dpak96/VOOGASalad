package usecases;

import javafx.StackPane;

public class UseCaseSwitchGames {
  
  UseCaseModelController modelController = new UseCaseModelController();
  GameData currentGame;
  StackPane screens;
  
  public UseCasesSwitchGames(StackPane stack, GameData currentGame){
    this.currentGame = currentGame;
    this.screens = stack;
  }
  
  public void switchGame(){
    saveCurrentGame(modelController, currentGame);
    screens.pop(2);
  }
  
  private saveCurrentGame(UseCaseModelController controller, GameData game){
    controller.save(game);
    if(game.score > game.highScore){
      game.highScore = game.score;
    }
  }
  
}
