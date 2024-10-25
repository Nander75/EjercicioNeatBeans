package com.dam.main;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXMLDOM {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    	
        // Crear una instancia de document builder factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        // Creamos el DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        // Leer el archivo XML
        Document doc = builder.parse(new File("Ficheros/empleados.xml"));
        
        // Normalizar el archivo XML (eliminar espacios y tabuladores que no se necesiten)
        doc.getDocumentElement().normalize();

        // Obtener la lista de elementos que contienen la etiqueta empleado
        NodeList listaEmpleados = doc.getElementsByTagName("empleado");
        
        // Recorrer la lista de empleados 
        for (int i = 0; i < listaEmpleados.getLength(); i++) {
			
        	// Obtener el primer nodo en la lista
        	Node empleado = listaEmpleados.item(i);
        	
        	// Comprobar que el nodo es de tipo ELEMENT_NODE
        	if (empleado.getNodeType() == Node.ELEMENT_NODE) {
				
        		Element elemento = (Element) empleado;
        		
        		// Obtengo el valor del elemento con la etiqueta "id"
        		String id = elemento.getElementsByTagName("id").item(0).getTextContent();
        		String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
        		String apellido = elemento.getElementsByTagName("apellido").item(0).getTextContent();
        		
        		//Imprimir los datos de elementos empleados
        		System.out.println(id);
        		System.out.println(nombre);
        		System.out.println(apellido);
			}
		}
    }
}
