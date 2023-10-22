package prueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {

	public static void main(String[] args) throws IOException {

		// Buffer para leer la entrada
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String linea;

		while ((linea = reader.readLine()) != null) {
			System.out.println(linea);
		}

		reader.close();
	}

}
