package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import main.VoogaProperties;

public class RandomUI extends Pane {

	private Text myText;
	private Pane myDrag;
	private AuthoringController myController;
	private final int TOP_OFFSET = 200;
	private final int LEFT_OFFSET = 200;
	
	public RandomUI(controller) {
		myController = controller;
		controller.getTester().getChildren().add(this);
		init();
	}
	
	private void init() {
		VoogaProperties vooga = new VoogaProperties();
		setPrefSize(vooga.getSceneWidth(),vooga.getSceneHeight());
		getStyleClass().add("Thingy2");
		makeDrag();
	}
	
	private void makeDrag() {
		myText = new Text("Add New Random Object");
		myDrag = new Pane();
		getChildren().addAll(myText,myDrag);
		myDrag.setPrefSize(100,100);
		myDrag.getStyleClass().add("ass");
		myText.getStyleClass().add("random");
		setOnDragDropped({event -> myController.dragEvent("dropElement",event)});
		myText.setLayoutX(LEFT_OFFSET);
		myText.setLayoutY(TOP_OFFSET);
		myDrag.setLayoutX(LEFT_OFFSET + myText.getBoundsInParent().getWidth());
		myDrag.setLayoutY(TOP_OFFSET + myText.getBoundsInParent().getHeight()/2);
		println "Width " + myText.getBoundsInParent().getWidth() + " Height " + myText.getBoundsInParent().getHeight()/2;
	}
	
}
