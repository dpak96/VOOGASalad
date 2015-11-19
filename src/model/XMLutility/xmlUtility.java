package model.XMLutility;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.Article;
import model.Model;

public class xmlUtility {
	XStream myStream;
	Model myModel;
	public xmlUtility(Model model) {
		myStream = new XStream(new DomDriver());
		myModel = model;
	}
	
	public void saveModel(String gameName) {
		FileOutputStream fos = null;
	    try{            
	        String xml = myStream.toXML(myModel);
	        fos = new FileOutputStream(gameName + ".xml");
	        fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
	        byte[] bytes = xml.getBytes("UTF-8");
	        fos.write(bytes);

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
		xml.saveModel("FUCK");
		System.out.println("saved");
	}

}
