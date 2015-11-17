package authoring.ui.smalloverlay;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Base {
    private Pane pane;
    private Boolean overlayOn;

    public Base(){
        this(new StackPane());
    }

    public Base(Pane p){
        pane = p;
        overlayOn = false;
        pane.getStyleClass().add("BaseP");
    }

    public void addToPane(Pane n){
        pane.getChildren().add(n);
    }

    public void removeFromPane(Pane n){
        pane.getChildren().remove(n);
    }

    public void toggleOverlayed(){
        if(overlayOn){
            pane.getStyleClass().remove("Overlayed");
            int finalind = pane.getChildren().size()-1;
            if(finalind>0){
                pane.getChildren().remove(finalind);
            }
        }
        else{
            pane.getStyleClass().add("Overlayed");
            overlayOn = true;
        }
    }


    public Pane getPane(){
        return pane;
    }


}
