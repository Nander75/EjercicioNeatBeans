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

public class EscribirXML {

    public static void main(String[] args) {
        
        List<Empleado> listaEmpleados = crearListaEmpleados();
        
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            
            Document doc = implementation.createDocument(null, "Empleados", null);
            doc.setXmlVersion("1.0");
            
            for (Empleado emp : listaEmpleados) {
                
                Element elementoEmpleado = doc.createElement("empleado");
                doc.getDocumentElement().appendChild(elementoEmpleado);
                
                Element elementoId = doc.createElement("id");
                Text textoId = doc.createTextNode(String.valueOf(emp.getId()));
                elementoId.appendChild(textoId);
                elementoEmpleado.appendChild(elementoId);
                
                Element elementoNombre = doc.createElement("nombre");
                Text textoNombre = doc.createTextNode(emp.getNombre());
                elementoNombre.appendChild(textoNombre);
                elementoEmpleado.appendChild(elementoNombre);
                
                Element elementoDep = doc.createElement("dep");
                Text textoDep = doc.createTextNode(String.valueOf(emp.getDepartamento()));
                elementoDep.appendChild(textoDep);
                elementoEmpleado.appendChild(elementoDep);
                
                Element elementoSalario = doc.createElement("salario");
                Text textoSalario = doc.createTextNode(String.valueOf(emp.getSalario()));
                elementoSalario.appendChild(textoSalario);
                elementoEmpleado.appendChild(elementoSalario);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("empleados.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo XML creado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Empleado> crearListaEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado(1, "Sonic", 10, 2000.00));
        listaEmpleados.add(new Empleado(2, "Tails", 20, 1500.50));
        listaEmpleados.add(new Empleado(3, "Knuckles", 30, 3000.40));
        listaEmpleados.add(new Empleado(4, "Shadow", 20, 2300.60));
        listaEmpleados.add(new Empleado(5, "Robotnik", 10, 1900.10));
        return listaEmpleados;
    }
}
