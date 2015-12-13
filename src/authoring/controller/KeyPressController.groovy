package authoring.controller

import javafx.scene.control.Button
import javafx.scene.input.KeyCode
import javafx.scene.layout.Pane
import model.Event
import model.article.Article
import model.controller.ModelController
import uibasics.KeyPress

/**
 * Created by Rob on 12/8/15.
 */
class KeyPressController {
	private final double DISTANCE_MOVE = 50;
	private AuthoringController myAuthoringController;
	private ModelController myModelController;
	KeyPressController(AuthoringController authoring, ModelController model){
		myAuthoringController = authoring;
		myModelController = model;
		myAuthoringController.getUi().getDragAndDrop().getScene().setOnKeyReleased({ event->  pressButtons(event)});
		//myAuthoringController.getUi().getDragAndDrop().getScene().setOnKeyPressed({ event->  pressButtons(event)});
	}

	private pressButtons(event){
		myAuthoringController.callEvent("ArticleExtenderController","addTile",event);
		if(event.getCode() == KeyCode.P){
			println("hi")
			myAuthoringController.callEvent("OtherController","deleteArticle",myAuthoringController.getCurrentArticle());
		}
		Article view = myAuthoringController.callEvent("OtherController", "getViewPoint")
		if(event.getCode() == KeyCode.RIGHT){
			view.setX(view.getX()+DISTANCE_MOVE);
			deleteButton();
		}
		if(event.getCode() == KeyCode.LEFT){
			view.setX(view.getX()-DISTANCE_MOVE);
			deleteButton();
		}
		if(event.getCode() == KeyCode.UP){
			view.setY(view.getY()-DISTANCE_MOVE);
			deleteButton();
		}
		if(event.getCode() == KeyCode.DOWN){
			view.setY(view.getY()+DISTANCE_MOVE);
			deleteButton();
		}
	}

	public void mapKey(String button, List<Event> events) {
		myModelController.remapButton(button, events);
	}

	private deleteButton(){
		/*if(myAuthoringController.getCurrentButton() != null){
			Button b = myAuthoringController.getCurrentButton();
			Pane p = (Pane) b.getParent();
			p.getChildren().remove(b);
			myAuthoringController.setHighlighted(false);
			myAuthoringController.setCurrentButton(null);
		}*/
	}
}
