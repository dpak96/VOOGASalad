package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import javafx.scene.control.Button;

public class RandomButton extends Button {
	
	public RandomButton(AuthoringController controller) {
		super("Random shit");
		setOnAction(e -> new RandomUI(controller));
	}
}
