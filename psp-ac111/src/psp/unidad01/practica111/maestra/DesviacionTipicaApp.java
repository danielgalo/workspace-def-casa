package psp.unidad01.practica111.maestra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DesviacionTipicaApp {

	public static void main(String[] args) {

		int numeroProcesadores = Runtime.getRuntime().availableProcessors();

		if (args.length < 1) {
			System.err.println("Error, se necesita al menos 1 parámetro referido a un archivo.");
			return;
		} else {

			FileReader archivo;

			try {

				// Archivo a leer
				archivo = new FileReader(args[0]);
				BufferedReader reader = new BufferedReader(archivo);

				// Lista de numeros
				List<Double> listaNumeros = new ArrayList<Double>();

				// Leer archivo, añadir numeros a lista
				String linea;
				double numero;

				while ((linea = reader.readLine()) != null) {
					if (!linea.isBlank()) {
						numero = Double.parseDouble(linea.replace(",", "."));
						listaNumeros.add(numero);

					}
				}

				// Calcular media
				double suma = 0;
				double longitudSerie = listaNumeros.size();
				for (double d : listaNumeros) {
					suma += d;
				}

				double media = suma / longitudSerie;

				System.out.println("longitud serie: " + longitudSerie + " media: " + media);

				System.out.println("resto: " + (longitudSerie % numeroProcesadores));

				// Constructor de procesos
				ProcessBuilder builder = new ProcessBuilder("java", "-cp", "bin",
						"psp.unidad01.practica111.esclava.EsclavaApp");

				// Crear tantos procesos como procesadores tenga el equipo
				List<Process> procesos = new ArrayList<>();
				for (int i = 0; i < numeroProcesadores; i++) {
					procesos.add(builder.start());
				}

				// Indice del proceso de la lista de procesos
				int procesoIndex = 0;

				// Pasarle a cada proceso la media calculada
				for (Process p : procesos) {
					// Obtén el OutputStream del proceso
					OutputStream outputStream = p.getOutputStream();
					PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));

					writer.println(media);
					writer.flush();
				}

				// Pasarle a cada proceso los números repartidos de la lista
				for (Double n : listaNumeros) {

					Process proceso = procesos.get(procesoIndex);

					// Obtén el OutputStream del proceso
					OutputStream outputStream = proceso.getOutputStream();
					PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));

					// Envía el número al proceso a través de su entrada estándar
					writer.println(n);
					writer.flush();

					// Aumenta el índice desde 1 a 11 de manera circular hasta que acabe el ciclo
					procesoIndex = (procesoIndex + 1) % numeroProcesadores;
				}

				reader.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

}
