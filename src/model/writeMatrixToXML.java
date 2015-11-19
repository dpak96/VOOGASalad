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

public class WriteMatrixToXML {
	public WriteMatrixToXML(double[][] matrix, String fileName) {
		// TODO Auto-generated constructor stub
		write(matrix, fileName);
	}
	
	public void write(double[][] matrix, String fileName){
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element matrixXML = doc.createElement("Matrix");
			doc.appendChild(matrixXML);
			
			for (int i = 0; i < matrix.length; i++){
				Element row = doc.createElement("Row");
				matrixXML.appendChild(row);
				String tempString = "";
				for (int j = 0; j < matrix.length-1; j++){
					tempString = tempString + Double.toString(matrix[i][j]) + ",";
				}
				tempString = tempString + Double.toString(matrix[i][matrix.length-1]);
				row.appendChild(doc.createTextNode(tempString));
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			StreamResult result = new StreamResult(new File(".\\src\\model\\"+fileName+"CollisionLibrary.xml"));

			transformer.transform(source, result);

		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}
	

}
