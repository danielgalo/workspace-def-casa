package psp.unidad01.practica111.maestra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DesviacionTipicaApp {

	public static void main(String[] args) {

		// PROBLEMAS: ARCHIVO SERIE DE MANOLO NO FURULA, REPARTICION DE SOBRANTES

		int numeroProcesadores = Runtime.getRuntime().availableProcessors();

		if (args.length < 1 || !Files.isRegularFile(Path.of(args[0]))) {
			System.err.println("Error, se necesita al menos 1 parámetro referido a un archivo.");
			return;
		} else {

			FileReader archivo;

			try {

				// Archivo a leer
				archivo = new FileReader(args[0]);
				BufferedReader reader = new BufferedReader(archivo);

				// Constructor de procesos
				ProcessBuilder builder = new ProcessBuilder("java", "-cp", "bin",
						"psp.unidad01.practica111.esclava.EsclavaApp");

				// Crear tantos procesos como procesadores tenga el equipo
				List<Process> procesos = new ArrayList<>();
				for (int i = 0; i < numeroProcesadores; i++) {

					procesos.add(builder.start());
				}

				// Leer archivo, añadir numeros a lista
				String linea;
				double suma = 0;

				List<Double> nums = new ArrayList<Double>();

				while ((linea = reader.readLine()) != null) {

					if (!linea.isEmpty()) {
						nums.add(Double.parseDouble(linea.replace(",", ".")));
					}

				}

				// Calculo media
				for (Double num : nums) {

					suma += num;

				}

				double media = suma / nums.size();

				// Enviar datos a esclavos
				int contador = 0;
				for (Process proceso : procesos) {
					BufferedWriter escritor = proceso.outputWriter();
					PrintWriter printer = new PrintWriter(escritor);

					printer.println(media);

					int principio = contador * (nums.size() / numeroProcesadores);
					int fin = ((contador + 1) * (nums.size() / numeroProcesadores));

					for (int i = principio; i < fin; i++) {
						printer.println(nums.get(i).toString());
					}

					printer.flush();
					contador++;
					printer.close();
				}

				// Comprobación de sobrante
				int sobrantes = nums.size() % numeroProcesadores;

				System.out.println(sobrantes);
				if (sobrantes > 0) {

					// Enviar datos a esclavos, incluyendo números sobrantes
					int contadorSobrantes = 0;
					int start = 0;
					for (Process proceso : procesos) {
						int end = start + (nums.size() / numeroProcesadores) + (contadorSobrantes < sobrantes ? 1 : 0);

						BufferedWriter escritor = proceso.outputWriter();
						PrintWriter printer = new PrintWriter(escritor);

						printer.println(media);

						for (int i = start; i < end; i++) {
							printer.println(nums.get(i).toString());
						}

						printer.close(); // Cierra la comunicación con el proceso esclavo
						contadorSobrantes++;
						start = end;
					}
				}

				// Leer de esclavo
				int proceso = 0;
				for (Process p : procesos) {
					BufferedReader r = p.inputReader();
					String l;
					while ((l = r.readLine()) != null) {
						System.out.println("Proceso " + proceso + ": " + l);
					}
					proceso++;
				}

				reader.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

}
