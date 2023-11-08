package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Clase usada para la verificación de campos usando expresiones regulares
 */
public class Validation {

	private static final String REGEX_NOMBRE = "^(\\p{Lu}\\p{Ll}*|[ÁÉÍÓÚÜÑÑáéíóúüññ])+(\\s(\\p{Lu}\\p{Ll}*|[ÁÉÍÓÚÜÑÑáéíóúüññ])*)*$";
	private static final String REGEX_FECHA = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
	private static final String REGEX_TLFN_FIJO = "^[9]\\d{8}$";
	private static final String REGEX_TLFN_MOVIL = "^(\\+[0-9]{0,6})?\\s?[0-9]{9}$";
	private static final String REGEX_NUM_HIJOS = "[0-9]+";
	private static final String REGEX_LOCALIDAD = "^[A-ZÁÉÍÓÚÜÑ][a-zA-ZÁÉÍÓÚÜÑáéíóúüñ\\s]{0,49}$";
	private static List<String> listaComunidades;
	private static List<String> listaIntereses;

	/**
	 * Constructor vacío para evitar instancias
	 */
	private Validation() {

	}

	/**
	 * Comprueba el nombre de usuario
	 * 
	 * @param nombreUsuario
	 * @return true si no está vacío y cada palabra empieza por mayúscula
	 */
	public static boolean checkNombre(String nombreUsuario) {

		if (nombreUsuario == null || nombreUsuario.isBlank()) {
			return false;
		}

		return Pattern.matches(REGEX_NOMBRE, nombreUsuario);

	}

	/**
	 * Comprueba una fecha de nacimiento
	 * 
	 * @param fechaNacimiento
	 * @return true sólo si la fecha es menor a la actual, cumple con el formato
	 *         "dd/MM/yyyy" y no está vacía
	 */
	public static boolean checkFechaNacimiento(String fechaNacimiento) {
		return Pattern.matches(REGEX_FECHA, fechaNacimiento) && isFechaMenor(fechaNacimiento)
				&& !fechaNacimiento.isBlank();
	}

	/**
	 * Comprueba un número de teléfono fijo nacional
	 * 
	 * @param tlfnFijo
	 * @return true sólo si el número tiene 9 dígitos, empezando por "9" o si está
	 *         vacío ya que es opcional
	 */
	public static boolean checkTelefonoFijo(String tlfnFijo) {
		return Pattern.matches(REGEX_TLFN_FIJO, tlfnFijo) || tlfnFijo.isBlank();
	}

	/**
	 * Comprueba un número de teléfono móvil internacional
	 * 
	 * @param tlfnMovil
	 * @return true sólo si el teléfono cumple con el formato internacional (prefijo
	 *         con espacio opcional)
	 */
	public static boolean checkTelefonoMovil(String tlfnMovil) {
		return Pattern.matches(REGEX_TLFN_MOVIL, tlfnMovil) && !tlfnMovil.isBlank();
	}

	/**
	 * Comprueba el número de hijos
	 * 
	 * @param numeroHijos
	 * @return true sólo si numeroHijos es un dígito entero, es superior o igual a 0
	 *         y no está vacío
	 */
	public static boolean checkNumeroHijos(String numeroHijos) {

		// Pasar a int para comprobar si es mayor o igual a 0
		int numeroHijosInt;

		try {
			numeroHijosInt = Integer.parseInt(numeroHijos);
		} catch (NumberFormatException e) {
			return false;
		}

		return Pattern.matches(REGEX_NUM_HIJOS, numeroHijos) && numeroHijosInt >= 0 && !numeroHijos.isBlank();

	}

	/**
	 * Comprueba la comunidad autónoma
	 * 
	 * @param comunidadAutonoma
	 * @return true sólo si comunidadAutonoma coincide con las comunidades de la
	 *         lista de comunidades
	 */
	public static boolean checkComunidadAutonoma(String comunidadAutonoma) {
		listaComunidades = new ArrayList<>();
		addComunidades();

		return listaComunidades.contains(comunidadAutonoma) && !comunidadAutonoma.isBlank();
	}

	/**
	 * Comprueba la localidad
	 * 
	 * @param localidad
	 * @return true sólo si localidad empieza por mayúscula, tiene de 1 a 50
	 *         carácteres no numéricos y no está vacío
	 */
	public static boolean checkLocalidad(String localidad) {
		return Pattern.matches(REGEX_LOCALIDAD, localidad) && !localidad.isBlank();
	}

	/**
	 * Comprueba los intereses
	 * 
	 * @param intereses pueden ser uno o más separados por ","
	 * @return
	 */
	public static boolean checkIntereses(String interesesStr) {

		boolean resultado = true;

		// Consigue lista con los intereses introducidos por el usuario
		List<String> interesesIntroducidos = getListaInteresesIntroducidos(interesesStr);

		// Inicializa la lista con intereses válidos por defecto
		listaIntereses = new ArrayList<String>();
		addIntereses();

		// Elimina posibles intereses repetidos
		Set<String> interesesNoRepetidos = listaToSet(interesesIntroducidos);

		// Comprueba que los intereses sean correctos, no puede fallar ninguno
		for (String interes : interesesNoRepetidos) {
			if (!listaIntereses.contains(interes)) {
				resultado = false;
				break;
			}
		}

		return resultado;
	}

	/**
	 * Obtiene una lista con los intereses introducidos, separando interesesStr por
	 * ","
	 * 
	 * @param interesesStr
	 * @return la lista
	 */
	private static List<String> getListaInteresesIntroducidos(String interesesStr) {
		String[] intereses = interesesStr.split(",");
		List<String> interesesIntroducidos = new ArrayList<>();

		for (String interes : intereses) {
			interesesIntroducidos.add(interes);
		}
		return interesesIntroducidos;
	}

	/**
	 * Obtiene un set a partir de una lista de String
	 * 
	 * @param lista
	 * @return el set
	 */
	private static Set<String> listaToSet(List<String> lista) {

		Set<String> set = new HashSet<String>();

		for (String str : lista) {
			set.add(str);
		}

		return set;
	}

	/**
	 * Rellena la lista de comunidades
	 * 
	 * @param listaComunidades
	 */
	private static void addIntereses() {
		listaIntereses.add("Lectura");
		listaIntereses.add("Videojuegos");
		listaIntereses.add("Series");
		listaIntereses.add("Películas");
		listaIntereses.add("Actividades al aire libre");
		listaIntereses.add("Deportes");
		listaIntereses.add("Tecnología");
		listaIntereses.add("Manualidades");
	}

	/**
	 * Rellena la lista de comunidades
	 * 
	 * @param listaComunidades
	 */
	private static void addComunidades() {
		listaComunidades.add("Andalucía");
		listaComunidades.add("Extremadura");
		listaComunidades.add("Otra");
	}

	/**
	 * Compara la fecha con la actual
	 * 
	 * @param fecha
	 * @return true sólo si la fecha pasada es menor que la actual
	 */
	private static boolean isFechaMenor(String fecha) {

		try {
			// Fecha y formato
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaIngresada = sdf.parse(fecha);

			// Fecha actual
			Date fechaActual = new Date();

			// Comparar fechas
			return fechaIngresada.before(fechaActual);

		} catch (ParseException e) {

			return false;

		}
	}
}
