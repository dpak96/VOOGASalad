package model;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class LoadMatrixFromXML {
private double[][] myMatrix;
	public LoadMatrixFromXML(String fileName) {
		// TODO Auto-generated constructor stub
		load(fileName);
	}
	
	public void load(String fileName){
		try {
		File fXmlFile = new File(".\\src\\model\\"+fileName+"CollisionLibrary.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();
		NodeList rowList = doc.getElementsByTagName("Row");
		myMatrix = new double[rowList.getLength()][rowList.getLength()];
		for (int i = 0; i < rowList.getLength(); i++)
		{
			Element rowElement = (Element) rowList.item(i);			
			String tempStr = rowElement.getAttribute("RowString");
			String[] numStr = tempStr.split(",");
			for (int j = 0; j < rowList.getLength(); j++){
				myMatrix[i][j] = Double.parseDouble(numStr[j]);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public double[][] getMatrix(){
		return myMatrix;
	}
}
