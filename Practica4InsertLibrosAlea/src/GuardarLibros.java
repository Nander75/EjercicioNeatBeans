import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class GuardarLibros {
	
	//Definimos tama�o de los registros
	static final int TAM_TITULO = 30;
	static final int TAM_AUTOR = 20;
	
	static final int TAM_REG = 112;

	public static void main(String[] args) {
		
		try (RandomAccessFile raf = new RandomAccessFile("libros.dat", "rw")){
			
			//Escribir libros
			escribir(raf);
			
			//Leer libros
			leer(raf);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	//M�todo para leer los libros en binario
	private static void leer(RandomAccessFile raf) throws IOException {
		
		raf.seek(0); //Volver al principio del archivo
		
		//Almacenar datos leidos
		String titulo, autor;
		int anio, numPag;
		char[] cTitulo = new char[TAM_TITULO];
		char[] cAutor = new char[TAM_AUTOR];
		
		while (raf.getFilePointer() < raf.length()) {
			
			//Titulo
			//Caracter a caracter
			for (int i = 0; i < cTitulo.length; i++) {
				cTitulo[i] = raf.readChar();//Leer cada caracter del nombre hasta 10 caracteres
				
			}
			
			titulo = new String(cTitulo).trim();
			
			//Autor
			//Caracter a caracter
			for (int i = 0; i < cAutor.length; i++) {
				cAutor[i] = raf.readChar();//Leer cada caracter del nombre hasta 20 caracteres
				
			}
			
			autor = new String(cAutor).trim();
			
			//Lectura de a�o
			anio = raf.readInt();
			
			//Lectura de num pag
			numPag = raf.readInt();
			
			//Muestro el registro correctamente
			System.out.println("Titulo:  " + titulo + " Autor: " + autor + " A�o de edici�n: " + anio + " N�mero de p�ginas: " + numPag);
			
		}
		
	}

	//M�todo para escribir los libros en el archivo de forma aleatoria
	private static void escribir(RandomAccessFile raf) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		//Leer el �ltimo ID registrado
		int id = 0;
		if (raf.length() > 0) {
			
			raf.seek(raf.length() - TAM_REG); //Me situo justo antes del �ltimo registro, es decir justo antes de su ID
			id = raf.readInt(); //Leemos el �ltimo ID
		}
		
		//Leer el �ltimo id registrado
		raf.seek(raf.length()); //posicionamos el puntero al final del archivo para comenzar a escribir
		boolean continuar = true;
		String titulo, autor;
		int anio, numPag;
		
		while (continuar) {
			id++; //Incrementamos el ID
			raf.writeInt(id); //Escribe el id del siguiente registro
			
			// Pedir por consola el t�tulo y guardalo en el archivo
			System.out.println("Introduce el t�tulo del libro: ");
			titulo = sc.nextLine();
			
			StringBuffer sbt = new StringBuffer(titulo);
			sbt.setLength(TAM_TITULO);
			raf.writeChars(sbt.toString());
			
			// Pedir por consola el autor y guardalo en el archivo
			System.out.println("Introduce el nombre del autor del libro: ");
			autor = sc.nextLine();
			
			StringBuffer sba = new StringBuffer(autor);
			sba.setLength(TAM_AUTOR);
			raf.writeChars(sba.toString());
			
			// Pedir y escribir el a�o de edici�n
			System.out.println("Introduce el a�o de la edici�n");
			anio = sc.nextInt();
			raf.writeInt(anio);
			
			// Pedir el n�mero de p�ginas
			System.out.println("Introduce el n�mero de p�ginas");
			numPag = sc.nextInt();
			raf.writeInt(numPag);
			
			sc.nextLine(); //Limpiar el buffer
			
			//Preguntamos al usuario si desea continuar
			System.out.println("�Desea continuar introduciendo otro libro? (SI/NO)");
			continuar = sc.nextLine().equals("SI");
		}
		
		sc.close();
		
	}

}
