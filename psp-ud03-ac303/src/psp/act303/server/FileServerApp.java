package psp.act303.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import psp.act303.utils.Constants;
import psp.act303.utils.PropertiesProcessor;
import psp.act303.workers.ClientHandlerWorker;

/**
 * Server class
 */
public class FileServerApp {

	/** Port of the server */
	private int port;

	/**
	 * Constructor
	 * 
	 * @param args program arguments
	 */
	public FileServerApp(String[] args) {
		processProperties();
		System.out.println("Servidor en puerto: " + port);
	}

	/**
	 * Main method
	 * 
	 * @param args program arguments
	 */
	public static void main(String[] args) {
		FileServerApp thisApp = new FileServerApp(args);
		thisApp.run();
	}

	/**
	 * Starts the server, waits for clients to connect and interacts with them
	 */
	private void run() {

		try (ServerSocket socket = new ServerSocket(port)) {

			String petition = "";

			do {
				// Aceptar la conexión entrante
				Socket clientSocket = socket.accept();

				// Crear y arrancar hilo
				ClientHandlerWorker worker = new ClientHandlerWorker(clientSocket);
				worker.start();
				petition = worker.processPetition(petition);

			} while (!petition.equals(Constants.QUIT_COMMAND));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Process the properties of the server
	 */
	private void processProperties() {
		PropertiesProcessor properties = new PropertiesProcessor(Constants.SERVER_PROPERTIES);

		try {
			// Intentar obtener el puerto del archivo de propiedades
			port = Integer
					.parseInt(properties.getProperty(Constants.PORT_PROPERTY, String.valueOf(Constants.DEFAULT_PORT)));
		} catch (NumberFormatException e) {
			// En caso de que la propiedad no sea un puerto válido
			port = Constants.DEFAULT_PORT;
			e.printStackTrace();
		}
	}

}
