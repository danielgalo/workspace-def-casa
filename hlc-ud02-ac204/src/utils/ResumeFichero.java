package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase que se encarga de resumir el contenido de un fichero de texto
 */
public class ResumeFichero {

	/** Fichero a resumir */
	private String fichero;

	/** Algoritmo utilizado para el resumen */
	private String algoritmo;

	/**
	 * @param fichero
	 * @param algoritmo
	 */
	public ResumeFichero(String fichero, String algoritmo) {

		setFichero(fichero);
		setAlgoritmo(algoritmo);

	}

	/**
	 * Resume el contenido proveniente de un fichero
	 * 
	 * @return la cadena resumida sin mayúsculas
	 */
	public String getContenidoReducido() {

		StringBuilder builder = null;
		byte[] contenido = getContenidoFichero();

		try {

			// Objeto MessageDirect con el algoritmo especificado
			MessageDigest md = MessageDigest.getInstance(algoritmo);

			// Actualizar el objeto con el contenido a resumir
			md.update(contenido);

			// Resumir el contenido
			byte[] digest = md.digest();

			// Builder para construir la cadena
			builder = new StringBuilder();

			// Recorrer el resumen en bytes y convertirlo en hexadecimal
			for (byte b : digest) {
				builder.append(String.format("%02x", b));
			}

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		}

		return builder.toString().toLowerCase();

	}

	/**
	 * Devuelve todo el contenido del fichero en un array de bytes
	 * 
	 * @return el String con el contenido del fichero
	 */
	private byte[] getContenidoFichero() {

		Path ruta = Path.of(fichero);
		byte[] contenido = null;
		try {

			contenido = Files.readAllBytes(ruta);

		} catch (IOException e) {

			e.printStackTrace();

		}

		return contenido;
	}

	/**
	 * @return the fichero
	 */
	public String getFichero() {
		return fichero;
	}

	/**
	 * @param fichero the fichero to set
	 */
	public void setFichero(String fichero) {
		this.fichero = fichero;
	}

	/**
	 * @return the algoritmo
	 */
	public String getAlgoritmo() {
		return algoritmo;
	}

	/**
	 * @param algoritmo the algoritmo to set
	 */
	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

}
