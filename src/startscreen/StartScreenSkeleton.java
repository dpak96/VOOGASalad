package startscreen;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.util.Stack;

public class StartScreenSkeleton {
    private BorderPane border;
    private StackPane layers;
    private Stack<Pane> layerStack;
    private Button back;

    public StartScreenSkeleton(){
        border = new BorderPane();
        layers = new StackPane();
        layerStack = new Stack();
    }


    public void init(){
        border.setTop(backButton());
        border.setBottom(layers);
    }

    private Button backButton(){
        back = new Button("Back");
        back.setOnAction(e->this.backLayer());
        return back;
    }


    public void addLayer(Pane n){
        layerStack.push(n);
        layers.getChildren().add(n);
    }

    public void removeLayer(){
        int lastElement = layers.getChildren().size()-1;
        layers.getChildren().remove(lastElement);
    }

    public void backLayer(){
        if(layers.getChildren().size()>0){
            removeLayer();
        }
        if(!layerStack.isEmpty()){
            layerStack.pop();
            layers.getChildren().add(layerStack.pop());
        }
    }



    public Pane getPane(){
        return border;
    }

}
