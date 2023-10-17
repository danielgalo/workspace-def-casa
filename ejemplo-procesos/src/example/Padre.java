package example;

import java.io.IOException;

public class Padre {

	public static void main(String[] args) {

		ProcessBuilder builder = new ProcessBuilder("java", "example/Hija.java");

		try {
			Process proceso = builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
