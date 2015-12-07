package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import main.VoogaProperties;

public class RandomUI extends Pane {

	private Text myText;
	private Pane myDrag;
	private AuthoringController myController;
	private final int TOP_OFFSET = 5;
	private final int LEFT_OFFSET = 5;
	
	public RandomUI(AuthoringController controller) {
		myController = controller;
		init();
	}
	
	private void init() {
		VoogaProperties vooga = new VoogaProperties();
		setPrefSize(vooga.getSceneWidth(),vooga.getSceneHeight());
		getStyleClass().add("Thingy");
		makeDrag();
	}
	
	private void makeDrag() {
		myText = new Text("Add New Random Object");
		myDrag = new Pane();
		myText.setLayoutX(LEFT_OFFSET);
		myText.setLayoutY(TOP_OFFSET);
		myDrag.setLayoutX(LEFT_OFFSET);
		myDrag.setLayoutY(TOP_OFFSET);
	}
	
}
