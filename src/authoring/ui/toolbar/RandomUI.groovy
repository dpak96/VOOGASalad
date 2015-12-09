package authoring.ui.toolbar

import authoring.controller.AuthoringController
import authoring.ui.draganddrop.InfiniteDrop
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.TableColumn
import javafx.scene.control.TableRow
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.layout.Pane
import javafx.scene.text.Text
import main.VoogaProperties

public class RandomUI extends Pane {

	private final String CONSTANT = "Constant Generation";
	private final String RANDOM = "Random Generation";
	private final int LEFT_X = 50;
	private final int LEFT_Y = 50;
	private final int PANE_X = 450;
	private final int PANE_Y = 150;
	private final int MARGIN = 30;
	
	private Text myText;
	private Pane myDrag;
	private TextField myName, myProb, myXDist, myYDist, myXRepeat, myYRepeat;
	private TableView myTableR, myTableC;
	private ComboBox myMode, myArticles;
	private AuthoringController myController;
	private Button myEdit, mySave;
	private List<RepeatingArticle> myRandoms;
	private List<RepeatingArticle> myConstants;

	public RandomUI(controller) {
		myController = controller;
		myText = new Text();
		myMode = new ComboBox();
		myTableR = new TableView();
		myTableC = new TableView();
		myConstants = new ArrayList<RepeatingArticle>();
		myEdit = new Button();
		mySave = new Button();
		myDrag = new InfiniteDrop();
		myName = new TextField();
		myName.setPromptText("Name of Article List");
		myProb = new TextField();
		myProb.setPromptText("Probability");
		myXDist = new TextField();
		myXDist.setPromptText("X Distance from Viewpoint");
		myYDist = new TextField();
		myYDist.setPromptText("Y Distance from Viewpoint");
		myXRepeat = new TextField();
		myXRepeat.setPromptText("X Distance to Repeat");
		myYRepeat = new TextField();
		myYRepeat.setPromptText("Y Distance to Repeat");
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
	
	private void input() {
		
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
		mySave.setOnAction({save()});
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
		myDrag.setOnDragDropped({event -> myController.callEvent("DragAndDropController","dropElement",event)});
		
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
		myName.setLayoutX(PANE_X);
		myName.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight()-30);
		
		myProb.setLayoutX(PANE_X);
		myProb.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight());
		myProb.setPrefWidth(myDrag.getPrefWidth()/2);
		
		myXDist.setLayoutX(PANE_X);
		myXDist.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight()-30);
		myYDist.setLayoutX(PANE_X);
		myYDist.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight());
		myXRepeat.setLayoutX(PANE_X + myProb.getPrefWidth());
		myXRepeat.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight()-30);
		myYRepeat.setLayoutX(PANE_X + myProb.getPrefWidth());
		myYRepeat.setLayoutY(LEFT_Y + myText.getBoundsInParent().getHeight());
		
		myXDist.setPrefWidth(myDrag.getPrefWidth()/2);
		myYDist.setPrefWidth(myDrag.getPrefWidth()/2);
		myXRepeat.setPrefWidth(myDrag.getPrefWidth()/2);
		myYRepeat.setPrefWidth(myDrag.getPrefWidth()/2);
	}
	
	private void makeRandom() {
		myText.setText("Make " + RANDOM);
		if (getChildren().contains(myTableC)) {
			getChildren().removeAll(myTableC, myXDist, myYDist, myXRepeat, myYRepeat);
		}
		if (!getChildren().contains(myTableR))
			getChildren().addAll(myTableR, myProb);
	}
	
	private void makeConstant() {
		myText.setText("Make " + CONSTANT);
		if (getChildren().contains(myTableR))
			getChildren().removeAll(myTableR, myProb);
		if (!getChildren().contains(myTableC))
			getChildren().addAll(myTableC, myXDist, myYDist, myXRepeat, myYRepeat);
	}
	
	private void toggle() {
		if (myMode.getValue().equals(CONSTANT))
			makeConstant();
		else if (myMode.getValue().equals(RANDOM))
			makeRandom();
	}
	
	private void save() {
		if (myMode.getValue().equals(RANDOM))
			myController.callEvent("infinite", "addToRandom", article, myProb.getText());
		else
//			myController.callEvent("infinite", "addToConstant", article, );
	}

}
