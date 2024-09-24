package dam.ad.practica1.javabeans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionClientes {
	
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean salir = false;
		cargarClientesTexto(); // Cargar clientes al inicio
		
		while (!salir) {
			System.out.println("\nELIJA LA OPCIÓN QUE DESEE");
			System.out.println("1. Añadir Clientes");
			System.out.println("2. Ver clientes");
			System.out.println("3. Salir");
			
			int opcion = scanner.nextInt();
			scanner.nextLine(); //Limpiar el buffer
			
			switch (opcion) {
			case 1:
				aniadirCliente();
				break;
			case 2:
				verClientes();
				break;
			case 3:
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}
		}
		
		
	}

	private static void verClientes() {
		
		System.out.println("\nLista de clientes guardados en la app");
		System.out.println("---------------------------------------");
		
		for (Cliente cliente : listaClientes) {
			System.out.println(cliente);
		}
		
	}

	private static void aniadirCliente() {
		
		System.out.println("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.println("Apellido: ");
		String apellido = scanner.nextLine();
		System.out.println("Email: ");
		String email = scanner.nextLine();
		System.out.println("Direccion: ");
		String direccion = scanner.nextLine();
		System.out.println("Fecha Alta: ");
		String fechaAlta = scanner.nextLine();
		System.out.println("Provincia: ");
		String provincia = scanner.nextLine();
		System.out.println("Ciudad: ");
		String ciudad = scanner.nextLine();
		
		Cliente cliente = new Cliente(nombre, apellido, email, direccion, fechaAlta, provincia, ciudad);
		listaClientes.add(cliente);
		System.out.println("Cliente añadido");
		
		// Guardar el cliente en el archivo de texto inmediatamente después de añadirlo
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt", true))) {
			
			writer.write(cliente.getNombre() + ", " + cliente.getApellido() + ", " + cliente.getEmail() 
			+ ", " + cliente.getDireccion() + ", " + cliente.getFechaAlta() + ", " + cliente.getProvincia() + ", " + cliente.getCiudad());
			
			writer.newLine();
			System.out.println("Cliente guardado en archivo de texto.");
			
		} catch (IOException e) {
		
			System.out.println("Error al guardar el cliente en el archivo de texto");
			e.printStackTrace();
		
		}
		
	}

	private static void cargarClientesTexto() {
		
		File file = new File("clientes.txt");
		
		if (!file.exists()) {
			System.out.println("El archivo clientes.txt no existe. No se cargarán clientes");
			return;
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"))) {
			
			String linea;
			while ((linea = reader.readLine()) != null) {
				
				String[] datos = linea.split(",");
				Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
				listaClientes.add(cliente);
				
			}
			
			System.out.println("Clientes cargados desde archivo de texto.");
			
		} catch (IOException e) {
			
			System.out.println("Error al cargar clientes");
			e.printStackTrace();
			
		}
		
	}

}
