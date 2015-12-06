package level.manager;

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

public class OrdererParser {
	
	private Document myXML;
	private Map<Integer,String> myLevelMap;
	
	public OrdererParser(File file) throws SAXException, IOException{
		try {
			DocumentBuilderFactory xmlFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder xmlBuilder;
			xmlBuilder = xmlFac.newDocumentBuilder();
			myXML = xmlBuilder.parse(file);
			myXML.getDocumentElement().normalize();
			myLevelMap = makeMap();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] getLevelFiles(){
		NodeList levelFiles = myXML.getElementsByTagName("level");
		String[] ret = new String[levelFiles.getLength()];
		for(int i = 0; i<ret.length;i++){
			ret[i] = levelFiles.item(i).getTextContent();
		}
		return ret;
	}
	
	public int[] getLevelOrder(){
		NodeList levelNums = myXML.getElementsByTagName("order");
		int[] ret = new int[levelNums.getLength()];
		for(int j = 0; j<ret.length;j++){
			ret[j] = Integer.parseInt(levelNums.item(j).getTextContent());
		}
		return ret;
	}
	
	private HashMap<Integer, String> makeMap(){
		int[] nums = getLevelOrder();
		String[] files = getLevelFiles();
		HashMap<Integer,String> ret = new HashMap<Integer,String>();
		for(int k = 0; k<nums.length; k++){
			ret.put(nums[k], files[k]);
		}
		return ret;
	}
	
	public String getLevel(int order){
		return myLevelMap.get(order);
	}
	
	public Map<Integer,String> getLevelMap(){
		return myLevelMap;
	}
	
}
