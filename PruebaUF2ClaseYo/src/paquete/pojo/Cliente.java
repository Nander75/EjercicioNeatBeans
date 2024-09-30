package paquete.pojo;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private String fechaAlta;
	private String provincia;
	private String ciudad;
	
	//Constructor
	public Cliente(String nombre, String apellido, String email, String direccion, String fechaAlta, String provincia,
			String ciudad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.fechaAlta = fechaAlta;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	//Método toString para imprimir los detalles del cliente
	@Override
	public String toString() {
		return "Cliente: " + nombre + " " + apellido + ", Email: " + email + ", Direccion: " + direccion
				+ ", Fecha de alta: " + fechaAlta + ", Provincia: " + provincia + ", Ciudad: " + ciudad;
	}

}
