package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VideoGPrueba {
	public static void main(String[] args) {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
				"https://free-to-play-games-database.p.rapidapi.com/api/filter?tag=3d.mmorpg.fantasy.pvp&platform=pc"))
				.header("X-RapidAPI-Key", "4e1a5bb75cmshb3c2c39e63786b2p106186jsnec5dac4fdc31")
				.header("X-RapidAPI-Host", "free-to-play-games-database.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			String responseBody = response.body();

			// Guardar la respuesta en un archivo JSON
			saveJsonToFile(responseBody, "response.json");

		} catch (IOException | InterruptedException e) {
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
