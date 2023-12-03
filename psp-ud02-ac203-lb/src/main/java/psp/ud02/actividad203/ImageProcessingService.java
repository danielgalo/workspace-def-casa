package psp.ud02.actividad203;

import psp.ud02.actividad203.workers.Dispatcher;

/**
 * Main app.
 * 
 * Resizes images from a file.
 */
public class ImageProcessingService {

	/** Path to properties file */
	private static final String PROPERTIES_FILE = "config.properties";

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Dispatcher, main thread
		Dispatcher dispatcher = new Dispatcher(PROPERTIES_FILE);
		dispatcher.start();
	}

}
