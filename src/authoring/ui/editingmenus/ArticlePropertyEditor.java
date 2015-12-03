package authoring.ui.editingmenus;

import java.util.ArrayList;
import java.util.HashMap;
import action.controller.ActionController;
import authoring.controller.AuthoringController;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import model.Article;
import resourcemanager.ResourceManager;


public class ArticlePropertyEditor extends AuthoringMenu {
    private HashMap<String, TextField> textFieldPropertyMap;
    private HashMap<String, ComboBox> comboBoxPropertyMap;
    private Article myArticleToEdit;
    public ArticlePropertyEditor (String title,Article selectedArticle, AuthoringController myController) {
        super(title, myController);
        myArticleToEdit=selectedArticle;
        super.showMenu(title);
          }

    protected void populateMenu (GridPane menuGrid) {
        textFieldPropertyMap = new HashMap<String, TextField>();
        comboBoxPropertyMap = new HashMap<String, ComboBox>();
        int rowIndex = 1;

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Name: ");
        textFieldPropertyMap.put("NAME", (super.componentAdder.makeField(menuGrid, 2, rowIndex++)));

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Velocity: ");
        textFieldPropertyMap.put("VELOCITY",
                                 (super.componentAdder.makeField(menuGrid, 2, rowIndex++)));

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Image: ");
        comboBoxPropertyMap.put("IMAGE",
                                super.componentAdder.makeComboBox(menuGrid, 2, rowIndex++));

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Action on Collision: ");
        comboBoxPropertyMap.put("COLLISION",
                                super.componentAdder.makeComboBox(menuGrid, 2, rowIndex++));

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Save as default?: ");
        CheckBox defaultSave = new CheckBox();
        menuGrid.add(defaultSave, 2, rowIndex++);

        addImages(comboBoxPropertyMap.get("IMAGE"));

    }

    public void addImages (ComboBox imageBox) {
        for (String imgName : ResourceManager.getResourceManager().getIm().getImageMap().keySet()) {
        
            imageBox.getItems().add(imgName);
        }
       
      ComboBoxImageRendering renderer = new ComboBoxImageRendering();
        renderer.renderComboBox(imageBox);
    }

    @Override
    public void executeYourMenuFunction () {
        
        myArticleToEdit.setImageFile(comboBoxPropertyMap.get("IMAGE").getValue().toString());
        // Pass on the edits to the thing being edited
    }
    
    
}
