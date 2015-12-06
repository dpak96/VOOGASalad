package startscreen;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;


public abstract class AbstractModule {
    protected Pane myContainer;

    public AbstractModule(){
        myContainer = new Pane();
        myContainer.setId("pane");
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
