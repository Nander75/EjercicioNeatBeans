package com.dam.main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;  // Importación correcta de Element
import org.w3c.dom.Text;    // Importación para crear nodos de texto

public class EscribirXML {

    public static void main(String[] args) {
        
        try {
            
            //Crear una instancia de DocumentBuilderFactoy
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            //Crear el parser
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            //DOMImplementation nos facilita el método createDocument para crear un documento XML inicial
            DOMImplementation implementation = builder.getDOMImplementation();
            
            //Creo un documento vacio indicando el nombre del nodo raíz
            Document doc = implementation.createDocument(null, "empleados", null);
            
            //Asignamos la versión
            doc.setXmlVersion("1.0");
            
            //Crear primer elemento empleado1 y añadirlo al nodo raíz
            Element elementoEmpleado1 = doc.createElement("empleado");
            doc.getDocumentElement().appendChild(elementoEmpleado1);
            
            //Crear elementos finales en el documento XML
            //Primero creo el elemento (Element o text) y luego lo asigno a un nodo existente (elementoEmpleado1 o elementoId1)
            Element elementoId1 = doc.createElement("id");
            Text textoId1 = doc.createTextNode("1");
            elementoEmpleado1.appendChild(elementoId1);
            elementoId1.appendChild(textoId1);
            
            //AQUI VAMOS A SEGUIR AÑADIENDO ELEMENTOS
            Element elementoNombre1 = doc.createElement("nombre");
            Text textoNombre1 = doc.createTextNode("Axe");
            elementoEmpleado1.appendChild(elementoNombre1);
            elementoNombre1.appendChild(textoNombre1);
            
            Element elementoApellido1 = doc.createElement("apellido");
            Text textoApellido1 = doc.createTextNode("Leon");
            elementoEmpleado1.appendChild(elementoApellido1);
            elementoApellido1.appendChild(textoApellido1);
            
            //SEGUIMOS AÑADIENDO ELEMENTO
            Element elementoEmpleado2 = doc.createElement("empleado");
            doc.getDocumentElement().appendChild(elementoEmpleado2);
            
            Element elementoNombre2 = doc.createElement("nombre");
            Text textoNombre2 = doc.createTextNode("Sonic");
            elementoEmpleado2.appendChild(elementoNombre2);
            elementoNombre2.appendChild(textoNombre2);
            
            Element elementoApellido2 = doc.createElement("apellido");
            Text textoApellido2 = doc.createTextNode("The Hedgedhog");
            elementoEmpleado2.appendChild(elementoApellido2);
            elementoApellido2.appendChild(textoApellido2);
            
            //Una vez que hemos generado la estructura, creamos la fuente XML a partir de la estructura
            DOMSource source = new DOMSource(doc);
            
            //Obtenemos un TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            //Le damos formato y realizamos la transformación del documento fichero
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // esto es para que aparezca identado y no en una sola linea
            transformer.setOutputProperty(OutputKeys.METHOD, "xml"); // para que muestre en el xml, la versión y la codificación
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // añadir los 4 espacios por tabulador
            
            //Defino el canal de salida y volcamos la fuente XML en el fichero
            StreamResult result = new StreamResult(new File("Ficheros/empleados.xml"));
            transformer.transform(source, result);
            
            System.out.println("Archivo XML creado correctamente");
            
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

