package uibasics;

import javafx.scene.layout.BorderPane;

public class Layout extends BorderPane{
	
	public Layout(){
		this.setCenter(new UIBasics());
		this.setTop(new TopMenuBar());
	}

}
