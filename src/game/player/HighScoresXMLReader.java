package game.player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class HighScoresXMLReader {

	private Map<Integer,String> myScoresMap;
	private Document myXML;
	
	public HighScoresXMLReader(String gameName) throws SAXException, IOException, ParserConfigurationException{
		myScoresMap = new HashMap<Integer, String>();
		DocumentBuilderFactory xmlFac = DocumentBuilderFactory.newInstance();
		DocumentBuilder xmlBuilder;
		xmlBuilder = xmlFac.newDocumentBuilder();
		File file = new File(System.getProperty("user.home") + System.getProperty("file.separator")
				+ "SquirtleSquadGames" + System.getProperty("file.separator") + gameName
				+ System.getProperty("file.separator") + "scores" + ".xml");
		if(file.exists()){
		System.out.println("EXISTS");
		myXML = xmlBuilder.parse(file);
		myXML.getDocumentElement().normalize();
		myScoresMap = makeMap();
		}
		else{
			System.out.println(gameName + " DOESNT EXIST");
		}
	}
	
	private HashMap<Integer, String> makeMap(){
		int[] nums = getScores();
		String[] files = getPlayers();
		HashMap<Integer,String> ret = new HashMap<Integer,String>();
		for(int k = 0; k<nums.length; k++){
			ret.put(nums[k], files[k]);
		}
		return ret;
	}
	
	public int[] getScores(){
		NodeList scores = myXML.getElementsByTagName("score");
		int[] ret = new int[scores.getLength()];
		for(int j = 0; j<ret.length;j++){
			ret[j] = Integer.parseInt(scores.item(j).getTextContent());
		}
		return ret;
	}
	
	public String[] getPlayers(){
		NodeList playerNames = myXML.getElementsByTagName("player");
		String[] ret = new String[playerNames.getLength()];
		for(int j = 0; j<ret.length;j++){
			ret[j] = playerNames.item(j).getTextContent();
		}
		return ret;
	}
	
	public Map<Integer,String> getScoreMap(){
		return myScoresMap;
	}
}
