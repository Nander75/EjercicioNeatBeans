package PruebasXStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class EscribirXMLSCXStream {

	public static void main(String[] args) {
		
		XStream xstream = new XStream();
		
		xstream.addPermission(NoTypePermission.NONE);
		xstream.addPermission(NullPermission.NULL);
		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
		
		Class[] clases = {ListaObjeto.class, Objeto.class};  
		xstream.allowTypes(clases);
		
		xstream.allowTypesByWildcard(new String[] { "dam.ad.pruebasXStream.*" });
		
		xstream.alias("ListaObjetos", ListaObjeto.class);
		xstream.alias("Objeto", Objeto.class);
		
		xstream.addImplicitCollection(ListaObjeto.class, "ListaObjetos");
		
		try {
			
			FileInputStream fis = new FileInputStream("Ficheros/objetos.xml");
			ListaObjeto listaObj = (ListaObjeto) xstream.fromXML(fis);
			
			/*
			 * for (Objeto obj: listaObj.getClass()) { System.out.println("Nombre: " +
			 * obj.getNombre() + ", Valor: " + obj.getValor()); }
			 */
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
