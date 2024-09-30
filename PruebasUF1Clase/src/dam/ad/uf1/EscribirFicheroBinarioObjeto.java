package dam.ad.uf1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javabeans.Alumno;

public class EscribirFicheroBinarioObjeto {

	public static void main(String[] args) {
		
		//Creamos una Array de objetos de tipo alumno
		Alumno[] alumnos = {
				new Alumno("Juan", 20, "2DAM"),
				new Alumno("Miguel", 19, "2DAM"),
				new Alumno("Carlos", 21, "2DAM"),
				new Alumno("Jaime", 28, "2DAM"),
				new Alumno("Pedro", 19, "2DAM")
		};
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ficheros/Alumnos.txt"))) {
			//Para cada objeto de tipo Alumno en el array alumno, lo atribuimos en el archivo
			
			for(Alumno alumno : alumnos) {
				oos.writeObject(alumno);
			}
			
			System.out.println("Alumnos subidos correctamente al archivo");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
