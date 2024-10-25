package com.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFicheroBinarioAleatorio {

	public static void main(String[] args) {
		// Rutal del fichero binario
		String rutaArchivo = "ejemplo.bin";
		
		try {RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw");
		
			//borrar el archivo para comenzar de nuevo
			archivo.setLength(0);
			
			//posicionamos al final de un archivo
			archivo.seek(archivo.length());
			
			//Escribir una cadena como UTF-8
			String texto = "Hello word de forma aleatoria";
			archivo.writeUTF(texto);
			
			//Escribir un entero
			archivo.write(12345);
			
			//Escribir un valor booleano
			archivo.writeBoolean(true);
			
			//Escribir un caracter
			archivo.writeChar('A');
			
			//Escribir un double
			archivo.writeDouble(3.14);
			
			System.out.println("datos subidos correctamente");

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Su base de datos de virus ha sido actualizada");
			e.printStackTrace();
		}

	}

}
