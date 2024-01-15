package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Hello world!
 *
 */
public class WikiAPI {
	public static void main(String[] args) {

		String searchTerm = "Java programming";

		try {
			// Codificar el término de búsqueda
			String encodedSearchTerm = URLEncoder.encode(searchTerm, "UTF-8");

			String apiUrl = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&titles="
					+ encodedSearchTerm;

			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}

			saveJsonToFile(response.toString(), "output.json");

			reader.close();

			// Procesar la respuesta JSON según tus necesidades
			System.out.println(response.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void saveJsonToFile(String json, String fileName) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
			writer.println(json);
			System.out.println("Respuesta JSON guardada en " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
