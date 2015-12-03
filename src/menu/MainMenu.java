package menu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import resourcemanager.ResourceManager;

public class MainMenu extends HBox {
	
	MenuPanel myMenuPanel;
	PlayButton myPlayer;
	PauseButton myPauser;
	StepButton myStepper;
	
	public MainMenu(MenuController menuController){
		super();
		myMenuPanel = new MenuPanel(menuController);
		this.getChildren().add(myMenuPanel);
		controlInit();
	}
	
	private void controlInit(){
		myPlayer = new PlayButton();
		myPlayer.resize(myMenuPanel);
		myPauser = new PauseButton();
		myPauser.resize(myMenuPanel);
		myStepper = new StepButton();
		myStepper.resize(myMenuPanel);
		this.getChildren().addAll(myPlayer, myPauser, myStepper);
	}
	
	public MenuPanel getPanel(){
		return myMenuPanel;
	}
	
	public PlayButton getPlayer(){
		return myPlayer;
	}
	
	public PauseButton getPauser(){
		return myPauser;
	}
	
	public StepButton getStepper(){
		return myStepper;
	}
}
