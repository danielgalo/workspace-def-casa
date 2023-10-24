package utils;

/**
 * Clase para controlar los parámetros de las aplicaciones principales
 */
public class Parametro {

	private static final String MSG_POR_DEFECTO = "Hola";

	private static final String ALIAS_KEYSTORE = "claves";

	/** Parámetro mensaje */
	private String mensaje;

	/** Parámetro alias */
	private String alias;

	/**
	 * @param mensaje
	 * @param alias
	 */
	public Parametro(String[] parametros) {

		if (parametros.length < 1) {
			mensaje = MSG_POR_DEFECTO;
		} else {
			mensaje = parametros[0];
		}

		if (parametros.length < 2) {
			alias = ALIAS_KEYSTORE;
		} else {
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
