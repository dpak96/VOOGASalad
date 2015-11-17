package observer.controller;

import uibasics.UIBasics;

public class ObserverController {
	public ObserverController(Something modelMap, UIBasics uiBasics) {
		modelMap.addObserver(uiBasics);
	}
}
