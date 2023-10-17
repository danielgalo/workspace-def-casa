package main;

import utils.Constantes;
import utils.DescifraRSA;
import utils.Parametro;

/**
 * Aplicación para descifrar un mensaje pasado por parámetros
 */
public class DescifraRSAApp {

	/**
	 * Método principal
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// Controlar parámetros
		Parametro param = new Parametro(args);

		// Descifrar
		DescifraRSA descifraRSA = new DescifraRSA(param.getMensaje(), param.getAlias());
		String mensajeDescifrado = descifraRSA.getMensajeDescifrado(Constantes.FICHERO_CLAVES);

		// Mostrar mensaje descifrado
		System.out.println("Mensaje descifrado: " + mensajeDescifrado);
	}

}
