package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import javafx.scene.control.Button;

public class RandomButton extends ToolbarButton {
	
	public RandomButton(AuthoringController controller) {
		super(controller);
        this.setGraphic(super.setImage(super.toolbarProperties.getString("random")));
                    
        
	}
	
	
	public void toggler(AuthoringController controller){
		if(controller.getTester().getChildren().size()>1){
			controller.getTester().getChildren().remove(controller.getTester().getChildren().size()-1);
		}
		else{
			new RandomUI(controller);
		}
	}


    @Override
    public void placeYourObject () {
            toggler(super.myController);
    }
}
