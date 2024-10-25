package com.dam.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.dam.pojo.Empleado;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class GenerarArchivoBinarioEmpleadosXStream {

	public static void main(String[] args) {
		
		//Paso 1: Crear la lista empleados
		ListaEmpleados listaEmpleados = crearArrayEmpleados();
		
		//Paso 2: Crear el archivo binario empleadosObj.dat
		
		crearArchivoBinario(listaEmpleados);
		
		//Paso 3: generar el archivo empleadosXStream.xml usando XStream (serializar de Java a XML)
		generarXMLDesdeBinario();
		
		//Paso 4: leer el archivo xml y convertirlo nuevamente a objetos (deserializar XML a Java)
		leerArchivoXML();
		
	}
	
	

	private static void leerArchivoXML() {
		
		//Crear la instancia XStream
		XStream xstream = new XStream();
		
		//Configurar los permisos de seguridad
		
		xstream.addPermission(NoTypePermission.NONE);
		xstream.addPermission(NullPermission.NULL);
		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
		
		//Específicar las clases permitidas
		Class[] clasesPermitidas = { ListaEmpleados.class, Empleado.class };
		xstream.allowTypes(clasesPermitidas);
		
		//Permitir cualquier tipo procedente del mismo paquete
		xstream.allowTypesByWildcard(new String[] { "com.dam.**" });
		
		//Alias para las etiquetas del XML (nodo raiz y secundario)
		xstream.alias("Empleados", ListaEmpleados.class);
		xstream.alias("empleados", Empleado.class);
		
		//Para que no aparezca el atributo listaEmpleados de la clase ListaObjetos
		xstream.addImplicitCollection(ListaEmpleados.class, "listaEmpleados");
		
		//Leer el archivo XML y convertirlo a objetos de tipo Empleado
		try (FileInputStream fis = new FileInputStream("Ficheros/empleadosXStream.xml")) {
			
			ListaEmpleados listaEmpleados = (ListaEmpleados) xstream.fromXML(fis);
			
			//Mostrar los empleados leídos en el XML
			for (Empleado emp: listaEmpleados.getListaEmpleados()) {
				
				System.out.println("ID: " + emp.getId());
				System.out.println("Nombre: " + emp.getNombre());
				System.out.println("Departamento: " + emp.getDep());
				System.out.println("Salario: " + emp.getSalario());
				
			}
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.out.println("Ha ocurrido un error inesperado");
			e.printStackTrace();
			
		}
		
		
	}



	private static void generarXMLDesdeBinario() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/empleadosObj.dat"))){
			
			try {
				
				ListaEmpleados listaEmpleados = (ListaEmpleados) ois.readObject();
				
				//Crear la instancia de XStream
				
				XStream xstream = new XStream();
				
				//Configurar los permisos de seguridad
				
				xstream.addPermission(NoTypePermission.NONE);
				xstream.addPermission(NullPermission.NULL);
				xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
				
				//Específicar las clases permitidas
				Class[] clasesPermitidas = { ListaEmpleados.class, Empleado.class };
				xstream.allowTypes(clasesPermitidas);
				
				//Permitir cualquier tipo procedente del mismo paquete
				xstream.allowTypesByWildcard(new String[] { "com.dam.**" });
				
				//Alias para las etiquetas del XML (nodo raiz y secundario)
				xstream.alias("Empleados", ListaEmpleados.class);
				xstream.alias("empleados", Empleado.class);
				
				//Para que no aparezca el atributo listaEmpleados de la clase ListaObjetos
				xstream.addImplicitCollection(ListaEmpleados.class, "listaEmpleados");
				
				//Escribir el archivo XML
				try (FileOutputStream fos = new FileOutputStream("Ficheros/empleadosXStream.xml")) {
					
					xstream.toXML(listaEmpleados, fos);
					System.out.println("3. Archivo XML empleadosXStream.xml generado con éxito");
					
				} catch (Exception e) {
					
					System.out.println("No se encuentra el archivo especificado o ha ocurrido un error inesperado");
					e.printStackTrace();
					
				}
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}



	private static void crearArchivoBinario(ListaEmpleados listaEmpleados) {
		
		try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("Ficheros/empleadosObj.dat"))){
			
			oss.writeObject(listaEmpleados);
			System.out.println("2. Archivo binario empleadoObj.dat creado con éxito");
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}
		
	}



	private static ListaEmpleados crearArrayEmpleados() {
		
		// Arrays del enunciado
		
		String[] nombres = {"Alberto", "Guillermo", "Alejandro", "Ana", "Patricia"};
		int [] departamentos = {10, 20, 30, 20, 10};
		double [] salarios= {2000.0, 1500.50, 3000.40, 2300.60, 1900.10};
		
		//Crear la instancia de ListaEmpleados
		ListaEmpleados listaEmpleados = new ListaEmpleados();
		
		//Interar sobre los arrays para crear los objetos empleado y añadirlos a la lista
		for (int i = 0; i < nombres.length; i++) {
			
			listaEmpleados.addEmpleado(new Empleado(i+1, nombres[i], departamentos[i], salarios[i]));
			
		}
		
		System.out.println("1. Lista de empleados creada correctamente");
		
		return listaEmpleados;
	}

}
