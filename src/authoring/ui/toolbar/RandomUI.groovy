package authoring.ui.toolbar

import authoring.controller.AuthoringController
import javafx.collections.FXCollections;
import authoring.ui.draganddrop.InfiniteDrop
import javafx.collections.ObservableList
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import javafx.scene.control.TableRow
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.cell.MapValueFactory
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.layout.Pane
import javafx.scene.text.Text
import javafx.util.Callback
import javafx.util.StringConverter
import main.VoogaProperties
import model.article.Article



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
	private TextField myProb, myXDist, myYDist, myXRepeat, myYRepeat;
	private TableView myTableR, myTableC;
	private ComboBox myMode, myArticles;
	private AuthoringController myController;
	private Button myGenerate, mySave, myAdd;
	private List<RepeatingArticle> myRandoms;
	private List<RepeatingArticle> myConstants;
	private String Column1MapKey = "A";
	private String Column2MapKey = "P";

	public RandomUI(controller) {
		myController = controller;
		myText = new Text();
		myMode = new ComboBox();
		myTableR = new TableView();
		myTableC = new TableView();
		myConstants = new ArrayList<RepeatingArticle>();
		myGenerate = new Button();
		myAdd = new Button();
		mySave = new Button();
		myDrag = new InfiniteDrop(controller);
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
		getChildren().addAll(myText, myMode, myGenerate, mySave, myAdd, myDrag);
		box();
		buttons();
		drag();
		setPositions();
		myMode.setValue(RANDOM);
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
		myGenerate.setText("Generate");
		mySave.setText("Save");
		myAdd.setText("Add");
		myGenerate.setPrefSize(70,10);
		mySave.setPrefSize(70,10);
		myAdd.setPrefSize(70,10);
		mySave.setOnAction({save()});
		myGenerate.setOnAction({generate()});
		myAdd.setOnAction({add()});
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
		
		myGenerate.setLayoutX(PANE_X + myDrag.getPrefWidth()/2 - myGenerate.getPrefWidth());
		myGenerate.setLayoutY(PANE_Y + myDrag.getPrefHeight());
		mySave.setLayoutX(PANE_X + myDrag.getPrefWidth()/2);
		mySave.setLayoutY(PANE_Y + myDrag.getPrefHeight());
		myAdd.setLayoutX(PANE_X + myDrag.getPrefWidth()/2 + 75);
		myAdd.setLayoutY(PANE_Y + myDrag.getPrefHeight());
		
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
		getChildren().removeAll(myTableC, myXDist, myYDist, myXRepeat, myYRepeat, myAdd);
		getChildren().addAll(myTableR, myProb);
	}
	
	private void makeConstant() {
		myText.setText("Make " + CONSTANT);
		getChildren().removeAll(myTableR, myProb);
		getChildren().addAll(myTableC, myXDist, myYDist, myXRepeat, myYRepeat, myAdd);
	}
	
	private void toggle() {
		if (myMode.getValue().equals(CONSTANT))
			makeConstant();
		else if (myMode.getValue().equals(RANDOM))
			makeRandom();
	}
	
	private void save() {
		if (myMode.getValue().equals(RANDOM)) {
			myController.callEvent("InfiniteController", "addToRandom", myProb.getText());
			updateTableR();
		} else {
			myController.callEvent("InfiniteController", "addIndConstant");
			updateTableC();
		}
	}

	private void generate(){
		if (myMode.getValue().equals(RANDOM)) {
			myController.callEvent("InfiniteController", "genRandom");
		} else {
			myController.callEvent("InfiniteController", "genConstant", 
				myXDist.getText(), myYDist.getText(), 
				myXRepeat.getText(), myYRepeat.getText());
		}
	}
	
	private void add(){
		myController.callEvent("InfiniteController", "addSetToConstant");
	}
	
	private void updateTableC() {
		
	}
	
	private void updateTableR() {
		
		myTableR.setItems(null);
//		tableMaker(myTableR,["Articles", "Probability"]);
		
		TableColumn<Map, String> firstDataColumn = new TableColumn<>("Articles");
		TableColumn<Map, String> secondDataColumn = new TableColumn<>("Probabilities");
		firstDataColumn.setCellValueFactory(new MapValueFactory(Column1MapKey));
		secondDataColumn.setCellValueFactory(new MapValueFactory(Column2MapKey));
 
		myTableR = new TableView<>(generateDataInMap());
 
		myTableR.setEditable(true);
		myTableR.getSelectionModel().setCellSelectionEnabled(true);
		myTableR.getColumns().setAll(firstDataColumn, secondDataColumn);
		Callback<TableColumn<Map, String>, TableCell<Map, String>>
			cellFactoryForMap = new Callback<TableColumn<Map, String>,
				TableCell<Map, String>>() {
					@Override
					public TableCell call(TableColumn p) {
						return new TextFieldTableCell(new StringConverter() {
							@Override
							public String toString(Object t) {
								return t.toString();
							}
							@Override
							public Object fromString(String string) {
								return string;
							}
						});
					}
		};
		firstDataColumn.setCellFactory(cellFactoryForMap);
		secondDataColumn.setCellFactory(cellFactoryForMap);
		
	}
	
	private ObservableList<Map> generateDataInMap() {
		HashMap<Article, Double> map = myController.callEvent("InfiniteController", "getRandomMap");
		ObservableList<HashMap> allData = FXCollections.observableArrayList();
		for (Map.Entry<Article, Double> entry: map.entrySet()) {
			Map<String, String> dataRow = new HashMap<>();
			
			String key = entry.getKey().getImageFile();
			String value = entry.getValue().toString();
 
			dataRow.put(Column1MapKey, key);
			dataRow.put(Column2MapKey, value);
 
			allData.add(dataRow);
		}
		return allData;
	}


}
