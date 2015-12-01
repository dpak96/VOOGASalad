package authoring.ui.editingmenus;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import resourcemanager.ResourceManager;
import javafx.scene.image.ImageView;


public class ComboBoxImageRendering {

    @SuppressWarnings("unchecked")
    public void renderComboBox (ComboBox box) {
        box.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call (ListView<String> p) {
                return new ListCell<String>() {
                    private final ImageView view;

                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        view = new ImageView();
                    }

                    @Override
                    protected void updateItem (String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        }
                        else {
                            view.setImage(ResourceManager.getResourceManager().getImage(item));
                            setGraphic(view);
                        }
                    }
                };

            }
        });
    }
}
