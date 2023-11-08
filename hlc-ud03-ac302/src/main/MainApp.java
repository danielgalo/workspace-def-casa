package main;

import java.util.List;
import java.util.Map;

import utils.FileUtils;
import utils.ValidateValues;

public class MainApp {

	public static void main(String[] args) {

		FileUtils fu = new FileUtils("files/datos.txt");

		Map<String, String> map = fu.getMapaContenido();

//		for (String key : map.keySet()) {
//			String value = map.get(key);
//			System.out.println("Key = " + key + " | Value = " + value);
//		}

		ValidateValues validacion = new ValidateValues(map);

		validacion.validateAll();

		System.out.println("---- Datos correctos: ----");
		imprimeLista(validacion.getListaDatosOk());
		System.out.println();

		System.out.println("---- Datos erróneos: -----");
		imprimeLista(validacion.getListaErrores());

	}

	private static void imprimeLista(List<String> lista) {
		for (String string : lista) {
			System.out.println(string);
		}
	}

}
