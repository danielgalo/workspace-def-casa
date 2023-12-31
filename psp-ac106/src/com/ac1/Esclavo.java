package com.ac1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Esclavo {

	public static void main(String[] args) {

		// Buffer para leer la entrada
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {

			String input = "";

			// Leer la entrada mientras no este vacia
			do {
				int operacion = getRandomInt(1, 3);
				input = reader.readLine();
				String resultado = getCadenaModificada(input, operacion);
				System.out.println(resultado);

			} while (!input.isBlank());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	private static String getCadenaModificada(String cadena, int operacion) {

		String resultado = "";

		if (operacion == 1) {
			// Pasar todo a mayuscula
			resultado = cadena.toUpperCase();

		} else if (operacion == 2) {
			// Pasar todo a minuscula
			resultado = cadena.toLowerCase();

		} else if (operacion == 3) {
			// Capitalizar
			StringBuilder sb = capitalizeString(cadena);

			resultado = sb.toString();

		}

		return resultado;
	}

	private static StringBuilder capitalizeString(String cadena) {
		String[] palabras = cadena.split(" ");

		StringBuilder sb = new StringBuilder();

		for (String p : palabras) {

			String primeraLetraMay = p.substring(0, 1).toUpperCase();
			String restoPalabra = p.substring(1).toLowerCase();

			sb.append(primeraLetraMay).append(restoPalabra);
			sb.append(" ");

		}
		return sb;
	}

	private static int getRandomInt(int max, int min) {

		Random rand = new Random();
		return rand.nextInt(max) + min;

	}

}
