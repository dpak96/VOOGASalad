package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.editingmenus.CollisionMenu;

public class CollisionButton extends ToolbarButton {

    public CollisionButton (AuthoringController authoringController) {
        super(authoringController);
        this.setGraphic(super.setImage(super.toolbarProperties.getString("collision")));
    }

    @Override
    public void placeYourObject () {
        CollisionMenu collisionMenu=new CollisionMenu("Collision Menu",super.myController);
        
    }
    

}
