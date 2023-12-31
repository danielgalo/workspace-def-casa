package com.ac1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Maestro {

	public static void main(String[] args) {

		// Creo un builder que ejecuta la clase esclava
		ProcessBuilder builder = new ProcessBuilder("java", "-cp", "bin", "com.ac1.Esclavo");

		try {

			// Creo proceso
			Process proceso = builder.start();

			// Salida estandar del proceso esclavo para poder enviarle datos
			OutputStream salidaEsclavo = proceso.getOutputStream();
			PrintWriter writer = new PrintWriter(salidaEsclavo);

			String input = "";
			Scanner sc = new Scanner(System.in);

			// Leer cadenas hasta que se introduzca una vacía
			do {

				System.out.println("Introduce una cadena, vacia para terminar");
				input = sc.nextLine();

				// Enviar la cadena al esclavo
				writer.println(input);
				writer.flush();

				// Leer del esclavo
				BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
				String output = reader.readLine();

				System.out.println(output);

			} while (!input.isBlank());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
