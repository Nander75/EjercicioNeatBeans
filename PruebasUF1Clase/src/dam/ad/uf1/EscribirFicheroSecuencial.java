package dam.ad.uf1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroSecuencial {

	public static void main(String[] args) {
		// Ruta del fichero ya existente
		String rutaArchivo = "Ficheros/ejemplo.txt";
		
		// Escribimos la frase "Hello World" en el fichero de forma secuencial
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo,true));
			escritor.write("Hello word");
			escritor.newLine();
		} catch (IOException e) {
			System.out.println("Ocurrió un error al escribir el archivo");
			e.printStackTrace();
		}

	}

}
