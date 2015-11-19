package model;

import java.io.File;
import java.util.List;

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

public class WriteCollisionTypeToXML {
	private final String FILENAME = "CollisionTypeLibrary";
	public WriteCollisionTypeToXML(List<String> typeList) {
		// TODO Auto-generated constructor stub
		write(typeList);
	}
	
	private void write(List<String> typeList) {
		// TODO Auto-generated method stub
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element matrixXML = doc.createElement("Collision");
			doc.appendChild(matrixXML);
			
			for (int i = 0; i < typeList.size(); i++){
				Element row = doc.createElement("Type");
				matrixXML.appendChild(row);
				row.appendChild(doc.createTextNode(typeList.get(i)));
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			StreamResult result = new StreamResult(new File(".\\src\\model\\"+FILENAME+".xml"));

			transformer.transform(source, result);

		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}
}
