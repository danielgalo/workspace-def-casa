package utils;

/**
 * Clase usada para controlar parámetros
 */
public class Parametros {

	/** Nombre del fichero, parámetro obligatorio */
	private String nombreFichero;

	/** Algoritmo a usar, parámetro opcional */
	private String algoritmo;

	/** Algoritmo por defecto */
	private static final String ALGORITMO_DEFECTO = "SHA-256";

	/**
	 * Constructor
	 * 
	 * @param params
	 */
	public Parametros(String[] params) {

		// nombreFichero es un parametro obligatorio
		nombreFichero = params[0];

		// algoritmo es opcional, si no se introduce asignar valor por defecto
		if (params.length < 2) {
			algoritmo = ALGORITMO_DEFECTO;
		} else {
			algoritmo = params[1];
		}

	}

	/**
	 * @return the nombreFichero
	 */
	public String getNombreFichero() {
		return nombreFichero;
	}

	/**
	 * @param nombreFichero the nombreFichero to set
	 */
	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	/**
	 * @return the algoritmo
	 */
	public String getAlgoritmo() {
		return algoritmo;
	}

	/**
	 * @param algoritmo the algoritmo to set
	 */
	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

}
