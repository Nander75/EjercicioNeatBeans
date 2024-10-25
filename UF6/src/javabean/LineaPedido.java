package javabean;

import java.io.Serializable;

public class LineaPedido implements Serializable {
	
	private int idPedido;
	private String producto;
	private int cantidad;
	private double precioTotal;
	private String fechaPedido;
	
	public LineaPedido(int idPedido, String producto, int cantidad, double precioTotal, String fechaPedido) {
		this.idPedido = idPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.fechaPedido = fechaPedido;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	
	
	
}
