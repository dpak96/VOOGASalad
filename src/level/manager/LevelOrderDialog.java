package level.manager;

import javafx.collections.FXCollections;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import startscreen.GameCreation;

public class LevelOrderDialog extends Dialog{
	protected GridPane myGridPane;
	protected ButtonType myOKer;
	protected Map<ComboBox<Integer>, String> myOrder;
	
	public LevelOrderDialog(GameCreation gameCreation){
		myOrder = new HashMap<ComboBox<Integer>, String>();
		this.setTitle("Change Level Order");
		this.setResizable(true);
		myGridPane = new GridPane();
		for(int i:gameCreation.getLevelMap().keySet()){
			Label levelOrder = new Label(gameCreation.getLevelMap().get(i));
			ComboBox<Integer> num = makeComboBox(gameCreation.getLevelMap().size());
			num.setValue(i);
			myOrder.put(num, levelOrder.getText());
			myGridPane.add(levelOrder, 1, i);
			myGridPane.add(num, 2, i);
		}
		myOKer = new ButtonType("OK",ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(myOKer);
		this.getDialogPane().setContent(myGridPane);
		this.setResultConverter(new Callback<ButtonType,GameCreation>(){
			public GameCreation call(ButtonType ok){
				if(ok == myOKer){
					HashMap<Integer,String> saver = new HashMap<Integer,String>(gameCreation.getLevelMap());
					gameCreation.getLevelMap().clear();
					for(ComboBox<Integer> i: myOrder.keySet()){
						if(gameCreation.getLevelMap().keySet().contains(i.getValue())){
							Alert dup = new Alert(AlertType.CONFIRMATION,"Please retry, and do not place two levels at the same order",ButtonType.OK);
							dup.showAndWait();
							gameCreation.setLevelMap(saver);
							return gameCreation;						
						}
						gameCreation.getLevelMap().put(i.getValue(), myOrder.get(i));
					}
					return gameCreation;
				}
				return gameCreation;
	}
		});
		}
	protected ComboBox<Integer> makeComboBox(int size){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i<size; i++){
			temp.add(i+1);
		}
		ComboBox<Integer> perc = new ComboBox<Integer>(FXCollections.observableList(temp));
		return perc;
	}
}
