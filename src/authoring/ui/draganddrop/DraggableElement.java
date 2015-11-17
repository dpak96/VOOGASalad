package authoring.ui.draganddrop;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.*;
import javafx.scene.paint.Color;

public class DraggableElement extends Node {

    public DraggableElement(){

    }

    @Override
    protected NGNode impl_createPeer() {
        return null;
    }

    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        return null;
    }

    @Override
    protected boolean impl_computeContains(double localX, double localY) {
        return false;
    }

    @Override
    public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return null;
    }




    protected void dragDetected(Dragging d){
        this.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("OMG WE DRAGGIN");
                /* allow MOVE transfer mode */
                d.dragging();
                //Dragboard db = this.startDragAndDrop(TransferMode.MOVE);
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                //content.putString(source.getText());
                //db.setContent(content);
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

    protected void dragEnd(DragEnd de){
        this.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                //System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    de.dragEnd();
                }
                event.consume();
            }
        });
    }

}