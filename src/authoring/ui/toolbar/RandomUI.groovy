package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.editingmenus.RandomMenu
import javafx.scene.control.ComboBox
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import main.VoogaProperties;

public class RandomUI extends Pane {

	private Text myText;
	private Pane myDrag;
	private ComboBox myBox;
	private AuthoringController myController;
	private final int TOP_OFFSET = 100;
	private int LEFT_OFFSET;
	
	public RandomUI(controller) {
		myController = controller;
		controller.getTester().getChildren().add(this);
		init();		
	}
	
	private void init() {
		VoogaProperties vooga = new VoogaProperties();
		LEFT_OFFSET = vooga.getSceneWidth()/2 - 75;
		setPrefSize(vooga.getSceneWidth(),vooga.getSceneHeight());
		getStyleClass().add("Thingy2");
		makeDrag();
	}
	
	private void makeDrag() {
		myText = new Text("Add New Random Object");
		myDrag = new Pane();
		myBox = new ComboBox();
		getChildren().addAll(myText,myDrag);
		myDrag.setPrefSize(300,300);
		myDrag.getStyleClass().add("ass");
		myText.getStyleClass().add("random");
		setOnDragDropped({event -> react(event)});
		myText.setLayoutX(LEFT_OFFSET - myText.getBoundsInParent().getWidth());
		myText.setLayoutY(TOP_OFFSET);
		myDrag.setLayoutX(LEFT_OFFSET - myDrag.getWidth()  - 20 /*myText.getBoundsInParent().getWidth()*/);
		myDrag.setLayoutY(TOP_OFFSET + myText.getBoundsInParent().getHeight()/2);
	}
	
	private void react(event) {
		myController.infiniteEvent("drag", event );
		
//		new RandomMenu("Random Element Editor",myController);
	}
	
}
