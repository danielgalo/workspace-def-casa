package main;

import utils.Constantes;
import utils.DescifraRSA;
import utils.Parametro;

/**
 * Aplicación para descifrar un mensaje pasado por parámetros
 */
public class DescifraRSAApp {

	private static final String MSG_POR_DEFECTO_CIFRADO = "3w72JU8dCPejxUnqsgNNllwMg1LZtPMd9+jQWdnOxO6NPLwfByRUSpl4t4eIpJQURzk0WZS0tl7jWtDnCSzw1/lbNjSRk4TMpSkci+D+bDr4nP93ew3ansd8aPVIXHt9C456s2VxqZBla9NyARApibgTmLi2uPGUtOB4xrU3vRtH4DI/z2rNYlO6/EiFPMh4woB9LdPk3GZE+pO1TTNc5o67QEsGhvDSzhz0Bxzkj+uXtBNSxfoXG3CBuWDA+CbZgq4gRlzzWtbAy63zafAoR56DQJE+vu702NyaXwZVWYdFXakgop1oO5au2y993bdCra4NWEClZ3ZeOux+7XNsTQ==";

	/**
	 * Método principal
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// Controlar parámetros
		Parametro param = new Parametro(args);

		if (args.length == 0) {
			param.setMensaje(
					MSG_POR_DEFECTO_CIFRADO);
		}

		// Descifrar
		DescifraRSA descifraRSA = new DescifraRSA(param.getMensaje(), param.getAlias());
		String mensajeDescifrado = descifraRSA.getMensajeDescifrado(Constantes.FICHERO_CLAVES);

		// Mostrar mensaje descifrado
		System.out.println("Mensaje descifrado: " + mensajeDescifrado);
	}

}
