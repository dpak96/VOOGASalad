package uibasics;

import java.util.ResourceBundle;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;


public class MenuPanel extends MenuBar {

  private Stage myStage;
  private ResourceBundle myResource;

  public MenuPanel(Stage stage, ResourceBundle resource) {
    super();
    myResource = resource;
    myStage = stage;
    getMenus().addAll(fileMenu(myStage));
  }

  /**
   * create file menu
   *
   * @return menu
   */
  private Menu fileMenu(Stage stage) {
    Menu menu = new Menu(myResource.getString("FILE"));
    AbstractMenuItem newer = new NewMenuItem(myResource, myStage);
    AbstractMenuItem opener = new OpenMenuItem(myResource, myStage);
    AbstractMenuItem saver = new SaveMenuItem(myResource, myStage);
    AbstractMenuItem helper = new HelpMenuItem(myResource, myStage);
    AbstractMenuItem exiter = new ExitMenuItem(myResource, myStage);
    menu.getItems().addAll(newer, opener, saver, helper, new SeparatorMenuItem(), exiter);

    return menu;
  }
}
