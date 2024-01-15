package psp.unidad03.practica01.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Procesador de propiedades
 */
public class PropertiesProcessor {

	/** Archivo de propiedades */
	private String propertiesFile;

	/**
	 * Constructor sobrecargado
	 * 
	 * @param propertiesFile
	 */
	public PropertiesProcessor(String propertiesFile) {
		this.propertiesFile = propertiesFile;
	}

	/**
	 * Obtiene el valor de una propiedad a través de su nombre o un mensaje de error
	 * si la propiedad no está presente en el archivo
	 * 
	 * @param propertyName el nombre de la propiedad
	 * @return El valor de la propiedad o un mensaje informativo si no se encuentra
	 *         esta.
	 */
	public String getProperty(String propertyName) {

		Properties properties = new Properties();
		String propertyValue = null;

		try (FileInputStream fis = new FileInputStream(propertiesFile)) {

			// Cargar archivo
			properties.load(fis);

			// Obtener propiedad
			propertyValue = properties.getProperty(propertyName);

			// Si no se encuentra la propiedad, asignar mensaje de error.
			if (propertyValue == null) {
				propertyValue = "El nombre no se encuentra";
			}

		} catch (IOException e) {

			// Si hubo error accediendo al archivo, asignar mensaje de error.
			propertyValue = "El nombre no se encuentra";
			e.printStackTrace();
		}

		return propertyValue;

	}

}
