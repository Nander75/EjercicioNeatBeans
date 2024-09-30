package paquete.nosecomollamarlo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import paquete.pojo.Cliente;

public class MostrarClientes {

	public static void main(String[] args) {
		
		//Leer los clientes desde el archivo binario clientes.dat
		
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("clientes.dat")))){
			
			//Leer cada cliente y mostrarlo por consola
			
			while (true) {
			
				try {
					Cliente cliente = (Cliente) ois.readObject(); //Pa leer el cliente
					System.out.println(cliente);
					
				} catch (IOException | ClassNotFoundException e) {
					break; //The End
				}
				
			}
			
			System.out.println("Todos los clientes han sido leidos");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
