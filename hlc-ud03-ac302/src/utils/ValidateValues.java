package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidateValues {

	private static final String TELEFONO_FIJO = "telefonoFijo";
	private static final String COMUNIDAD = "comunidad";
	private static final String INTERESES = "intereses";
	private static final String LOCALIDAD = "localidad";
	private static final String TELEFONO_MOVIL = "telefonoMovil";
	private static final String NOMBRE_APELLIDOS = "nombreApellidos";
	private static final String NUMERO_HIJOS = "numeroHijos";
	private static final String FECHA_NACIMIENTO = "fechaNacimiento";
	private Map<String, String> valueMap;
	private List<String> listaErrores;
	private List<String> listaDatosOk;

	/**
	 * Constructor
	 * 
	 * @param valueMap
	 */
	public ValidateValues(Map<String, String> valueMap) {
		setValueMap(valueMap);
		listaErrores = new ArrayList<String>();
		listaDatosOk = new ArrayList<String>();

	}

	/**
	 * Valida todos los datos del mapa
	 * 
	 * @return
	 */
	public void validateAll() {

		for (String key : valueMap.keySet()) {

			String valor = valueMap.get(key);

			switch (key) {

			case FECHA_NACIMIENTO:

				if (Validation.checkFechaNacimiento(valor)) {
					addDatoCorrecto(key, valor);
				} else {
					addError(key, valor);
				}

				break;

			case NUMERO_HIJOS:

				if (Validation.checkNumeroHijos(valor)) {
					addDatoCorrecto(key, valor);
				} else {
					addError(key, valor);
				}

				break;

			case NOMBRE_APELLIDOS:

				if (Validation.checkNombre(valor)) {
					addDatoCorrecto(key, valor);
				} else {
					addError(key, valor);
				}

				break;

			case TELEFONO_MOVIL:

				if (Validation.checkTelefonoMovil(valor)) {
					addDatoCorrecto(key, valor);
				} else {
					addError(key, valor);
				}

				break;

			case LOCALIDAD:

				if (Validation.checkNombre(valor)) {
					addDatoCorrecto(key, valor);
				} else {
					addError(key, valor);
				}

				break;

			case INTERESES:

				if (Validation.checkNombre(valor)) {
					addDatoCorrecto(key, valor);
				} else {
					addError(key, valor);
				}

				break;

			case COMUNIDAD:

				if (Validation.checkNombre(valor)) {
					addDatoCorrecto(key, valor);
				} else {
					addError(key, valor);
				}

				break;

			case TELEFONO_FIJO:

				if (Validation.checkNombre(valor)) {
					addDatoCorrecto(key, valor);
				} else {
					addError(key, valor);
				}

				break;

			}

		}

	}

	/**
	 * 
	 * @param mensaje
	 * @param valor
	 */
	private void addDatoCorrecto(String mensaje, String valor) {
		listaDatosOk.add(mensaje + " OK: " + valor);
	}

	/**
	 * 
	 * @param mensaje
	 * @param valor
	 */
	private void addError(String mensaje, String valor) {
		listaErrores.add(mensaje + " incorrecto: " + valor);
	}

	/**
	 * @return the valueMap
	 */
	public Map<String, String> getValueMap() {
		return valueMap;
	}

	/**
	 * @param valueMap the valueMap to set
	 */
	public void setValueMap(Map<String, String> valueMap) {
		this.valueMap = valueMap;
	}

	/**
	 * @return the listaErrores
	 */
	public List<String> getListaErrores() {
		return listaErrores;
	}

	/**
	 * @return the listaDatosOk
	 */
	public List<String> getListaDatosOk() {
		return listaDatosOk;
	}

	/**
	 * @param listaDatosOk the listaDatosOk to set
	 */
	public void setListaDatosOk(List<String> listaDatosOk) {
		this.listaDatosOk = listaDatosOk;
	}

}
