package main;

import utils.CifradoRSA;
import utils.Constantes;
import utils.Parametro;

/**
 * Apliación para cifrar un mensaje pasado por parámetros
 */
public class CifraRSAApp {

	/**
	 * Método principal
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// Controlar parametros
		Parametro param = new Parametro(args);

		// Cifrar mensaje pasado por parámetros
		CifradoRSA cifraRSA = new CifradoRSA(param.getMensaje(), param.getAlias());
		String mensajeCifrado = cifraRSA.getMensajeCifrado(Constantes.FICHERO_CLAVES);

		// Imprimir el mensaje
		System.out.println(mensajeCifrado);
	}

}
