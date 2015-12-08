package level.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import startscreen.GameCreation;

public class XMLOrderer {

	protected Document myXML;
	protected Element myFile;
	protected File myOldFile;

	public XMLOrderer(String previous, String pathName) throws SAXException, IOException {
		try {
			myOldFile = new File(System.getProperty("user.home") + System.getProperty("file.separator")
					+ "SquirtleSquadGames" + System.getProperty("file.separator") + previous
					+ System.getProperty("file.separator") + previous + ".xml");
			//System.out.println(System.getProperty("user.home") + System.getProperty("file.separator")
				//	+ "SquirtleSquadGames" + System.getProperty("file.separator") + previous);
			DocumentBuilderFactory xmlFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder xmlBuilder = xmlFac.newDocumentBuilder();
			myXML = xmlBuilder.parse(myOldFile);
			myFile = (Element) myXML.getElementsByTagName("file").item(0);
			if (!levelExists(myXML, pathName)) {
				Element ordering = myXML.createElement("order");
				ordering.setTextContent(Integer.toString(getMaxLevel(myXML) + 1));
				myFile.appendChild(ordering);
				Element name = myXML.createElement("level");
				name.setTextContent(pathName);
				myFile.appendChild(name);
			}
		} catch (Exception e) {
			
		}
	}
	
	public XMLOrderer(GameCreation gameCreation){
		try {
			DocumentBuilderFactory xmlFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder xmlBuild;
			xmlBuild = xmlFac.newDocumentBuilder();
			myXML = xmlBuild.newDocument();
			myFile = myXML.createElement("file");
			myXML.appendChild(myFile);
			for(int i:gameCreation.getLevelMap().keySet()){
				Element ordering = myXML.createElement("order");
				ordering.setTextContent(Integer.toString(i));
				myFile.appendChild(ordering);
				Element name = myXML.createElement("level");
				name.setTextContent(gameCreation.getLevelMap().get(i));
				myFile.appendChild(name);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void makeXML(String filename) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transform = factory.newTransformer();
			DOMSource src = new DOMSource(myXML);
			StreamResult result = new StreamResult(new File(System.getProperty("user.home")
					+ System.getProperty("file.separator") + "SquirtleSquadGames" + System.getProperty("file.separator")
					+ filename + System.getProperty("file.separator") + filename + ".xml"));
			transform.transform(src, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public XMLOrderer() {
		try {
			DocumentBuilderFactory xmlFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder xmlBuild;
			xmlBuild = xmlFac.newDocumentBuilder();
			myXML = xmlBuild.newDocument();
			myFile = myXML.createElement("file");
			myXML.appendChild(myFile);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int getMaxLevel(Document xml) {
		NodeList levels = xml.getElementsByTagName("order");
		ArrayList<Integer> levelVals = new ArrayList<Integer>();
		for (int i = 0; i < levels.getLength(); i++) {
			levelVals.add(Integer.parseInt(levels.item(i).getTextContent()));
		}
		Collections.sort(levelVals);
		try{
		return levelVals.get(levelVals.size() - 1);
		}catch(Exception e){
			return 0;
		}
	}

	private boolean levelExists(Document xml, String pathname) {
		NodeList levels = xml.getElementsByTagName("level");
		ArrayList<String> levelNames = new ArrayList<String>();
		for (int i = 0; i < levels.getLength(); i++) {
			levelNames.add(levels.item(i).getTextContent());
		}
		return levelNames.contains(pathname);
	}
}
