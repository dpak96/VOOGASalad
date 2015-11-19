package model.XMLutility;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import model.Article;
import model.Model;

public class xmlUtility {
	XStream myStream;
	Model myModel;
	public xmlUtility(Model model) {
		myStream = new XStream(new DomDriver());
		myModel = model;
	}
	
	public void saveModel(Window window) {
		FileChooser myFileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter =
				new FileChooser.ExtensionFilter("Java files (*.xml)", "*.xml");
		myFileChooser.getExtensionFilters().add(extensionFilter);
		myFileChooser.setTitle("Howdy");
		File game = myFileChooser.showSaveDialog(window);
		try {
			save(game);
//	      o.writeObject(myController.getMyScene().getAllData().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public void save(File game){
		FileOutputStream fos = null;

		myStream.omitField(Observable.class, "obs");
		myStream.omitField(Observable.class, "changed");
		for(Article a: myModel.getArticles()) {
			a.destroyBitMap();
			System.out.println("destroyed");
		}
		myModel.getViewpoint().destroyBitMap();
		myModel.getCharacter().destroyBitMap();
		try{
			myStream.toXML(myModel, new FileWriter(game));
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
		Article test = new Article("Goomba.png", 100, 100, true);
		model.addArticle(test);
		xmlUtility xml = new xmlUtility(model);
		//xml.saveModel("test");
		System.out.println("saved");
	}

}
