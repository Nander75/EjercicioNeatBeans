package com.main;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.pojo.Asignatura;

public class AlmacenarAsignaturas {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Asignatura[] asignaturas = new Asignatura[5];
		
		String nombre;
		String codigo;
		int horas;
		String profesor;	
		
		for (int i = 0; i < asignaturas.length; i++) {
			
			System.out.println("Introduce los datos de la asignatura");
			System.out.println("-----------------------------------");
			
			System.out.println("Introduce el nombre de la asignatura");
			nombre = sc.nextLine();
			System.out.println("Introduce el código de la asignatura");
			codigo = sc.nextLine();
			System.out.println("Introduce el nº de horas de la asignatura");
			horas = sc.nextInt();
			System.out.println("Introduce el profesor de la asignatura");
			profesor = sc.nextLine();
			
			asignaturas[i] = new Asignatura(nombre, codigo, horas, profesor); 
			
		}
		
		sc.close();
		
		//Guardar objetos a archivo binario
		
		  try (ObjectOutputStream oos = new ObjectOutputStream(new
		  BufferedOutputStream(new FileOutputStream("ficheros/asignaturas.dat")))) {
		  
		  for(Asignatura asig : asignaturas) {
		  
		  oos.writeObject(asig); //Guardar asignatura en un archivo binario
		  
		  }
		  
		  System.out.println("Asignaturas guardadas correctamente");
		  
		  } catch (IOException e) {
		  
		  System.out.println("Su base de datos de virus ha sido actualizada");
		  e.printStackTrace();
		  
		  }
		 
		
	}
}
