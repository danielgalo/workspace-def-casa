package utils;

import java.io.File;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * Esta clase se encarga de cifrar un mensaje a través del algoritmo asimétrico
 * RSA
 * 
 */
public class CifradoRSA {

	/** El mensaje a cifrar */
	private String mensaje;

	/** Contraseña del archivo que contiene las keys */
	private String alias;

	/**
	 * Constructor
	 * 
	 * @param mensaje
	 * @param alias
	 */
	public CifradoRSA(String mensaje, String alias) {
		super();
		setMensaje(mensaje);
		setAlias(alias);
	}

	/**
	 * Cifra un mensaje a través del RSA
	 * 
	 * @param archivoClaves ruta al fichero de claves
	 * @param alias         del fichero
	 * @return el mensaje cifrado en base 64
	 */
	public String getMensajeCifrado(String archivoClaves) {

		byte[] mensajeCifrado = null;

		try {

			// Crear almacen de claves
			KeyStore almacen = KeyStore.getInstance(new File(archivoClaves), alias.toCharArray());

			// Sacar el certificado para conseguir la clave pública
			Certificate certificado = almacen.getCertificate(alias);
			PublicKey clavePublica = certificado.getPublicKey();

			// Cifrador
			Cipher cifrador = Cipher.getInstance(Constantes.ALGORITMO);
			cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);

			// Cifrar el mensaje
			mensajeCifrado = cifrador.doFinal(mensaje.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Devolver el mensaje cifrado en base 64
		return Base64.getEncoder().encodeToString(mensajeCifrado);
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
	public void setAlias(String password) {
		this.alias = password;
	}

}
