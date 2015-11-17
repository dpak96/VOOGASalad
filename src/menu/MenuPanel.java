package menu;

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
		getMenus().addAll(fileMenu(), navigateMenu(), helpMenu());
	}

	/**
	 * create file menu
	 *
	 * @return menu
	 */
	private Menu fileMenu() {
		Menu menu = new Menu(myResource.getString("FILE"));
		AbstractMenuItem opener = new OpenMenuItem(myResource, myStage);
		AbstractMenuItem saver = new SaveMenuItem(myResource, myStage);
		AbstractMenuItem exiter = new ExitMenuItem(myResource, myStage);
		menu.getItems().addAll(opener, saver, exiter);

		return menu;
	}

	private Menu navigateMenu() {
		Menu menu = new Menu(myResource.getString("NAVIGATE"));
		AbstractMenuItem mainMenu = new MainMenuItem(myResource, myStage);
		AbstractMenuItem switchAE = new SwitchMenuItem(myResource, myStage);
		menu.getItems().addAll(mainMenu, switchAE);

		return menu;
	}

	private Menu helpMenu() {
		Menu menu = new Menu(myResource.getString("HELPMENU"));
		AbstractMenuItem controls = new ControlMenuItem(myResource, myStage);
		AbstractMenuItem helper = new HelpMenuItem(myResource, myStage);
		menu.getItems().addAll(controls, helper);

		return menu;
	}
}
