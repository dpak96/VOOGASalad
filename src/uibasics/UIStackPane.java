package uibasics;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import game.player.GamePlayerOverlay;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.Model;
import model.controller.ModelController;
import startscreen.GameCreation;
import startscreen.GameCreation.Mode;
import authoring.controller.AuthoringController;


public class UIStackPane extends StackPane implements Observer {
	private UIBasics myUIBasics;
	private AuthoringController myAuthoringController;
	private GamePlayerOverlay myGamePlayer;
	private boolean edit;
	private Pane myAuthoringControllerPane;
	private ModelController myModelController;
	private String myGameName;
	
	public UIStackPane(ModelController modelController) {
		myModelController = modelController;
		myAuthoringController = new AuthoringController(modelController);
		initializePanes();
	}

	public void initializePanes() {
		edit = true;
		myUIBasics = new UIBasics(myModelController);
		try {
			myGamePlayer = new GamePlayerOverlay(myGameName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myAuthoringControllerPane = myAuthoringController.getUi().tester();
		myAuthoringController.getUi().init();
	}
	
	public void initPanes(GameCreation game) {
		this.getChildren().clear();
		this.getChildren().add(myUIBasics.getPane());
		try {
			myGamePlayer.setName(game.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (game.getMode() == Mode.play) {
			edit=false;
			this.getChildren().add(myGamePlayer);
		} else {
			edit=true;
			this.getChildren().add(myAuthoringControllerPane);
			myAuthoringController.initalizeControllers();

		}
	}
	
	public void toggle() {
		this.getChildren().remove(this.getChildren().size()-1);
		if (edit) {
			this.getChildren().add(myGamePlayer);
		} else {
			myAuthoringController.flush();
			this.getChildren().add(myAuthoringControllerPane);
			myAuthoringController.initalizeControllers();
		}
		edit=!edit;
	}
	
	 public AuthoringController getAuthoringController() {
		 return myAuthoringController;
	 }

	 public void setAuthoringController(AuthoringController authoringController) {
		 this.myAuthoringController = authoringController;
	 }
	
	public StackPane getStack(){
		return this;
	}
	
	public UIBasics getUIBasics(){
		return myUIBasics;
	}
	
	public GamePlayerOverlay getGamePlayer(){
		return myGamePlayer;
	}

	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model) o;
		myUIBasics.update(model.getArticles(), model.getCharacter(), model.getBackgroundImage());
		myGamePlayer.update(model.getArticles(), model.getCharacter());
	}

}
