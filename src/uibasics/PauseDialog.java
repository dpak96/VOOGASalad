package uibasics;

import java.awt.Button;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import java.util.ResourceBundle;



public class PauseDialog extends Dialog{
	
	protected GridPane myGridPane;
	protected ButtonType myOKer;
	protected TextField myAuth;
	protected ComboBox<Integer> myRowsCols;
	protected ComboBox<String> myShape;
	protected ComboBox<String> myBoundary;
	protected ComboBox<String> myNeighbors;
	
	public PauseDialog(){
		this.setTitle("Pause");
		this.setResizable(true);
		ButtonType resume = new ButtonType("Resume",ButtonData.OK_DONE);
		ButtonType author = new ButtonType("Authoring Environment", ButtonData.OK_DONE);
		ButtonType main = new ButtonType("Return to Main", ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(resume);
		this.getDialogPane().getButtonTypes().add(author);
		this.getDialogPane().getButtonTypes().add(main);
		this.setResultConverter(new Callback<ButtonType,String>(){
			public String call(ButtonType ok){
				return ok.getText();
	}
		});
		}
	}
