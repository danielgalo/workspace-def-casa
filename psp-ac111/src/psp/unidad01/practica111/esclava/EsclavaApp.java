package psp.unidad01.practica111.esclava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EsclavaApp {

	public static void main(String[] args) {
		// Buffer para leer la entrada
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// Calcular la desviación: a cada entrada de la lista se le resta la media total
		// de la lista (la cual es la primera entrada que se le pasa.).
		// Al resultado de esta resta elevarlo al cuadrado y a los resultados de
		// elevarlo al cuadrado se van sumando. La suma de los cuadrados es lo que
		// devuelve el programa
		// p ej la media es 6 y las entradas son 5, 8, 9
		// 5 - 6 = -1^2
		// 8 - 6 = 2^2
		// 9 - 6 = 3^2
		// ........ num a devolver
		try {
//
//			String media = reader.readLine();

			String linea;

//			List<Double> nums = new ArrayList<>();
//			boolean primeraLinea = true;
//			while ((linea = reader.readLine()) != null) {
//
//				if (!primeraLinea) {
//					nums.add(Double.parseDouble(linea));
//				} else {
//					primeraLinea = false;
//				}
//
//			}

			while ((linea = reader.readLine()) != null) {

				System.out.println(linea);
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
