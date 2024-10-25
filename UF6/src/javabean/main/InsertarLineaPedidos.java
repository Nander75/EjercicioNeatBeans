package javabean.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import javabean.LineaPedido;
import javabean.Producto;

public class InsertarLineaPedidos {

	public static void main(String[] args) {
		
		//Crear algunos productos
		Producto producto1 = new Producto(1, "Carne", 5.55);
		Producto producto2 = new Producto(2, "Queso", 2.99);
		Producto producto3 = new Producto(1, "Lechuga", 1.99);
		Producto producto4 = new Producto(1, "Pan", 0.99);
		Producto producto5 = new Producto(1, "Café", 2.99);
		
		// Inicializar un array de 5 objetos LineaPedido
		
		LineaPedido[] lineaPedidos = new LineaPedido[5];
	
	
		//Crear las lineas de pedidos con diferentes productos
		lineaPedidos[0] = new LineaPedido(1, "producto1", 2, 232.32, "07-10-2024");
		lineaPedidos[1] = new LineaPedido(1, "producto3", 2, 232.32, "07-10-2024");
		lineaPedidos[2] = new LineaPedido(1, "producto2", 1, 432.32, "15-10-2024");
		lineaPedidos[3] = new LineaPedido(1, "producto4", 3, 632.32, "17-10-2024");
		
		//Escribir los objetos LineaPedido en el fichero binario "lineasPedidos.dat"
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ficheros/lineasPedidos.dat"))) {
			
			for (LineaPedido lineaPedido : lineaPedidos) {
				oos.writeObject(lineaPedido); //Escribo cada objeto en el fichero binario
			}
			
			System.out.println("Datos de las lineas introducidas correctamente en el fichero");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
