package main;

import utils.Parametros;
import utils.ResumeFichero;

/**
 * Aplicación para resumir el contenido de un fihcero de texto
 */
public class ResumeFicheroApp {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Controlar parámetros
		Parametros param = new Parametros(args);

		// Resumir fichero
		ResumeFichero rf = new ResumeFichero(param.getNombreFichero(), param.getAlgoritmo());

		// Conseguir el resultado e imprimirlo por pantalla
		String resumen = rf.getContenidoReducido();
		System.out.println("Contenido resumido con el algoritmo " + rf.getAlgoritmo() + ": " + resumen);

	}

}
