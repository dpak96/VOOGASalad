package game.player;

import java.io.File;
import java.io.IOException;

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
import org.xml.sax.SAXException;

public class HighScoresXMLWriter {

	protected Document myXML;
	protected Element myFile;
	protected File myOldFile;
	private String myGameName;

	public HighScoresXMLWriter(String gameName, String score, String player)
			throws ParserConfigurationException, SAXException, IOException {
		myGameName = gameName;
		myOldFile = new File(System.getProperty("user.home") + System.getProperty("file.separator")
				+ "SquirtleSquadGames" + System.getProperty("file.separator") + gameName
				+ System.getProperty("file.separator") + "scores" + ".xml");
		DocumentBuilderFactory xmlFac = DocumentBuilderFactory.newInstance();
		DocumentBuilder xmlBuilder = xmlFac.newDocumentBuilder();
		if (myOldFile.exists()) {
			myXML = xmlBuilder.parse(myOldFile);
			myFile = (Element) myXML.getElementsByTagName("file").item(0);
		}
		else{
			myXML = xmlBuilder.newDocument();
			myFile = myXML.createElement("file");
			myXML.appendChild(myFile);
		}
		addHighScore(score,player);
		makeXML();
	}

	private void addHighScore(String score, String player) {
		Element scorer = myXML.createElement("player");
		scorer.setTextContent(player);
		myFile.appendChild(scorer);
		Element value = myXML.createElement("score");
		value.setTextContent(score);
		myFile.appendChild(value);
	}
	
	public void makeXML() {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transform = factory.newTransformer();
			DOMSource src = new DOMSource(myXML);
			StreamResult result = new StreamResult(new File(System.getProperty("user.home")
					+ System.getProperty("file.separator") + "SquirtleSquadGames" + System.getProperty("file.separator")
					+ myGameName + System.getProperty("file.separator") + "scores" + ".xml"));
			transform.transform(src, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
