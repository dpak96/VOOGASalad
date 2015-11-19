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
import model.Article;
import model.Model;
import model.Position;

public class xmlUtility {
	XStream myStream;
	Model myModel;
	public xmlUtility(Model model) {
		myStream = new XStream(new DomDriver());
		myModel = model;
	}
	
	public Model loadModel(String file) {
		
		try {
			FileReader reader = new FileReader(file);
			
			myStream = new XStream(new DomDriver());
			myStream.processAnnotations(Model.class);
			Object readObject = myStream.fromXML(new File(file));
			System.out.println("Read" + readObject);
			return (Model) readObject;
//			myStream.alias("Model", Model.class);
//			myStream.aliasField("myEvents", Model.class, "myEvents");
//			myStream.aliasField("myButtonMap", Model.class, "myButtonMap");
//			//myStream.addImplicitCollection(Article.class, "myArticles");
//			myStream.aliasField("myExecutables", Model.class, "myExecutables");
//			myStream.aliasField("myConditions", Model.class, "myConditions");
//			myStream.aliasField("myViewpoint", Model.class, "myViewpoint");
//			myStream.aliasField("myCharacter", Model.class, "myCharacter");
//			myStream.aliasField("myImageFile", Article.class, "myImageFile");
//			myStream.aliasField("myXBuffer", Article.class, "myXBuffer");
//			myStream.aliasField("myYBuffer", Article.class, "myYBuffer");
//			myStream.aliasField("myWidth", Article.class, "myWidth");
//			myStream.aliasField("myHeight", Article.class, "myHeight");
//			myStream.aliasField("myPosition", Article.class, "myPosition");
//			myStream.aliasField("myXVelocity", Position.class, "myEvents");
//			myStream.aliasField("myX", Position.class, "myX");
//			myStream.aliasField("myY", Position.class, "myY");
//			myStream.aliasField("myOrientation", Position.class, "myOrientation");
//			myStream.aliasField("myDirection", Position.class, "myDirection");
//			myStream.aliasField("isValid", Position.class, "isValid");
//			Model model = (Model) myStream.fromXML(reader);
//			System.out.println("Success!");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

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
		private void save(File game){

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
		Model newModel = xml.loadModel("test.xml");
		System.out.println("loaded");
		for(Article a: newModel.getArticles()) {
			System.out.println(a.getX());
		}
		System.out.println("saved");
	}

}
