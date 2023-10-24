package com.hlc.rsa;

public class DescifraRSAApp {

	public static void main(String[] args) throws Throwable {
		// El mensaje es el primer argumento o el valor por defecto Hola Caracola
		String mensajeCifrado = (args.length > 0) ? args[0]
				: "Mz0h+e+0FMf3YxuyFF0iaRFt/A6RZKlFeX71rnyQmrEpJuaV9aCsjyQhQLzJQ2fuK+f4eFhTEhMys0cPuXIa4XD/j8RedvnlCQ6euTOYDKWnFGIw4Hc5KuDDekrGGrAky2cPl8cChXwSp9nwsJmyH+gPPe9EbzbGE+AYfkQqAAGs2H1n0NrGWXTijdgVXHVTCY7q9Eiso6VkKewwFZcC/PQPESW/Ad8YaSIHJvMYh7mB5ATwQ91awXkcKQbd2UwEwwPJQqy00Fw1aS6faYULDWlooaseWl0ccT42ut6yBXeGXuxfWu8368+5R6bZaxQVhnI7exGHnf4DzEMcK0KzFg==";
		// El segundo argumento es el nombre del archivo keystore
		String archivoKeyStore = (args.length > 1) ? args[1] : "keystore";
		// El tercero la password
		String password = (args.length > 2) ? args[2] : "123456789";
		// Y el cuarto el nombre de la entrada
		String entrada = (args.length > 3) ? args[3] : "miclave";

		// Creamos el algoritmo de descifrado. Los parametros deben ser los mismos
		// empleados en el cifrado
		AlgoritmoCifrado algoritmo = new AlgoritmoCifradoRSA(archivoKeyStore, entrada, password);

		// Obtenemos el resultado
		String resultado = algoritmo.desencriptaDesdeBase64(mensajeCifrado);

		// Y lo imprimimos
		System.out.println("El mensaje descifrado es " + resultado);
	}
}
