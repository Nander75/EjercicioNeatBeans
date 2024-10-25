package com.dam.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.dam.pojo.Empleado;

public class EscribirXMLDomListaEmpleados {

	public static void main(String[] args) {
		
		//Crear la lista empleados
		List<Empleado> listaEmpleados = crearListaEmpleados();
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			
			//Crear el nodo raiz empleados
			Document doc = implementation.createDocument(null, "Empleados", null);
			doc.setXmlVersion("1.0");
			
			for(Empleado emp : listaEmpleados) {
				
				//Crear el elemento empleado
				Element elementoEmpleado = doc.createElement("empleado");
	            doc.getDocumentElement().appendChild(elementoEmpleado);
	            
	            //Crear el elemento ID y añadimos a empleado
	            Element elementoId = doc.createElement("id");
	            Text textoId = doc.createTextNode(String.valueOf(emp.getId()));
	            elementoEmpleado.appendChild(elementoId);
	            elementoId.appendChild(textoId);
	            
	            //Crear el elemento nombre y añadimos a empleado
	            Element elementoNombre = doc.createElement("id");
	            Text textoNombre = doc.createTextNode(String.valueOf(emp.getId()));
	            elementoNombre.appendChild(elementoNombre);
	            elementoNombre.appendChild(textoNombre);
	            
	            //Crear el elemento ID y añadimos a empleado
	            Element elementoApellido = doc.createElement("id");
	            Text textoApellido = doc.createTextNode(String.valueOf(emp.getId()));
	            elementoEmpleado.appendChild(elementoApellido);
	            elementoApellido.appendChild(textoApellido);
	            
	            //Transformar en archivo XML
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // esto es para que aparezca identado y no en una sola linea
	            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // añadir los 4 espacios por tabulador
	            
	            //Definir el archivo de salida y volcar la fuente en el fichero
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(new File("Ficheros/empleados.xml"));
	            transformer.transform(source, result);
	            
	            System.out.println("Archivo XML creado correctamente");
	            
	            
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	private static List<Empleado> crearListaEmpleados() {
		
		List<Empleado> listaEmpleados = new ArrayList<>();
		listaEmpleados.add(new Empleado(1, "Sonic", "The Hedgehog"));
		listaEmpleados.add(new Empleado(2, "Shadow", "The Hedgehog"));
		listaEmpleados.add(new Empleado(3, "Miles", "Prower"));
		listaEmpleados.add(new Empleado(1, "Knuckles", "The Echidna"));
		listaEmpleados.add(new Empleado(1, "Evo", "Robotnik"));
		
		return listaEmpleados;
	}

}
