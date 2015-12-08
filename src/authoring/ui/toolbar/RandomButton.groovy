package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import javafx.scene.control.Button;

public class RandomButton extends Button {
	
	public RandomButton(AuthoringController controller) {
		super("Random shit");
		setOnAction({e -> toggler(controller)});
	}
	
	
	public void toggler(controller){
		if(controller.getTester().getChildren().size()>1){
			controller.getTester().getChildren().remove(controller.getTester().getChildren().size()-1);
		}
		else{
			new RandomUI(controller);
		}
	}
}
