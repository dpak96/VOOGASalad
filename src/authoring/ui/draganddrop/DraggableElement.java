package authoring.ui.draganddrop;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;

public class DraggableElement extends Button {
    protected String name;
    protected String imageName;


    public void dragDetected(){
        
        this.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	//  d.dragging();
                Dragboard db = startDragAndDrop(TransferMode.MOVE);
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                ImageView imgView=(ImageView) getGraphic();
                content.putImage(imgView.getImage());
                db.setContent(content);
                event.consume();
            }
        });
    }

    protected void dragExit(DragExit de){
        this.setOnDragExited(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                de.exit();
                event.consume();
            }
        });
    }

    public void dragEnd(){
        this.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                //System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                //if (event.getTransferMode() == TransferMode.MOVE) {
                    //de.dragEnd();


                    //System.out.println(event.getScreenY());


                //}
                event.consume();
            }
        });
    }

    public String getName(){
        return name;
    }

    public String getImageName(){
        return imageName;
    }

}