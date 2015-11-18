package model;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javafx.scene.paint.Color;

public class Matrix {
	protected double[][] myMatrix;
	private final double DEFAULT_COLLISION_STATUS = 0;
	public Matrix(int dimension) {
		// TODO Auto-generated constructor stub
		myMatrix = new double[dimension][dimension];
		initializeMatrix(DEFAULT_COLLISION_STATUS);
		writeXML();
	}
	
	public void initializeMatrix(double collisionStatus){
		for (int i = 0; i < myMatrix.length; i++){
			for (int j = 0; j < myMatrix.length; j++){
				myMatrix[i][j] = collisionStatus;
			}
		}
	}
	
	public void writeXML(){
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element matrixXML = doc.createElement("Matrix");
			doc.appendChild(matrixXML);
			
			for (int i = 0; i < myMatrix.length; i++){
				Element row = doc.createElement("Row");
				matrixXML.appendChild(row);
				String tempString = "";
				for (int j = 0; j < myMatrix.length-1; j++){
					tempString = tempString + Double.toString(myMatrix[i][j]) + ",";
				}
				tempString = tempString + Double.toString(myMatrix[i][myMatrix.length-1]);
				row.appendChild(doc.createTextNode(tempString));
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			StreamResult result = new StreamResult(new File(".\\src\\model\\DamageCollisionLibrary.xml"));

			transformer.transform(source, result);

		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}
	
	
	public void addRowAndColumn(){
//		try {
//    		File fXmlFile = new File(".\\src\\ColorLibrary\\model\\DamageCollisionLibrary.xml");
//    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//    		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//    		Document doc = dBuilder.parse(fXmlFile);
//
//    		doc.getDocumentElement().normalize();
//    		NodeList collisionList = doc.getElementsByTagName("Row");
//    		for (int i = 0; i < collisionList.getLength(); i++)
//    		{
//    			Element colorNode = (Element) collisionList.item(i);
//    			if (Double.parseDouble(colorNode.getAttribute("index")) == index)
//    			{
//    				double r = getColor(colorNode,"r");
//    				double g = getColor(colorNode,"g");
//    				double b = getColor(colorNode,"b");
//    				c = Color.rgb((int)r, (int)g, (int)b);
//    			}
//    		}
//    	} catch (Exception e) {
//
//    		e.printStackTrace();
//    	}
//		return c;
	}
}
