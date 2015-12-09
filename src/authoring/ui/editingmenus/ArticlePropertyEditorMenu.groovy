package authoring.ui.editingmenus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map
import javax.swing.plaf.basic.ComboPopup;
import action.controller.ActionController;
import authoring.controller.AuthoringController;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import model.article.Article;
import resourcemanager.ResourceManager;


public class ArticlePropertyEditorMenu extends AuthoringMenu {


	private HashMap<String, TextField> textFieldPropertyMap;
	private HashMap<String, ComboBox> comboBoxPropertyMap;
	private Article myArticleToEdit;
	private ComboBoxImageRendering imageBoxHandler=new ComboBoxImageRendering();
	private CheckBox myCharSaver = new CheckBox();

	public ArticlePropertyEditorMenu(String title,
	Article selectedArticle,
	AuthoringController myController) {
		super(title, myController);
		myArticleToEdit = selectedArticle;
		super.showMenu(400,300);
	}

	protected void populateMenu(GridPane menuGrid) {
		textFieldPropertyMap = new HashMap<String, TextField>();
		comboBoxPropertyMap = new HashMap<String, ComboBox>();
		int rowIndex = 1;

		super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Name: ");
		textFieldPropertyMap.put("NAME", (super.componentAdder.makeField(menuGrid, 2, rowIndex++)));

		super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "X-Velocity: ");
		textFieldPropertyMap.put("XVELOCITY",
				(super.componentAdder.makeField(menuGrid, 2, rowIndex++)));

		super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Y-Velocity: ");
		textFieldPropertyMap.put("YVELOCITY",
				(super.componentAdder.makeField(menuGrid, 2, rowIndex++)));

		super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Image: ");
		comboBoxPropertyMap.put("IMAGE",
				super.componentAdder.makeComboBox(menuGrid, 2, rowIndex++));

		//		super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Repeat?: ");
		//		CheckBox repeat = new CheckBox();
		//		menuGrid.add(repeat, 2, rowIndex++);
		//
		//		if (repeat.isSelected()) {
		//			super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Probability: ");
		//			textFieldPropertyMap.put("Probability",
		//					(super.componentAdder.makeField(menuGrid, 2, rowIndex++)));
		//		}

		super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Action on Collision: ");
		comboBoxPropertyMap.put("COLLISION",
				super.componentAdder.makeComboBox(menuGrid, 2, rowIndex++));


		super.componentAdder.makeLabel(menuGrid,1,rowIndex,"Save as Main Character?: ");
		menuGrid.add(myCharSaver, 2, rowIndex++);
                
		super.componentAdder.makeLabel(menuGrid,1,rowIndex, "Lives: ");
		textFieldPropertyMap.put("LIVES", super.componentAdder.makeField(menuGrid, 2,rowIndex++));

		super.componentAdder.makeLabel(menuGrid,1,rowIndex, "Initial Health: ");
		textFieldPropertyMap.put("HEALTH", super.componentAdder.makeField(menuGrid, 2,rowIndex++));

		super.componentAdder.makeLabel(menuGrid,1,rowIndex, "Initial Score: ");
		textFieldPropertyMap.put("SCORE", super.componentAdder.makeField(menuGrid, 2,rowIndex++));

		comboBoxPropertyMap.get("COLLISION").getItems().addAll(super.myController.callEvent("OtherController","getCollisionTypes"));
		imageBoxHandler.addImages(comboBoxPropertyMap.get("IMAGE"));
		initializeFieldValues();
       
	}


	public void initializeFieldValues(){
		this.textFieldPropertyMap.get("XVELOCITY").setText(Double.toString(myArticleToEdit.getXVelocity()));
		this.textFieldPropertyMap.get("YVELOCITY").setText(Double.toString(myArticleToEdit.getYVelocity()));
		this.comboBoxPropertyMap.get("IMAGE").setValue(myArticleToEdit.getImageFile());
		this.comboBoxPropertyMap.get("COLLISION").setValue(myArticleToEdit.getCollisionType());
	}
	@Override
	public void executeYourMenuFunction() {
		System.out.println(myArticleToEdit == null);

		super.myController.getEditor().getSubEditor("ArticleEditor")
				.editProperty("setXVelocity", Double.parseDouble(textFieldPropertyMap.get("XVELOCITY")
				.getText()),
				myArticleToEdit);
		super.myController.getEditor().getSubEditor("ArticleEditor")
				.editProperty("setYVelocity", Double.parseDouble(textFieldPropertyMap.get("YVELOCITY")
				.getText()),
				myArticleToEdit);
		super.myController.getEditor().getSubEditor("ArticleEditor")
				.editProperty("setImageFile",comboBoxPropertyMap.get("IMAGE").getValue().toString(),
				myArticleToEdit);

		super.myController.getEditor().getSubEditor("ArticleEditor")
				.editProperty("setCollisionType",comboBoxPropertyMap.get("COLLISION").getValue().toString(),myArticleToEdit);
		// Pass on the edits to the thing being edited
		if(myCharSaver.isSelected()){
			myArticleToEdit.setLife(Integer.parseInt(textFieldPropertyMap.get("LIVES").getText()));
			myArticleToEdit.setScore(Integer.parseInt(textFieldPropertyMap.get("SCORE").getText()));
			myArticleToEdit.setMaxHealth(Integer.parseInt(textFieldPropertyMap.get("HEALTH").getText()));
			myArticleToEdit.setHealth(Integer.parseInt(textFieldPropertyMap.get("HEALTH").getText()));
			super.myController.getEditor().getSubEditor("PlayerEditor").setPlayer(myArticleToEdit);
		}
	}
}
