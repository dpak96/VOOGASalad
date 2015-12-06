package authoring.ui.editingmenus;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Event;
import model.article.Article;
import resourcemanager.ResourceManager;


public class AddProcessMenu extends AuthoringMenu {
    private ComboBox<String> conditionBox = new ComboBox<String>();
    private Map<String, Control> parameters = new HashMap<String, Control>();
    private String myProcessType;
    Map<String, Class<?>> ruleParams;
    private Event myEventToAddTo;

    public AddProcessMenu (String title,
                           AuthoringController controller,
                           String myProcessName,
                           Event eventToAddTo) {
        super(title, controller);
        myProcessType = myProcessName;
        myEventToAddTo = eventToAddTo;
        super.showMenu(300, 300);
    }

    @Override
    public void executeYourMenuFunction () {

    }

    @Override
    protected void populateMenu (GridPane menuPane) {

        super.componentAdder.makeLabel(menuPane, 1, 1, myProcessType + ":");
        menuPane.add(conditionBox, 2, 1);
        GridPane paramGrid = new GridPane();
        menuPane.add(paramGrid, 1, 2, 2, 2);
        this.addCondition(conditionBox, paramGrid);

    }

    private void addCondition (ComboBox<String> conditionBox, GridPane paramGrid) {
        ResourceBundle conditionBundle =
                (ResourceBundle) ResourceManager.getResourceManager()
                        .getResource("PropertiesManager", myProcessType + "Subclass");
        Enumeration bundleKeys = conditionBundle.getKeys();
        while (bundleKeys.hasMoreElements()) {
            String className = (String) bundleKeys.nextElement();
            conditionBox.getItems().add(className);
        }
        conditionBox.setOnAction(e -> this.addParameterFields(conditionBox.getValue(), paramGrid));
    }

    private void addParameterFields (String selectedObject, GridPane paramGrid) {
        paramGrid.getChildren().clear();
        ruleParams =
                super.myController
                        .getFactoryParameters(("model.processes." + myProcessType +
                                               selectedObject));

        int rowIndex = 2;
        for (String key : ruleParams.keySet()) {
            super.componentAdder.makeLabel(paramGrid, 1, rowIndex, key);
            if (ruleParams.get(key) == String.class || ruleParams.get(key) == double.class)
                parameters.put(key, super.componentAdder.makeField(paramGrid, 2, rowIndex++));
            else {
                ComboBox articleBox = super.componentAdder.makeComboBox(paramGrid, 2, rowIndex++);
                for (Article activeArticle : super.myController.getArticles())
                    articleBox.getItems().add(activeArticle);

                parameters.put(key, articleBox);

            }

        }

    }

    private Map<String, Object> parseUserInput () {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        for (String key : parameters.keySet()) {
            if (ruleParams.get(key) == String.class) {
                TextField field = (TextField) parameters.get(key);
                if (ruleParams.get(key) == double.class) {
                    dataMap.put(key, Double.parseDouble(field.getText()));
                }
                else
                    dataMap.put(key, field.getText());

            }

        }

        return dataMap;
    }

}