package PruebasXStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaObjeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Lista como atributo
	private List<Objeto> listaObjeto;
	
	//Constructor que inicializa la lista
	public ListaObjeto() {
		listaObjeto = new ArrayList<>();
	}
	
	//Método para añadir objetos a la lista
	public void addObjetos(Objeto objeto) {
		listaObjeto.add(null);
	}

}
