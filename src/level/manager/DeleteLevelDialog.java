package level.manager;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import startscreen.GameCreation;

@SuppressWarnings("rawtypes")
public class DeleteLevelDialog extends Dialog {

	private Map<Integer, String> myLevels;
	private Map<Integer, CheckBox> myResults;
	private GameCreation myGame;
	private ButtonType myButton;
	
	public DeleteLevelDialog(GameCreation game) {
		this.setTitle("Delete Levels");
		this.setResizable(true);
		myResults = new HashMap<Integer, CheckBox>();
		myGame = game;
		myButton = new ButtonType("OK",ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(myButton);
		init();
	}
	
	private void init() {
		if (!myGame.getLevelMap().isEmpty()){
			myLevels = myGame.getLevelMap();
			makeMenu();
		} else {
			this.setContentText("There are no levels to delete.");
			delete(false);
		}
	}
	
	private void makeMenu() {
		GridPane grid = new GridPane();
		for(int i:myLevels.keySet()){
			Label levelOrder = new Label(myLevels.get(i));
			CheckBox cb = new CheckBox();
			myResults.put(i,cb);
			grid.add(levelOrder, 1, i);
			grid.add(cb, 2, i);
		}
		this.getDialogPane().setContent(grid);
		delete(true);
	}
	
	@SuppressWarnings("unchecked")
	private void delete(boolean areLevels) {
		this.setResultConverter(new Callback<ButtonType,GameCreation>(){
			public GameCreation call(ButtonType ok){
				if((ok == myButton) && areLevels){
					HashMap<Integer,String> temp = new HashMap<Integer,String>();
					for (Map.Entry<Integer, String> entry : myLevels.entrySet()) {
						if (!myResults.get(entry.getKey()).isSelected()) {
							temp.put(entry.getKey(), entry.getValue());
						}
					}
					myGame.setLevelMap(temp);
				}
				return myGame;
			}
		});
	}
}
