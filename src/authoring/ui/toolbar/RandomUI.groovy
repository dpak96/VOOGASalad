package authoring.ui.toolbar

import authoring.controller.AuthoringController
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.layout.Pane
import javafx.scene.text.Text
import main.VoogaProperties

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
	private TableView myTableR, myTableC;
	private ComboBox myMode, myArticles;
	private AuthoringController myController;
	private Button myEdit, mySave;
	private List<RepeatingArticle> myRepeats;

	public RandomUI(controller) {
		myController = controller;
		myText = new Text();
		myMode = new ComboBox();
		myTableR = new TableView();
		myTableC = new TableView();
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
		getChildren().addAll(myText, myMode, myEdit, mySave, myDrag);
		box();
		buttons();
		drag();
		setPositions();
		myMode.setValue("Make " + RANDOM);
		tableMaker(myTableR, ["Articles", "Probability"]);
		tableMaker(myTableC, ["Articles"]);
		makeRandom();
	}
	
	private void box() {
		myMode.getItems().addAll(RANDOM, CONSTANT);
		myMode.setPrefSize(300,15);
		myMode.setOnAction({toggle()});
	}
	
	private void buttons() {
		myEdit.setText("Edit");
		mySave.setText("Save");
		myEdit.setPrefSize(70,10);
		mySave.setPrefSize(70,10);
	}
	
	private void tableMaker(TableView table, ArrayList<String> str) {
		table.setEditable(true);
		table.setPrefSize(300, 300);
		for (String s: str) {
			TableColumn col = new TableColumn(s);
			col.setPrefWidth(table.getPrefWidth()/(str.size()));
			table.getColumns().add(col);
		}
//		TableColumn article = new TableColumn("Article Group");
//		article.setWidth(myTableR.getPrefWidth()/2);
//		TableColumn prob = new TableColumn("Probilities");
//		prob.setPrefWidth(myTableR.getPrefWidth()/2);
//		myTableR.getColumns().addAll(article,prob);
	}
	
	private void drag() {
		myDrag.setPrefSize(300,300);
		myDrag.getStyleClass().add("ass");
	}
	
//	private void newEntry() {
//		TableColumn col = new TableColumn("Ass boners");
//		col.setCellValueFactory("fuck slut");
//		myTable.getColumns().add(col);
//	}
	
	private void setPositions() {
		myText.getStyleClass().add("random");
		myText.setLayoutX(LEFT_X /*- myText.getBoundsInParent().getWidth()*/);
		myText.setLayoutY(LEFT_Y);
		myMode.setLayoutX(LEFT_X);
		myMode.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight());
		myTableR.setLayoutX(LEFT_X);
		myTableR.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight() + myMode.getPrefHeight() + MARGIN);
		myTableC.setLayoutX(LEFT_X);
		myTableC.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight() + myMode.getPrefHeight() + MARGIN);
		myDrag.setLayoutX(PANE_X);
		myDrag.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight() + myMode.getPrefHeight() + MARGIN);
		myEdit.setLayoutX(PANE_X + myDrag.getPrefWidth()/2 - myEdit.getPrefWidth());
		myEdit.setLayoutY(PANE_Y + myDrag.getPrefHeight());
		mySave.setLayoutX(PANE_X + myDrag.getPrefWidth()/2);
		mySave.setLayoutY(PANE_Y + myDrag.getPrefHeight());
	}
	
	private void makeRandom() {
		myText.setText("Make " + RANDOM);
		if (getChildren().contains(myTableC))
			getChildren().remove(myTableC);
		if (!getChildren().contains(myTableR))
			getChildren().add(myTableR);
	}
	
	private void makeConstant() {
		myText.setText("Make " + CONSTANT);
		if (getChildren().contains(myTableR))
			getChildren().remove(myTableR);
		if (!getChildren().contains(myTableC))
			getChildren().add(myTableC);
	}
	
	private void toggle() {
		if (myMode.getValue().equals(CONSTANT))
			makeConstant();
		else if (myMode.getValue().equals(RANDOM))
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
