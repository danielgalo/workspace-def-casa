package com.pruebapdf;

import com.pruebapdf.entities.Venta;
import com.pruebapdf.utils.PDFUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Venta venta = new Venta("5000", "Toyota", "Juan", "María");

		try {
			PDFUtils.generarPDF(venta, "venta.pdf", "Venta coche: " + venta.getCoche());
			System.out.println("PDF generado correctamente.");
		} catch (Exception e) {
			System.err.println("Error al generar el PDF: " + e.getMessage());
		}
	}
}
