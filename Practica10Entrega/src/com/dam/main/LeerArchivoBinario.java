package com.dam.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.dam.pojo.Empleado;

public class LeerArchivoBinario {
    public static void main(String[] args) {
        
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleadosObj.dat"))) {
            
    		while (true) {
    			
    			try {
    				 Empleado empleado = (Empleado) ois.readObject();
    	             System.out.println(empleado);
    	            
				} catch (IOException | ClassNotFoundException e) {
					break;
				}
    			
               }
        
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
}

