package observer.controller;

import model.Model;
import uibasics.UIStackPane;

public class ObserverController {
	public ObserverController(Model modelMap, UIStackPane uiStack) {
		modelMap.addObserver(uiStack);
	}
}
