package com.dam.main;

import java.io.*;
import java.util.Scanner;

public class LeerFicheroTexto {
    
    // Definimos tamaño de los registros
    static final int TAM_TITULO = 35;
    static final int TAM_DIRECTOR = 35;
    static final int TAM_SINOPSIS = 1000;
    static final int TAM_REG = 2152;

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("PelisTerror.dat", "rw")) {
            
            // Leer películas desde el archivo de texto y almacenarlas en el archivo binario
            leerGuardarTxt(raf, "pelis_terror.txt");

            // Leer películas desde el archivo binario y mostrarlas en pantalla
            leer(raf);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer el archivo de texto y guardar las películas en el archivo binario
    private static void leerGuardarTxt(RandomAccessFile raf, String archivoTxt) throws IOException {
        Scanner sc = new Scanner(new File(archivoTxt));
        
        // Leer el último ID registrado en el archivo binario
        int id = 0;
        if (raf.length() > 0) {
            raf.seek(raf.length() - TAM_REG); // Me sitúo justo antes del último registro
            id = raf.readInt();  // Leemos el último ID
        }
        
        raf.seek(raf.length()); // Posicionamos el puntero al final del archivo binario para comenzar a escribir

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] campos = linea.split("-");
            if (campos.length == 5) {
                id++; // Incrementamos el ID
                raf.writeInt(id); // Escribimos el ID

                // Título
                StringBuffer sbt = new StringBuffer(campos[0].trim());
                sbt.setLength(TAM_TITULO); // Ajustar a 35 caracteres
                raf.writeChars(sbt.toString());

                // Año
                int anio = Integer.parseInt(campos[1].trim());
                raf.writeInt(anio);

                // Duración
                int duracion = Integer.parseInt(campos[2].trim());
                raf.writeInt(duracion);

                // Director
                StringBuffer sbd = new StringBuffer(campos[3].trim());
                sbd.setLength(TAM_DIRECTOR); // Ajustar a 35 caracteres
                raf.writeChars(sbd.toString());

                // Sinopsis
                StringBuffer sbs = new StringBuffer(campos[4].trim());
                sbs.setLength(TAM_SINOPSIS); // Ajustar a 1000 caracteres
                raf.writeChars(sbs.toString());
            }
        }

        sc.close();
    }

    // Método para leer las películas desde el archivo binario y mostrarlas
    private static void leer(RandomAccessFile raf) throws IOException {
        raf.seek(0); // Volver al principio del archivo
        
        // Almacenar datos leídos
        String titulo, director, sinopsis;
        int anio, duracion;
        char[] cTitulo = new char[TAM_TITULO];
        char[] cDirector = new char[TAM_DIRECTOR];
        char[] cSinopsis = new char[TAM_SINOPSIS];
        
        while (raf.getFilePointer() < raf.length()) {
            
            int id = raf.readInt();  // Leer ID
            
            // Leer el título
            for (int i = 0; i < cTitulo.length; i++) {
                cTitulo[i] = raf.readChar();
            }
            titulo = new String(cTitulo).trim();
            
            // Leer el año
            anio = raf.readInt();
            
            // Leer duración
            duracion = raf.readInt();
            
            // Leer el director
            for (int i = 0; i < cDirector.length; i++) {
                cDirector[i] = raf.readChar();
            }
            director = new String(cDirector).trim();
            
            // Leer la sinopsis
            for (int i = 0; i < cSinopsis.length; i++) {
                cSinopsis[i] = raf.readChar();
            }
            sinopsis = new String(cSinopsis).trim();
            
            // Mostrar el registro correctamente
            System.out.println(id + "-" + titulo + "-" + anio + "-" + duracion +
                               "-" + director + "-" + sinopsis + "-");
        }
    }
}
