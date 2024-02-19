package psp.act303.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Utilites to work with files
 */
public class FileUtils {

	private FileUtils() {

	}

	/**
	 * Lists content from a folder
	 * 
	 * @param folderPath path to the folder to list
	 * @return a String in the following format: <br>
	 *         If the file is not a directory or it's empty: <br>
	 *         {@code KO}<br>
	 *         Else: <br>
	 *         {@code OK} <br>
	 *         [file/folder Name] [size in KiB]<br>
	 *         [file/folder Name] [size in KiB]<br>
	 *         ...
	 */
	public static String listFolder(String folderPath) {
		// Crear un objeto File con la ruta de la carpeta
		File carpeta = new File(folderPath);

		// Verificar que la ruta corresponde a una carpeta válida
		if (!carpeta.isDirectory()) {
			return Constants.KO;
		}

		// Obtener una lista de archivos en la carpeta
		File[] archivos = carpeta.listFiles();

		// Verificar si la carpeta está vacía
		if (archivos == null || archivos.length == 0) {
			return Constants.KO;
		}

		StringBuilder builder = new StringBuilder();

		builder.append(Constants.OK);
		// Iterar sobre la lista de archivos
		for (File archivo : archivos) {

			if (archivo.isFile()) {

				double fileSize = (archivo.length() / 1024.0);
				// Si es un archivo
				builder.append(archivo.getName()).append(" ").append(fileSize).append("KiB").append("\n");

			} else if (archivo.isDirectory()) {

				// Si es una carpeta
				builder.append(archivo.getName()).append(" 0\n");

			}

		}

		return builder.toString();
	}

	/**
	 * Obtains a String containing information from a text file
	 * 
	 * @param path path of the file
	 * @returna String in the following format: <br>
	 *          If there was some type of error accessing or reading the file: <br>
	 *          {@code KO}<br>
	 *          Else: <br>
	 *          {@code OK} <br>
	 *          [number of lines in the text file]<br>
	 *          [line 1]<br>
	 *          [line 2]<br>
	 *          ...
	 */
	public static String showFile(String path) {

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

			String line;
			int numLines = 0;

			StringBuilder result = new StringBuilder();
			StringBuilder fileContent = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				fileContent.append(line).append("\n");
				numLines++;
			}

			result.append(numLines).append("\n").append(fileContent.toString());

		} catch (Exception e) {

			e.printStackTrace();
			return Constants.KO;
		}
		return null;
	}

}
