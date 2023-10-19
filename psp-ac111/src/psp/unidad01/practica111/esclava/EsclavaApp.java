package psp.unidad01.practica111.esclava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EsclavaApp {

	public static void main(String[] args) {
		// Buffer para leer la entrada
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {

			String linea;

			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
