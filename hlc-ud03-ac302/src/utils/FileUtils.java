package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class FileUtils {

	/** Ruta del fichero a trabajar */
	private String rutaFichero;

	/**
	 * Constructor
	 * 
	 * @param rutaFichero
	 */
	public FileUtils(String rutaFichero) {
		setRutaFichero(rutaFichero);
	}

	/**
	 * Obtiene un mapa con el contenido de un fichero con el formato clave=valor
	 * 
	 * @return el mapa
	 */
	public Map<String, String> getMapaContenido() {

		Map<String, String> resultado = new HashMap<>();

		BufferedReader reader = null;

		try {

			reader = new BufferedReader(new FileReader(rutaFichero));

			String lineaLeida;

			List<String[]> listaLineas = new ArrayList<>();

			while ((lineaLeida = reader.readLine()) != null) {
				listaLineas.add(lineaLeida.split("="));
			}

			for (String[] arr : listaLineas) {
				resultado.put(arr[0], arr[1]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(reader);
		}

		return resultado;
	}

	private void closeReader(BufferedReader reader) {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the rutaFichero
	 */
	public String getRutaFichero() {
		return rutaFichero;
	}

	/**
	 * @param rutaFichero the rutaFichero to set
	 */
	public void setRutaFichero(String rutaFichero) {
		this.rutaFichero = rutaFichero;
	}

}
