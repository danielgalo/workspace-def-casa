package sp.ud02.ac2;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class CifraAESApp {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {

		Parametro param = new Parametro(args);

		// Cifrar mensaje
		String mensajeCifrado = cifrarMensaje(param.getMensaje(), param.getPassword());

		System.out.println("Mensaje cifrado " + mensajeCifrado);
	}

	private static String cifrarMensaje(String mensaje, String password) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		// Preparo la clave, obtiene objeto key
		Key clave = preparaClave(password);

		// Objeto cipher
		Cipher cifrador = Cipher.getInstance("AES");

		// Inicio cipher, le paso el modo de encriptacion y la clave
		cifrador.init(Cipher.ENCRYPT_MODE, clave);

		// Cifro el mensaje
		byte[] mensajeCifrado = cifrador.doFinal(mensaje.getBytes());

		// Lo paso a base64 y lo devuelvo
		return Base64.getEncoder().encodeToString(mensajeCifrado);
	}

	private static Key preparaClave(String password) throws NoSuchAlgorithmException {
		// Generador de claves, la instancio con AES
		KeyGenerator kg = KeyGenerator.getInstance("AES");

		// Inicio la clave
		kg.init(128);

		return kg.generateKey();
	}

}
