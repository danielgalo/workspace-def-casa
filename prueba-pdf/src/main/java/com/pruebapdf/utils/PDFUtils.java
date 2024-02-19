package com.pruebapdf.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pruebapdf.entities.Venta;

/**
 * Clase de utilidades para generar PDFs
 */
public class PDFUtils {

	/**
	 * Constructor privado
	 */
	private PDFUtils() {

	}

	/**
	 * Genera un PDF con los datos de una venta
	 * 
	 * @param venta    Objeto venta con los datos
	 * @param filePath ruta al fichero a generar
	 * @throws DocumentException si hubo problema generando PDF
	 */
	public static void generarPDF(Venta venta, String filePath, String titulo) throws DocumentException {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		document.open();

		Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
		Paragraph tituloParrafo = new Paragraph(titulo, fontTitulo);
		tituloParrafo.setAlignment(Element.ALIGN_CENTER);
		document.add(tituloParrafo);

		document.add(new Paragraph("\n"));

		PdfPTable tabla = new PdfPTable(2);
		tabla.setWidthPercentage(60);
		tabla.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell celdaTitulo = new PdfPCell(new Paragraph("Campo"));
		PdfPCell celdaValor = new PdfPCell(new Paragraph("Valor"));

		tabla.addCell(celdaTitulo);
		tabla.addCell(celdaValor);

		tabla.addCell("Precio");
		tabla.addCell(venta.getPrecio());
		tabla.addCell("Coche");
		tabla.addCell(venta.getCoche());
		tabla.addCell("Vendedor");
		tabla.addCell(venta.getVendedor());
		tabla.addCell("Comprador");
		tabla.addCell(venta.getComprador());

		document.add(tabla);

		document.close();
	}
}
