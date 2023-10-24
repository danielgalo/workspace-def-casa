package com.hlc.rsa;

public class CifraRSAApp {

	public static void main(String[] args) throws Throwable {

		// El mensaje es el primer argumento o el valor por defecto Hola Caracola
		String mensaje = (args.length > 0) ? args[0] : "Hola Caracola";

		// El segundo argumento es el nombre del archivo keystore
		String archivoKeyStore = (args.length > 1) ? args[1] : "keystore";

		// El tercero la password
		String password = (args.length > 2) ? args[2] : "123456789";

		// Y el cuarto el nombre de la entrada
		String entrada = (args.length > 3) ? args[3] : "miclave";

		// Creamos el algorimo de cifrado. Los parámetros deben ser identicos cuando se
		// cree una instancia para descifrado
		AlgoritmoCifrado algoritmo = new AlgoritmoCifradoRSA(archivoKeyStore, entrada, password);

		// Ciframos, obteniendo el resultado en Base64
		String resultado = algoritmo.encriptaABase64(mensaje);

		// Finalmente lo imprimimos
		System.out.println("El mensaje cifrado es " + resultado);

	}

}
