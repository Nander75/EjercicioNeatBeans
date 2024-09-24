package dam.ad.uf1;

import java.io.File;
import java.io.IOException;

public class CrearFichero {
	
	public static void main(String[] args) {
		
		//Ruta del directorio donde vamos a crear el archivo
		String nombreDirectorio = "Ficheros";
		
		//Creamos un objeto File para poder crear el fichero "ejemplo.txt" dentro del directorio Ficheros
		File archivo = new File(nombreDirectorio, "ejemplo.txt");
		
		//Finalmente creamos el fichero
		if (archivo.exists()) {
			System.out.println("El archivo ya existe, no se ha creado ning�n fichero nuevo");
		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				System.out.println("El fichero no se ha creado por alg�n motivo desconocido");
				e.printStackTrace();
			}
			
			System.out.println("Archivo creado con �xito");
		}
		
	}

}
