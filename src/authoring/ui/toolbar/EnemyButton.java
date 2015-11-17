package authoring.ui.toolbar;

import authoring.ui.draganddrop.DraggableElement;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnemyButton extends ToolbarButtons{

    public EnemyButton () {
        super();
        this.setGraphic(super.setImage("Goomba", 50, 50));
        

       // this.setOnAction(e -> placeYourObject());
    }

    @Override
    public void placeYourObject () {
        DraggableElement elementToDrag=new DraggableElement();
       ImageView icon= (ImageView) this.getGraphic();
        elementToDrag.setGraphic(icon);
        
        Pane parentPane=(Pane) this.getParent();
        
        parentPane.getChildren().add(elementToDrag);
        System.out.println("drag");
        elementToDrag.dragDetected();
        System.out.println("stop");
        elementToDrag.dragEnd();
        
    }




    
    

   
}
