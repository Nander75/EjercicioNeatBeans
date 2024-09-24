package dam.ad.uf1;

import java.io.File;

public class ComprobarDirectorio {

	public static void main(String[] args) {
		
		//Instanciamos objeto de la clase File y pasamos el nombre del directorio a comprobar	
		File file = new File("Fichero");
		
		//Verificamos si el fichero o el directorio existe
		if (file.exists()) {
			System.out.println("El fichero o directorio ya existe");
			
			//Verificar si es un directorio o es un fichero
			if (file.isDirectory()) {
				System.out.println("Es un directorio");
				System.out.println("Nombre del directorio: " + file.getName());
				System.out.println("Ruta completa: " + file.getAbsolutePath());
				System.out.println("Tamaño directorio: " + file.length());
				
				//Mostrar lista archivos dentro del directorio
				File[] listaArchivos = file.listFiles();
				System.out.println("\nLista de Archivos del Directorio");
				System.out.println("--------------------------------");
				
				for (File nombre: listaArchivos) {
					System.out.println(nombre.getName());
				}
				
				
			}  else if (file.isFile()) {
				System.out.println("Es un fichero");
			} else {
				System.out.println("El elemento no existe.");
			}
		
		}

	}

}
