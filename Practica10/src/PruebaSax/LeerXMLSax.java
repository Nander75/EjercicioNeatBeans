package PruebaSax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class LeerXMLSax {

	public static void main(String[] args) {
		
		try {
			
			// Crear un SAXParsetFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			
			//Crear un SAXParset
			SAXParser saxParser = factory.newSAXParser();
			
			//Obtener un XMLReader 
			XMLReader procXML = saxParser.getXMLReader();
			
			//Crear manejar eventos
			//ManejadorXML handler = new ManejadorXML();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
