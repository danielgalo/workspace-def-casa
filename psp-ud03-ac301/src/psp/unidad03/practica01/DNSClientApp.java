package psp.unidad03.practica01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Clase cliente
 */
public class DNSClientApp {

	/** Puerto del servidor */
	private static final int SERVIDOR_PUERTO = 2222;

	/** IP del servidor */
	private static final String SERVIDOR_IP = "127.0.0.1";

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try (DatagramSocket socket = new DatagramSocket()) {
			InetAddress servidorDireccion = InetAddress.getByName(SERVIDOR_IP);

			Scanner sc = new Scanner(System.in);

			while (true) {
				// Leer la cadena desde el usuario
				System.out.print("Escribe un mensaje para el servidor (en blanco para terminar): ");
				String mensajeUsuario = sc.nextLine();

				byte[] bufferEnvio = mensajeUsuario.getBytes();

				// Enviar el mensaje al servidor
				DatagramPacket paqueteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, servidorDireccion,
						SERVIDOR_PUERTO);
				socket.send(paqueteEnvio);

				// Recibir la respuesta del servidor
				byte[] bufferRecepcion = new byte[1024];
				DatagramPacket paqueteRecepcion = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
				socket.receive(paqueteRecepcion);

				String mensajeRespuesta = new String(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
				System.out.println("Respuesta del servidor: " + mensajeRespuesta);

				// Si el mensaje está en blanco, acabar.
				if (mensajeUsuario.isBlank()) {
					System.out.println("Cerrando el cliente...");
					sc.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
