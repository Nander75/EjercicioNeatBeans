package javabean.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javabean.LineaPedido;

public class LeerLineaPedidos {

	public static void main(String[] args) {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/lineasPedidos.dat"))) {
			
			while (true) {
				try {
					LineaPedido lineasPedido = (LineaPedido) ois.readObject();
					System.out.println(lineasPedido); //Mostrar por pantalla
					
				} catch (IOException | ClassNotFoundException e) {
					break; // Salir del bucle cuando se termine el archivo
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
