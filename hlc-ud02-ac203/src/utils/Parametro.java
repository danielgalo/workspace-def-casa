package utils;

/**
 * Clase para controlar los parámetros de las aplicaciones principales
 */
public class Parametro {

	/** Parámetro mensaje */
	private String mensaje;

	/** Parámetro alias */
	private String alias;

	/**
	 * @param mensaje
	 * @param alias
	 */
	public Parametro(String[] parametros) {

		if (parametros.length != 2) {
			System.err.println(
					"Error, la aplicación debe de tener 2 parámetros. Parámetros introducidos: " + parametros.length);
		} else {
			mensaje = parametros[0];
			alias = parametros[1];
		}

	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

}