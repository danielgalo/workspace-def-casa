package prueba.src.psp.unidad02.mayormenor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EsclavoApp {

	public static void main(String[] args) {
		// Lee lista de numeros

		// Obtenemos el reader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Calcula el mayor
		int mayor = 0;
		boolean bPrimero = true;

		String linea;
		try {
			while (!(linea = reader.readLine()).isEmpty()) {
				try {
					int numero = Integer.parseInt(linea);
					if (bPrimero || (numero > mayor)) {
						mayor = numero;
						bPrimero = false;

					}
				} catch (NumberFormatException e) {
				}
			}
		} catch (IOException e) {
			if (bPrimero) {
				mayor = Integer.MIN_VALUE;
			}
		}

		// Devuelve el mayor
		System.out.println(mayor);
	}

}
