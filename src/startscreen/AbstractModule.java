package startscreen;

import javafx.scene.Node;
import javafx.scene.layout.Pane;


public abstract class AbstractModule {
    private Pane myContainer;

    public AbstractModule(){
        myContainer = new Pane();
    }

    public AbstractModule(Pane pane){
        myContainer = pane;
    }

    public void addToContainer(Node obj){
        myContainer.getChildren().add(obj);
    }

    public Pane getContainer(){
        return myContainer;
    }

}
