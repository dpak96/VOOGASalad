//This was refactored the day before the due date (without changing functionality) for my masterpiece
package model.XMLutility;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import gameengine.CollisionTypeEditor;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import level.manager.LevelManager;
import level.manager.XMLOrderer;
import model.Model;
import model.controller.ModelController;
import model.processes.Executable;
import model.processes.ExecutableLevelChanges;

public class xmlUtility {
	XStream myStream;
	LevelManager myLevelManager;
	
	public xmlUtility(LevelManager levelManager) {
		myStream = new XStream(new DomDriver());
		myLevelManager = levelManager;
	}
	
	public Model loadModel(Window window) {
		FileChooser myFileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter =
				new FileChooser.ExtensionFilter("Java files (*.xml)", "*.xml");
		myFileChooser.getExtensionFilters().add(extensionFilter);
		File game = myFileChooser.showOpenDialog(window);
		try {
			return load(game);
//	      o.writeObject(myController.getMyScene().getAllData().get(0));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Model load(File file){
		try {
			myStream = new XStream(new DomDriver());
			//myStream.processAnnotations(ModelAnnotations.class);
			myStream.alias("model", Model.class);
			myStream.alias("CollisionTypeEditor", CollisionTypeEditor.class);
			Object readObject = myStream.fromXML(file);
			for (Executable f: ((Model) readObject).getExecutables()) {
				if (f instanceof ExecutableLevelChanges) {
					((ExecutableLevelChanges) f).initialize(myLevelManager);
				}
			}
			return (Model) readObject;
			
		} catch (NullPointerException e) {
			//User canceled from a save
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void saveModel(Window window, String path, Model myModel) {
		FileChooser myFileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter =
				new FileChooser.ExtensionFilter("Java files (*.xml)", "*.xml");
		myFileChooser.getExtensionFilters().add(extensionFilter);
		myFileChooser.setTitle("Howdy");
		myFileChooser.setInitialDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "SquirtleSquadGames" + System.getProperty("file.separator")+path));
		File game = myFileChooser.showSaveDialog(window);
		try {
			save(game, myModel);
			XMLOrderer levelOrder = new XMLOrderer(path,game.getName());
			levelOrder.makeXML(path);
		} catch (NullPointerException e) {
			//User canceled from a save
		} catch (Exception e) {
			
		}
	}
		private void save(File game, Model myModel){
		FileOutputStream fos = null;

		myStream.omitField(Observable.class, "obs");
		myStream.omitField(Observable.class, "changed");
		
		try{
			//myStream.processAnnotations(ModelAnnotations.class);
			myStream.toXML(myModel, new FileWriter(game));
		} catch (NullPointerException e) {
			//User canceled from a save
		}catch (Exception e){
			System.err.println("Error in XML Write: " + e.getMessage());
		}
		finally{
			if(fos != null){
				try{
					fos.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
