package authoring.ui.toolbar;

import authoring.ui.draganddrop.DraggableElement;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnemyButton extends ToolbarButton{
  private final String NAME = "ENEMY";


    public EnemyButton () {
        super();
        this.setGraphic(super.setImage(super.toolbarProperties.getString(NAME)));
        this.setName(NAME);
        this.setImageName(super.toolbarProperties.getString(NAME));

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
