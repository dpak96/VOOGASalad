package authoring.ui.editingmenus;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.article.Article;
import resourcemanager.ResourceManager;
import javafx.scene.image.Image;
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
                            view.setImage((Image) ResourceManager.getResourceManager()
                                    .getResource("ImageManager", item));
                            view.setFitWidth(50);
                            view.setFitHeight(50);
                            setGraphic(view);
                        }
                    }
                };

            }
        });
    }

    public void renderArticleComboBox(ComboBox articleBox){
        articleBox.setCellFactory(new Callback<ListView<Article>, ListCell<Article>>() {
            @Override
            public ListCell<Article> call (ListView<Article> p) {
                return new ListCell<Article>() {
                    private final ImageView view;

                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        
                        view = new ImageView();
                    }

                    @Override
                    protected void updateItem (Article item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        }
                        else {
                            view.setImage((Image) ResourceManager.getResourceManager()
                                    .getResource("ImageManager", item.getImageFile()
                                                 ));
                            view.setFitWidth(50);
                            view.setFitHeight(50);
                            setGraphic(view);
                        }
                    }
                };

            }
        });
        
        
        
    }
    public void addImages (ComboBox imageBox) {
        for (String imgName : ResourceManager.getResourceManager().getResourceMap("ImageManager")
                .keySet()) {
            imageBox.getItems().add(imgName);
        }
        renderComboBox(imageBox);
        imageBox.setValue(imageBox.getItems().get(0));
    }

    public void addBackgroundImages(ComboBox imageBox){ 
       for (String imgName : ResourceManager.getResourceManager().getResourceMap("BackgroundImageManager").keySet()) 
        imageBox.getItems().add(imgName);
      renderComboBox(imageBox);
      imageBox.setValue(imageBox.getItems().get(0));
        
    }
}
