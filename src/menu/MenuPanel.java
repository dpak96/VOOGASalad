package menu;

import java.util.ResourceBundle;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;
import resourcemanager.ResourceManager;

public class MenuPanel extends MenuBar {

	private ResourceBundle myResource;
	private MenuController myMenuController;

	public MenuPanel(MenuController menuController) {
		super();
		myResource = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "english");
		myMenuController = menuController;
		getMenus().addAll(fileMenu(), editMenu(), navigateMenu(), helpMenu());
	}

	/**
	 * create file menu
	 *
	 * @return menu
	 */
	private Menu fileMenu() {
		Menu menu = new Menu(myResource.getString("FILE"));
		AbstractMenuItem opener = new OpenMenuItem(myResource, myMenuController);
		AbstractMenuItem saver = new SaveMenuItem(myResource, myMenuController);
		AbstractMenuItem exiter = new ExitMenuItem(myResource, myMenuController);
		menu.getItems().addAll(opener, saver, exiter);

		return menu;
	}

	private Menu navigateMenu() {
		Menu menu = new Menu(myResource.getString("NAVIGATE"));
		AbstractMenuItem mainMenu = new MainMenuItem(myResource, myMenuController);
		AbstractMenuItem switchAE = new SwitchMenuItem(myResource, myMenuController);
		menu.getItems().addAll(mainMenu, switchAE);

		return menu;
	}
	
	private Menu editMenu() {
		Menu menu = new Menu(myResource.getString("EDIT"));
		AbstractMenuItem newArticle = new ArticleMenuItem(myResource, myMenuController);
		AbstractMenuItem newBackground = new BackgroundMenuItem(myResource, myMenuController);
		AbstractMenuItem newPlatform = new PlatformMenuItem(myResource, myMenuController);
		
		menu.getItems().addAll(newArticle, newBackground, newPlatform);

		return menu;
	}

	private Menu helpMenu() {
		Menu menu = new Menu(myResource.getString("HELPMENU"));
		AbstractMenuItem controls = new ControlMenuItem(myResource,myMenuController);
		AbstractMenuItem helper = new HelpMenuItem(myResource, myMenuController);
		menu.getItems().addAll(controls, helper);
		return menu;
	}
}
