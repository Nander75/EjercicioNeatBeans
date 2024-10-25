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

import com.dam.pojo.Direccion;
import com.dam.pojo.Empleado;

public class EscribirListaEmpleadosDom {

    public static void main(String[] args) {
        
        // Crear la lista de empleados
        List<Empleado> listaEmpleados = crearListaEmpleados();
        
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            
            // Crear el nodo raíz <Empleados>
            Document doc = implementation.createDocument(null, "Empleados", null);
            doc.setXmlVersion("1.0");
            
            for (Empleado emp : listaEmpleados) {
                
                // Crear el elemento empleado
                Element elementoEmpleado = doc.createElement("empleado");
                doc.getDocumentElement().appendChild(elementoEmpleado);
                
                // Crear el elemento ID y añadir a empleado
                Element elementoId = doc.createElement("id");
                Text textoId = doc.createTextNode(String.valueOf(emp.getId()));
                elementoEmpleado.appendChild(elementoId);
                elementoId.appendChild(textoId);
                
                // Crear el elemento nombre y añadir a empleado
                Element elementoNombre = doc.createElement("nombre");
                Text textoNombre = doc.createTextNode(emp.getNombre());
                elementoEmpleado.appendChild(elementoNombre);
                elementoNombre.appendChild(textoNombre);
                
                // Crear el elemento apellido y añadir a empleado
                Element elementoApellido = doc.createElement("apellido");
                Text textoApellido = doc.createTextNode(emp.getApellido());
                elementoEmpleado.appendChild(elementoApellido);
                elementoApellido.appendChild(textoApellido);
                
                // Crear el elemento direccion y añadir a empleado
                Element elementoDireccion = doc.createElement("direccion");
                elementoEmpleado.appendChild(elementoDireccion);
                
                Direccion dir = emp.getDireccion();
                
                // Añadir subelementos de direccion
                Element elementoCalle = doc.createElement("calle");
                Text textoCalle = doc.createTextNode(dir.getCalle());
                elementoCalle.appendChild(textoCalle);
                elementoDireccion.appendChild(elementoCalle);
                
                Element elementoCiudad = doc.createElement("ciudad");
                Text textoCiudad = doc.createTextNode(dir.getCiudad());
                elementoCiudad.appendChild(textoCiudad);
                elementoDireccion.appendChild(elementoCiudad);
                
                Element elementoProvincia = doc.createElement("provincia");
                Text textoProvincia = doc.createTextNode(dir.getProvincia());
                elementoProvincia.appendChild(textoProvincia);
                elementoDireccion.appendChild(elementoProvincia);
                
                Element elementoCodigoPostal = doc.createElement("codigoPostal");
                Text textoCodigoPostal = doc.createTextNode(dir.getCodigoPostal());
                elementoCodigoPostal.appendChild(textoCodigoPostal);
                elementoDireccion.appendChild(elementoCodigoPostal);
            }
            
            // Transformar el documento en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Indentación
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // 4 espacios por tabulación
            
            // Definir el archivo de salida y volcar la fuente en el fichero
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Ficheros/empleados.xml"));
            transformer.transform(source, result);
            
            System.out.println("Archivo XML creado correctamente");
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private static List<Empleado> crearListaEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado(1, "Sonic", "The Hedgehog", new Direccion("Calle Verde", "Mobotropolis", "Mobius", "12345")));
        listaEmpleados.add(new Empleado(2, "Shadow", "The Hedgehog", new Direccion("Calle Oscura", "Mobotropolis", "Mobius", "54321")));
        listaEmpleados.add(new Empleado(3, "Miles", "Prower", new Direccion("Calle Rápida", "Mobotropolis", "Mobius", "67890")));
        listaEmpleados.add(new Empleado(4, "Knuckles", "The Echidna", new Direccion("Calle Fuerte", "Angel Island", "Mobius", "13579")));
        listaEmpleados.add(new Empleado(5, "Evo", "Robotnik", new Direccion("Calle Malvada", "Mobotropolis", "Mobius", "24680")));
        
        return listaEmpleados;
    }
}

