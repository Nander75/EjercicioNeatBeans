package paquete.nosecomollamarlo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import paquete.pojo.Cliente;

public class AlmacenarClientes {

	public static void main(String[] args) {
		//Paso 2.1 Crear un array de clientes
		
		Cliente[] clientes = {
				new Cliente("Ana", "García", "ana.garcia@email.com", "Calle Mayor 5", "2023-05-20", "Madrid", "Madrid"),
				new Cliente("Jorge", "El curioso", "jorge.curioso@email.com", "Calle Jungla", "2023-05-25", "Madrid", "Madrid"),
				new Cliente("Michael", "Jackson", "michael.jackson@email.com", "Calle Pop", "1980-05-20", "Maiami", "Maiami"),
				new Cliente("Ankara", "Messi", "ankara.messi@email.com", "Calle Goat", "2023-07-24", "Cataluña", "Barcelona")
		};
		
		//Paso 2.2 Guardar clientes en un archivo binario llamado 'clientes.dat'
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("clientes.dat")))) {
			
			for(Cliente losClientes : clientes) {
				
				oos.writeObject(losClientes); //Guardar cliente en un archivo binario
				
			}
			
			System.out.println("Clientes guardados correctamente");
			
		} catch (IOException e) {
			
			System.out.println("Su base de datos de virus ha sido actualizada");
			e.printStackTrace();
			
		}

	}

}
