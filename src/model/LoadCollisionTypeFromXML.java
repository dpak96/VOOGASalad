package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LoadCollisionTypeFromXML {
	private final String FILENAME = "CollisionTypeLibrary";
	private List<String> collisionTypeList= new ArrayList<String>();
	public LoadCollisionTypeFromXML() {
		// TODO Auto-generated constructor stub
		load();
	}
	
	public void load(){
		try {
			File fXmlFile = new File(".\\src\\model\\"+FILENAME+".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			NodeList rowList = doc.getElementsByTagName("Row");
			for (int i = 0; i < rowList.getLength(); i++)
			{
				Element rowElement = (Element) rowList.item(i);			
				String tempStr = rowElement.getAttribute("RowString");
				collisionTypeList.add(tempStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getCollisionTypeList(){
		return collisionTypeList;
	}
}
	
