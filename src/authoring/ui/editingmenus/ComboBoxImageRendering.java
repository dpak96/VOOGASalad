package authoring.ui.editingmenus;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.scene.image.ImageView;

public class ComboBoxImageRendering {

    @SuppressWarnings("unchecked")
    public void renderComboBox(ComboBox box){
        box.setCellFactory(new Callback<ListView<ImageView>,ListCell<ImageView>>(){
            @Override
            public ListCell<ImageView> call(ListView<ImageView> p) {
            return new ListCell<ImageView>(){
             private final ImageView view;
             { 
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
                        view = new ImageView();
                    }
             @Override
             protected void updateItem(ImageView item, boolean empty) {
                        super.updateItem(item, empty);
                        
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            view.setImage(item.getImage());
                            setGraphic(view);
                        }
                   }
            };
            
            }   
        });
    }
}

