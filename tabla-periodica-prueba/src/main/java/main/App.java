package main;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kong.unirest.Unirest;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		kong.unirest.HttpResponse<String> response = Unirest
				.get("https://periodic-table-elements-info.herokuapp.com/element/atomicName/Sodium").asString();

		// Utilizar GSON para parsear el JSON
		JsonObject searchResult = JsonParser.parseString(response.toString()).getAsJsonObject();
		JsonArray results = searchResult.getAsJsonArray("results");

		if (results.size() > 0) {
			JsonObject firstResult = results.get(0).getAsJsonObject();

			System.out.println(firstResult.get("symbol"));

		} else {
			System.out.println("No se encontraron resultados para la búsqueda.");
		}

		System.out.println(response.getBody());
	}
}
