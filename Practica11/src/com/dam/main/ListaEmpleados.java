package com.dam.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dam.pojo.Empleado;

public class ListaEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;

    // Lista como atributo
    private List<Empleado> listaEmpleados;

    // Constructor que inicializa la lista
    public ListaEmpleados() {
        listaEmpleados = new ArrayList<>();
    }

    // M�todo para a�adir objetos a la lista
    public void addEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }
    
    // M�todo para obtener la lista de empleados
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
}
