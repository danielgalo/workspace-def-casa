package com.pruebapdf.entities;

public class Venta {

	private String precio;
	private String coche;
	private String vendedor;
	private String comprador;

	public Venta(String precio, String coche, String vendedor, String comprador) {
		this.precio = precio;
		this.coche = coche;
		this.vendedor = vendedor;
		this.comprador = comprador;
	}

	public String getPrecio() {
		return precio;
	}

	public String getCoche() {
		return coche;
	}

	public String getVendedor() {
		return vendedor;
	}

	public String getComprador() {
		return comprador;
	}
}
