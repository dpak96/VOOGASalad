package authoring.ui.toolbar;

import authoring.ui.draganddrop.DraggableElement;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnemyButton extends ToolbarButton{

    public EnemyButton () {
        super();
        this.setGraphic(super.setImage(super.toolbarProperties.getString("ENEMY")));
            }

    @Override
    public void placeYourObject () {
        
        
         DraggableElement elementToDrag=new DraggableElement();
       ImageView icon= (ImageView) this.getGraphic();
        elementToDrag.setGraphic(icon);
        
        Pane parentPane=(Pane) this.getParent().getParent();
       
        
        parentPane.getChildren().add(elementToDrag);
        elementToDrag.dragDetected();
        elementToDrag.dragEnd();
        
    }




    
    

   
}
