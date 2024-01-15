package psp.unidad03.practica01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import psp.unidad03.practica01.properties.PropertiesProcessor;

/**
 * Clase servidor
 */
public class MainDNSServerApp {

	/** Archivo de propiedades */
	private static final String PROPERTIES_FILE = "dns.properties";

	/** Puerto UDP */
	private static final int PUERTO = 2222;

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		boolean continuarEjecucion = true;

		// Procesador de propiedades
		PropertiesProcessor processor = new PropertiesProcessor(PROPERTIES_FILE);

		try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
			System.out.println("Servidor esperando en el puerto " + PUERTO);

			while (continuarEjecucion) {
				byte[] buffer = new byte[1024];
				DatagramPacket paqueteEntrada = new DatagramPacket(buffer, buffer.length);

				socket.receive(paqueteEntrada);

				// Recoger mensaje del cliente
				String mensajeEntrada = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
				System.out.println("Mensaje recibido: " + mensajeEntrada);

				// Si el mensaje está en blanco acabar
				if (mensajeEntrada.equalsIgnoreCase("")) {

					continuarEjecucion = false;
					System.out.println("Terminando el servidor...");

				} else {
					// Si el mensaje es correcto
					InetAddress clienteDireccion = paqueteEntrada.getAddress();
					int clientePuerto = paqueteEntrada.getPort();

					// Obtener valor de la propiedad
					String propertyValue = processor.getProperty(mensajeEntrada);

					// Convertirlo a bytes
					byte[] bufferRespuesta = propertyValue.getBytes();

					// Enviarlo
					DatagramPacket paqueteSalida = new DatagramPacket(bufferRespuesta, bufferRespuesta.length,
							clienteDireccion, clientePuerto);
					socket.send(paqueteSalida);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
