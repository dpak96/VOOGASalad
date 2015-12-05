package authoring.ui.editingmenus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import model.article.Article;
import resourcemanager.ResourceManager;


public class ArticlePropertyEditorMenu extends AuthoringMenu {

  private HashMap<String, TextField> textFieldPropertyMap;
  private HashMap<String, ComboBox> comboBoxPropertyMap;
  private Article myArticleToEdit;
  private ComboBoxImageRendering imageBoxHandler=new ComboBoxImageRendering();

  public ArticlePropertyEditorMenu(String title,
                               Article selectedArticle,
                               AuthoringController myController) {
    super(title, myController);
    myArticleToEdit = selectedArticle;
    super.showMenu(300,300);
  }

  protected void populateMenu(GridPane menuGrid) {
    textFieldPropertyMap = new HashMap<String, TextField>();
    comboBoxPropertyMap = new HashMap<String, ComboBox>();
    int rowIndex = 1;

    super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Name: ");
    textFieldPropertyMap.put("NAME", (super.componentAdder.makeField(menuGrid, 2, rowIndex++)));

    super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "X-Velocity: ");
    textFieldPropertyMap.put("XVELOCITY",
                             (super.componentAdder.makeField(menuGrid, 2, rowIndex++)));

    super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Y-Velocity: ");
    textFieldPropertyMap.put("YVELOCITY",
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

    
    
    imageBoxHandler.addImages(comboBoxPropertyMap.get("IMAGE"));
    initializeFieldValues();

  }

 
  public void initializeFieldValues(){
      this.textFieldPropertyMap.get("XVELOCITY").setText(Double.toString(myArticleToEdit.getXVelocity()));
      this.textFieldPropertyMap.get("YVELOCITY").setText(Double.toString(myArticleToEdit.getYVelocity()));
      this.comboBoxPropertyMap.get("IMAGE").setValue(myArticleToEdit.getImageFile());
      
   }
  @Override
  public void executeYourMenuFunction() {
    System.out.println(myArticleToEdit == null);

    super.myController.getEditor().getArticleEditor()
        .editArticleXVelocity(Double.parseDouble(textFieldPropertyMap.get("XVELOCITY")
            .getText()),
                              myArticleToEdit);
    super.myController.getEditor().getArticleEditor()
        .editArticleYVelocity(Double.parseDouble(textFieldPropertyMap.get("YVELOCITY")
            .getText()),
                              myArticleToEdit);
    super.myController.getEditor().getArticleEditor()
        .editArticleImage(comboBoxPropertyMap.get("IMAGE").getValue().toString(),
                          myArticleToEdit);

    // Pass on the edits to the thing being edited
  }

}
