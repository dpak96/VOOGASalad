package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.editingmenus.RandomMenu
import java.beans.EventHandler
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import main.VoogaProperties;

public class RandomUI extends Pane {

	private final String CONSTANT = "Constant Generation";
	private final String RANDOM = "Random Generation";
	private final int LEFT_X = 50;
	private final int LEFT_Y = 50;
	private final int PANE_X = 500;
	private final int PANE_Y = 150;
	private final int MARGIN = 30;
	
	private Text myText;
	private Pane myDrag;
	private TableView myTable;
	private ComboBox myMode, myArticles;
	private AuthoringController myController;
	private Button myEdit, mySave;
	private List<RepeatingArticle> myRepeats;

	public RandomUI(controller) {
		myController = controller;
		myText = new Text();
		myMode = new ComboBox();
		myTable = new TableView();
		myRepeats = new ArrayList<RepeatingArticle>();
		myEdit = new Button();
		mySave = new Button();
		myDrag = new Pane();
		init();		
	}
	
	private void init() {
		myController.getTester().getChildren().add(this);
		VoogaProperties vooga = new VoogaProperties();
//		LEFT_OFFSET = vooga.getSceneWidth()/2 - 75;
		setPrefSize(vooga.getSceneWidth(),vooga.getSceneHeight());
		getStyleClass().add("Thingy2");
		getChildren().addAll(myText, myMode, myTable, myEdit, mySave, myDrag);
		box();
		buttons();
		table();
		drag();
		setPositions();
		makeRandom();
	}
	
	private void box() {
		myMode.getItems().addAll(RANDOM, CONSTANT);
		myMode.setPrefSize(300,15);
//		myMode.valueProperty().addListener({toggle();});
	}
	
	private void buttons() {
		myEdit.setText("Edit");
		mySave.setText("Save");
		myEdit.setPrefSize(70,10);
		mySave.setPrefSize(70,10);
//		mySave.addEventHandler(event, save());
//		myEdit.setOnAction(new EventHandler<ActionEvent>() {
//			@Override public void handle(ActionEvent e) {
//				label.setText("Accepted");
//			}
//		});
	}
	
	private void table() {
		myTable.setEditable(true);
		myTable.setPrefSize(300, 300);
		TableColumn article = new TableColumn("Article Group");
		article.setWidth(myTable.getPrefWidth()/2);
		TableColumn prob = new TableColumn("Probilities");
		prob.setPrefWidth(myTable.getPrefWidth()/2);
		myTable.getColumns().addAll(article,prob);
	}
	
	private void drag() {
		myDrag.setPrefSize(300,300);
		myDrag.getStyleClass().add("ass");
	}
	
	private void newEntry() {
		TableColumn col = new TableColumn("Ass boners");
		col.setCellValueFactory("Ching chong");
		myTable.getColumns().add(col);
	}
	
	private void setPositions() {
		myText.getStyleClass().add("random");
		myText.setLayoutX(LEFT_X /*- myText.getBoundsInParent().getWidth()*/);
		myText.setLayoutY(LEFT_Y);
		myMode.setLayoutX(LEFT_X);
		myMode.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight());
		myTable.setLayoutX(LEFT_X);
		myTable.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight() + myMode.getPrefHeight() + MARGIN);
		myDrag.setLayoutX(PANE_X);
		myDrag.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight() + myMode.getPrefHeight() + MARGIN);
		myEdit.setLayoutX(PANE_X + myDrag.getPrefWidth()/2 - myEdit.getPrefWidth());
		myEdit.setLayoutY(PANE_Y + myDrag.getPrefHeight());
		mySave.setLayoutX(PANE_X + myDrag.getPrefWidth()/2);
		mySave.setLayoutY(PANE_Y + myDrag.getPrefHeight());
	}
	
	private void makeDrag() {
		myText.getStyleClass().add("random");
		setOnDragDropped({event -> react(event)});
		myText.setLayoutX(200 /*- myText.getBoundsInParent().getWidth()*/);
		myText.setLayoutY(TOP_OFFSET);
		myDrag.setLayoutX(LEFT_OFFSET - myDrag.getWidth()  - 20 /*myText.getBoundsInParent().getWidth()*/);
		myDrag.setLayoutY(TOP_OFFSET + myText.getBoundsInParent().getHeight()/2);
	}
	
	private void makeRandom() {
		myText.setText("Make " + RANDOM);
		println(myText.getBoundsInLocal().getHeight() + "Ass Boners " + myText.getBoundsInParent().getHeight())
		myMode.setValue(RANDOM);
//		newEntry();
	}
	
	private void makeConstant() {
		myText.setText("Make " + CONSTANT);
		myMode.setValue(CONSTANT);
	}
	
	private void toggle() {
		if (myMode.getValue().equals(RANDOM))
			makeConstant();
		else
			makeRandom();
	}
	
	private void edit() {
		
	}
	
	private void save() {
		
	}
	
	private void react(event) {
		myController.infiniteEvent("drag", event );
		
//		new RandomMenu("Random Element Editor",myController);
	}
	
}
