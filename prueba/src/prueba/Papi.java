package prueba;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Papi {

	public static void main(String[] args) throws Exception {

		ProcessBuilder builder = new ProcessBuilder("java", "-cp", "bin", "prueba.Hijo");

		Process proceso = builder.start();

		OutputStream outputStream = proceso.getOutputStream();
		PrintWriter writer = new PrintWriter(outputStream);

		for (int i = 0; i < 12; i++) {
			writer.println(i);
			writer.flush();
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

		String linea;
		while ((linea = reader.readLine()) != null) {
			System.out.println(linea);
		}

		writer.close();
		proceso.destroy();

	}

}
