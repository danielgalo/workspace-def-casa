package prueba.src.psp.unidad02.mayormenor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MaestroApp {

	private static final int PROCESOS = 4;
	private static final String CLASE_ESCLAVO = "psp.unidad02.mayormenor.EsclavoApp";
	private static final String JAR_ESCLAVO = "Esclavo.jar";
	private static final int[] DATOS_PRUEBA = { 54, 66, 37, 95, 97, 19, 80, 80, 22, 69, 77, 23, 100, 18, 30, 102,
			1000 };

	public static void main(String[] args) throws Exception {
		// Creamos la factoria
		ProcessBuilder builder = new ProcessBuilder("java", "-jar", JAR_ESCLAVO);

		// Creamos los procesos
		List<Process> procesos = new ArrayList<>();
		for (int i = 0; i < PROCESOS; i++) {
			procesos.add(builder.start());
		}

		// Para cada proceso
		int vuelta = 0;
		for (Process proceso : procesos) {
			BufferedWriter escritor = proceso.outputWriter();
			PrintWriter printer = new PrintWriter(escritor);
			// Le pasamos los datos
			for (int i = vuelta * (DATOS_PRUEBA.length / PROCESOS); i < ((vuelta + 1)
					* (DATOS_PRUEBA.length / PROCESOS)); i++) {
				printer.println(DATOS_PRUEBA[i]);
			}
			printer.println();
			printer.flush();
			vuelta++;
		}

		// Leo los resultados desde los esclavos
		int mayor = 0;
		for (int i = 0; i < procesos.size(); i++) {
			BufferedReader reader = procesos.get(i).inputReader();
			String linea = reader.readLine();
			int resultado = Integer.parseInt(linea);
			if ((i == 0) || (resultado > mayor)) {
				mayor = resultado;
			}
		}

		// Imprimimos el resultado
		System.out.println("El mayor es " + mayor);
	}

}
