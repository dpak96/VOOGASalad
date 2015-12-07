package model.XMLutility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import level.manager.LevelManager;
import level.manager.XMLOrderer;
import main.VoogaProperties;
import model.Model;
import model.article.Article;
import model.article.Position;

public class xmlUtility {
	XStream myStream;
	Model myModel;
	
	public xmlUtility() {
		this(new Model());
	}
	
	public xmlUtility(Model model) {
		myStream = new XStream(new DomDriver());
		myModel = model;
	}
	
	public Model loadModel(Window window) {
		FileChooser myFileChooser = new FileChooser();
		System.out.println("File Chooser 1");
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
			myStream.processAnnotations(Model.class);
			System.out.println(file.toString());
			Object readObject = myStream.fromXML(file);
			System.out.println("Read" + readObject);
			System.out.println(((Model) readObject));
			return (Model) readObject;
			
		} catch (NullPointerException e) {
			//User canceled from a save
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void saveModel(Window window, String path) {
		FileChooser myFileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter =
				new FileChooser.ExtensionFilter("Java files (*.xml)", "*.xml");
		myFileChooser.getExtensionFilters().add(extensionFilter);
		myFileChooser.setTitle("Howdy");
		myFileChooser.setInitialDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "SquirtleSquadGames" + System.getProperty("file.separator")+path));
		File game = myFileChooser.showSaveDialog(window);
		try {
			save(game);
			XMLOrderer levelOrder = new XMLOrderer(path,game.getName());
			levelOrder.makeXML(path);
//	      o.writeObject(myController.getMyScene().getAllData().get(0));
		} catch (NullPointerException e) {
			//User canceled from a save
		} catch (Exception e) {
			
		}
	}
		private void save(File game){

		FileOutputStream fos = null;

		myStream.omitField(Observable.class, "obs");
		myStream.omitField(Observable.class, "changed");
		myStream.omitField(LevelManager.class, "myLevelManager");
		for(Article a: myModel.getArticles()) {
			a.destroyBitMap();
			System.out.println("destroyed");
		}
		myModel.getViewpoint().destroyBitMap();
		myModel.getCharacter().destroyBitMap();
		try{
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
	
	public static void main (String args[]) {
		Model model = new Model();
		model.initialize();
		Article test = new Article("Goomba", 100, 100, true);
		model.addArticle(test);
		xmlUtility xml = new xmlUtility(model);
		//Model newModel = xml.loadModel("testing.xml");
		System.out.println("loaded");
		/*for(Article a: newModel.getArticles()) {
			System.out.println(a.getX());
		}*/
		System.out.println("saved");
	}

}
