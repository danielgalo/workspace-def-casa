package utils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * Esta clase se encarga de descifrar un mensaje a través del algoritmo
 * asimétrico RSA
 * 
 */
public class DescifraRSA {

	/** Mensaje a descifrar */
	private String mensaje;

	/** Alias del archivo que contiene las keys */
	private String alias;

	/**
	 * Constructor
	 * 
	 * @param mensaje
	 * @param alias
	 */
	public DescifraRSA(String mensaje, String alias) {
		setMensaje(mensaje);
		setAlias(alias);
	}

	/**
	 * Descifra un mensaje cifrado a través del algoritmo asimétrico RSA
	 * 
	 * @param archivoClaves el archivo que contiene las keys
	 * @param alias         del archivo keytool
	 * @return el mensaje descifrado
	 */
	public String getMensajeDescifrado(String archivoClaves) {

		byte[] mensajeBytes = null;

		try {

			// Crear almacen de claves
			KeyStore almacen = KeyStore.getInstance(new File(archivoClaves), alias.toCharArray());

			// Sacar la clave privada del almacén
			Key clavePrivada = almacen.getKey(alias, alias.toCharArray());

			// Descifrar
			Cipher descifrador = Cipher.getInstance(Constantes.ALGORITMO);
			descifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
			mensajeBytes = descifrador.doFinal(Base64.getDecoder().decode(mensaje));

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Crear cadena para devolver
		String mensajeDescifrado = new String(mensajeBytes, StandardCharsets.UTF_8);

		return mensajeDescifrado;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the password to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

}