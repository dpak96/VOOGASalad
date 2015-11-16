package gameengine;

import java.util.Arrays;
import java.util.List;
import model.controller.ModelController;

import voogasalad_SquirtleSquad.IGameEngine;
import voogasalad_SquirtleSquad.Input;
import model.Article;

public class GameEngine implements IGameEngine {

	@Override
	public void update(List<String> actions) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String args[]) {
		Article one = new Article("GoombaRefinedAgain.png");
//		System.out.println(Arrays.deepToString((one.getBitMap().getByteArray())));
		for(int[] a: one.getBitMap().getByteArray()) {
			System.out.println(Arrays.toString(a));
		}
		//CollisionManager temp = new CollisionManager();
		//System.out.println(temp.didCollide(one, two));
	}
	

}