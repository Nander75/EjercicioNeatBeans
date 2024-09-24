package dam.ad.uf1;

import java.io.File;

public class CrearDirectorioClase {

	public static void main(String[] args) {
		
		String nombreDirectorio = "Ficheros";
		
		File directorio = new File(nombreDirectorio);
		
		if (directorio.exists()) {
			System.out.println("El directorio existe");
		} else {
			System.out.println("El directorio no exite");
		}

	}

}
