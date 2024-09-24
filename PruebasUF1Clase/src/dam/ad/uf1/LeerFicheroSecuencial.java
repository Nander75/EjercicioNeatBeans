package dam.ad.uf1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LeerFicheroSecuencial {
	
	public static void main(String[] args) {
		
		//Ruta del fichero que voy a leer
		String rutaArchivo = "Ficheros/ejemplo.txt";
		
		//Leer el archivo de forma secuencial
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
			String linea;
		} catch (FileNotFoundException e) {
			System.out.println("Ocurrió un error al leer el archivo");
			e.printStackTrace();
		}
		
	}

}
