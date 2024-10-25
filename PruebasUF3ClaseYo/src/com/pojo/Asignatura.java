package com.pojo;

import java.io.Serializable;

public class Asignatura implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String codigoAsignatura;
	private int nHoras;
	private String profesor;

	public Asignatura(String nombre, String codigoAsignatura, int nHoras, String profesor) {
		this.nombre = nombre;
		this.codigoAsignatura = codigoAsignatura;
		this.nHoras = nHoras;
		this.profesor = profesor;
	}



	@Override
	public String toString() {
		return  "Nombre Asignatura: " + nombre + ", Codigo de Asignatura: " + codigoAsignatura + ", Nº Horas: " + nHoras
				+ ", profesor: " + profesor + "]";
	}
	
	
	
}
