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
		System.out.println("where is my XML");
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element matrixXML = doc.createElement("Matrix");
			doc.appendChild(matrixXML);
			
			for (int i = 0; i < myMatrix.length; i++){
				Element row = doc.createElement("Row" + Integer.toString(i));
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
		
	}
}
