package psp.act303.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Process the properties of a given file.
 */
public class PropertiesProcessor {

	/** Path to the properties file */
	private String propertiesFile;

	/**
	 * Constructor
	 * 
	 * @param propertiesFile properties file
	 */
	public PropertiesProcessor(String propertiesFile) {
		this.propertiesFile = propertiesFile;
	}

	/**
	 * Obtain a property value given it's name
	 * 
	 * @param propertyName name of the property
	 * @param defaultValue default value to assign in case something goes wrong
	 * @return the value of the property or default in case it's not valid
	 */
	public String getProperty(String propertyName, String defaultValue) {

		Properties properties = new Properties();
		String propertyValue = null;

		try (FileInputStream fileInputStream = new FileInputStream(propertiesFile)) {

			// Cargar las propiedades, obtener el valor de la propiedad
			properties.load(fileInputStream);
			propertyValue = properties.getProperty(propertyName);

			// Si el valor es nulo (la propiedad no es correcta) asignar valor por defecto
			if (propertyValue == null || propertyValue.isBlank()) {
				// Set default value
				propertyValue = defaultValue;
			}

		} catch (Exception e) {
			// Si ocurre un error leyendo el archivo o parseando, asignar valor por defecto
			propertyValue = defaultValue;
			e.printStackTrace();
		}

		return propertyValue;
	}

}
