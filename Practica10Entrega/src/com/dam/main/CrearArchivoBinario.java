package com.dam.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.dam.pojo.Empleado;

public class CrearArchivoBinario {
	
    public static void main(String[] args) {
    	
        String[] nombres = {"Sonic", "Tails", "Knuckles", "Shadow", "Robotnik"};
        int[] departamentos = {10, 20, 30, 20, 10};
        double[] salarios = {2000.00, 1500.50, 3000.40, 2300.60, 1900.10};

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ficheros/empleadosObj.dat"))) {
            
        	for (int i = 0; i < nombres.length; i++) {
                Empleado empleado = new Empleado(i + 1, nombres[i], departamentos[i], salarios[i]);
                oos.writeObject(empleado);
            }
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
}

