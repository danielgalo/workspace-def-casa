package psp.act303.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class FileClientApp {

	// Dirección del servidor por defecto
	private static final String DEFAULT_HOST = "localhost";
	// Puerto por defecto
	private static final int DEFAULT_PORT = 1234;

	// Dirección del servidor
	private String host;
	// Puerto del servidor
	private int port;
	// Scanner para leer desde teclado
	private Scanner sc;

	public FileClientApp(String[] args) {
		// Procesamos los parámetros y extraemos host y puerto
		processParameters(args);
		// Creamos el scanner
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		// Creamos un objeto de esta clase y lo lanzamos
		FileClientApp app = new FileClientApp(args);
		app.run();
	}

	private void run() {
		// Hacemos un try con recursos
		try (Socket socket = new Socket(host, port)) {
			// Obtenemos los streams de salida y entrada
			// Como vamos a trabajar con líneas de texto usamos
			// BufferedReader para leer y PrintWriter para escribir
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			// Mientras no se introduzca la cadena vacía por teclado
			String mensaje;
			do {
				mensaje = sc.nextLine();
				// Si no es el mensaje de fin
				if (mensaje.length() > 0) {
					// Lo envía
					writer.println(mensaje);
					writer.flush();
					// Espera y recibe la respuesta
					String respuesta;
					while ((respuesta = reader.readLine()) != null) {
						System.out.println(respuesta);
					}
				}
			} while (mensaje.length() > 0);
			System.out.println("Terminando...");
			// El socket se cierra solo ya que hemos usado try con recursos
		} catch (IOException e) {
			System.err.println("Error en la conexión.");
			System.err.println("Excepcion original:");
			e.printStackTrace(System.err);
		}
	}

	private void processParameters(String[] args) {
		// Si se ha pasado la direccion del servidor la toma, si no usa la direccion por
		// defecto
		host = (args.length > 0) ? args[0] : DEFAULT_HOST;
		// Igual con el puerto
		try {
			// Se intenta procesar desde parámetros
			port = Integer.parseInt(args[1]);
		} catch (Exception e) {
			// Si no se puede usamos el valor por defecto
			port = DEFAULT_PORT;
		}
	}
}
