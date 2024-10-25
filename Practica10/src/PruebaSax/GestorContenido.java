package PruebaSax;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestorContenido extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		
		System.out.println("Comienzo el documento XML\n");
		
	}
	
}
