package psp.unidad01.practica111.esclava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Programa que calcula la desviación típica de una serie de números: a cada
 * entrada se le resta la media total de la lista (la cual es la primera entrada
 * que se le pasa.). El resultado de esta resta elevarlo al cuadrado y los
 * resultados de elevarlo al cuadrado se van sumando. La suma de los cuadrados
 * es lo que devuelve el programa. Por ejemplo la media es 6 y las entradas son
 * 5, 8, 9 -> ((5 - 6)^2) + ((8 - 6)^2) + ((9 - 6)^2) = número a devolver.
 */
public class EsclavaApp {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Buffer para leer la entrada
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {

			// Conseguir la media, que es la primera entrada
			double media = Double.parseDouble(reader.readLine());

			// Conseguir lista con los números de la entrada
			List<Double> nums = getListaNumeros(reader);

			// Conseguir desviación, imprimirla
			double desviacionTipica = getDesviacionTipica(media, nums);
			System.out.println(desviacionTipica);

			System.out.println(0);

		} catch (IOException e) {

			System.out.println(-1);
			e.printStackTrace();

		}
	}

	/**
	 * Construye una lista con los números de la entrada estándar
	 * 
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private static List<Double> getListaNumeros(BufferedReader reader) throws IOException {

		String linea;

		List<Double> nums = new ArrayList<>();

		while ((linea = reader.readLine()) != null) {

			if (!linea.isBlank()) {
				nums.add(Double.parseDouble(linea));
			} else {
				break;
			}

		}
		return nums;
	}

	/**
	 * Calcula la desviación típica de una lista
	 * 
	 * @param media
	 * @param nums
	 * @return
	 */
	private static double getDesviacionTipica(double media, List<Double> nums) {
		double sumaTotal = 0;
		double resta = 0;
		double cuadradoResta = 0;
		for (double numero : nums) {
			resta = numero - media;
			cuadradoResta = resta * resta;
			sumaTotal += cuadradoResta;
		}
		return sumaTotal;
	}

}
