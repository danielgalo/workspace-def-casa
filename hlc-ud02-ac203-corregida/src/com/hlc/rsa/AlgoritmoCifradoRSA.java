package com.hlc.rsa;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.crypto.Cipher;

public class AlgoritmoCifradoRSA extends AlgoritmoCifrado {

	// Archivo de claves
	String archivoKeyStore = null;
	// Nombre de la entrada en el archivo de claves
	String entrada = null;
	// Clave de encriptacion para JCA
	KeyPair claves = null;

	public AlgoritmoCifradoRSA(String archivoKeyStore, String entrada, String password) {
		super(password);
		this.entrada = entrada;
		this.archivoKeyStore = archivoKeyStore;
	}

	@Override
	public String encriptaABase64(String mensaje) throws Throwable {

		// Se asegura de que la clave se ha inicializado
		inicializaClaves();

		// Iniciamos el algoritmo con la clave
		Cipher algoritmo = Cipher.getInstance("RSA");
		// OJO: Para cifrar se usa la clave publica
		algoritmo.init(Cipher.ENCRYPT_MODE, this.claves.getPublic());

		// Ciframos
		byte[] mensajeCifrado = algoritmo.doFinal(mensaje.getBytes());

		// El resultado es una secuencia de bytes. Para que tenga un formato legible
		// Lo convertimos a Base 64 que es un formato que codifica secuencias binarias
		// usando caracteres imprimibles.
		return Base64.getEncoder().encodeToString(mensajeCifrado);
	}

	@Override
	public String desencriptaDesdeBase64(String mensaje) throws Throwable {

		// Se asegura de que se ha inicializado la clave
		inicializaClaves();
		// Iniciamos el algoritmo con la clave
		Cipher algoritmo = Cipher.getInstance("RSA");
		// OJO: Para descifrar se usa la clave privada
		algoritmo.init(Cipher.DECRYPT_MODE, this.claves.getPrivate());

		// Ciframos convirtiendo el mensaje cifrado desde Base64 a array de bytes
		byte[] mensajeCifrado = algoritmo.doFinal(Base64.getDecoder().decode(mensaje));

		// El resultado es una secuencia de bytes. Para que tenga un formato legible
		// Lo convertimos a Base 64 que es un formato que codifica secuencias binarias
		// usando caracteres imprimibles.
		return new String(mensajeCifrado);
	}

	private void inicializaClaves() throws Throwable {

		// Si no se han inicializado las claves aun
		if (claves == null) {
			// Accedemos al archivo keystore
			FileInputStream is = new FileInputStream(this.archivoKeyStore);

			// Se crea un objeto KeyStore con los parámetros por defecto
			KeyStore store = KeyStore.getInstance(KeyStore.getDefaultType());
			// Y se carga desde el archivo usando la password
			store.load(is, this.password.toCharArray());

			// Obtenemos la clave privada desde la entrada
			Key clavePrivada = store.getKey(this.entrada, this.password.toCharArray());

			// Si existe la entrada
			if (clavePrivada instanceof PrivateKey) {
				// La clave publica se almacena en un certificado asociado
				// Lo cargamos
				Certificate certificado = store.getCertificate(entrada);
				// Y obtenemos la clave publica
				PublicKey clavePublica = certificado.getPublicKey();

				// Ahora que tenemos dos claves, generamos la pareja y la almacenamos
				this.claves = new KeyPair(clavePublica, (PrivateKey) clavePrivada);
			}

		}
	}
}
