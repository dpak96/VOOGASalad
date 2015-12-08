package startscreen;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.*;

import java.util.Stack;

public class StartScreenSkeleton {
    private ScrollPane myScrollPane;
	private BorderPane border;
    private StackPane layers;
    private Stack<Pane> layerStack;
    private Button back;

    public StartScreenSkeleton(){
    	myScrollPane = new ScrollPane();
    	border = new BorderPane();
        layers = new StackPane();
        layerStack = new Stack<Pane>();
    }


    public void init(){
        border.setTop(backButton());
        border.setCenter(layers);
        myScrollPane.setContent(border);
        myScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
    }

    private Button backButton(){
        back = new Button("Back");
        back.setId("backB");
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
        if(layerStack.size()>=2){
            layerStack.pop();
            addLayer(layerStack.pop());
        }
    }



    public ScrollPane getPane(){
        return myScrollPane;
    }

}
