package psp.act303.workers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import psp.act303.utils.Constants;
import psp.act303.utils.FileUtils;

public class ClientHandlerWorker extends Thread {

	private Socket clientSocket;

	public ClientHandlerWorker(Socket socket) {
		this.clientSocket = socket;
	}

	@Override
	public void run() {
		try {
			// Obtener flujo de entrada y salida con el cliente
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());

			String petition;
			// Mientras haya mensajes por la conexión
			while ((petition = reader.readLine()) != null && !petition.equals(Constants.QUIT_COMMAND)) {
				// Procesar la petición del cliente
				String response = processPetition(petition);
				// Y lo enviamos como respuesta
				writer.println(response);
				writer.flush();
			}

			// Cerrar los flujos y el socket del cliente
			reader.close();
			writer.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String processPetition(String petition) {
		// Procesar los posibles comandos recibidos
		if (petition.startsWith(Constants.LIST_COMMAND)) {

			String[] commands = petition.split(" ");

			if (argumentsIntroduced(commands)) {
				// Ejecutar comando
				String path = commands[1];
				return FileUtils.listFolder(path);// TODO método lo hace bien, llega arriba a response como null

			} else {
				// No se proporcionó la ruta
				return Constants.KO;

			}

		} else if (petition.startsWith(Constants.SHOW_COMMAND)) {
			String[] commands = petition.split(" ");

			if (argumentsIntroduced(commands)) {
				// Ejecutar comando
				String path = commands[1];
				return FileUtils.showFile(path);

			} else {
				// No se proporcionó la ruta
				return Constants.KO;

			}
		} else if (petition.startsWith(Constants.DELETE_COMMAND)) {
			// No se proporcionó la ruta
			return Constants.KO;
		} else if (petition.equals(Constants.QUIT_COMMAND)) {

		} else {
			// No se proporcionó la ruta
			return Constants.KO;
		}

		return Constants.KO;
	}

	/**
	 * Checks if arguments are introduced from a petition
	 * 
	 * @param commands commands from a petition to check
	 * @return true if it has arguments, false if not
	 */
	private boolean argumentsIntroduced(String[] commands) {
		return commands.length >= 2;
	}

}
