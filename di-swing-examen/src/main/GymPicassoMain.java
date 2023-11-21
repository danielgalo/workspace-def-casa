package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.Clase;
import dto.Reserva;
import dto.User;
import gui.PLogin;

public class GymPicassoMain {

	public static List<User> users = new ArrayList<>();
	public static List<Clase> clases = new ArrayList<>();
	public static List<Reserva> reservas = new ArrayList<>();

	public static void main(String[] args) {

		User cliente1 = new User("Paco", "Peña", new Date(), "paco@email.es", "Cliente", "123");
		User cliente2 = new User("Marco", "Polo", new Date(), "marco@email.es", "Cliente", "123");

		Clase clase1 = new Clase("Zumba", "Juanma", "Tarde");
		Clase clase2 = new Clase("Spinning", "Dani", "Mañana");

		users.add(cliente1);
		users.add(cliente2);
		users.add(new User("Paqui", "Peña", new Date(), "paqui@email.es", "Administrador", "123"));

		reservas.add(new Reserva(cliente1, clase1, clase1.getTurno()));
		reservas.add(new Reserva(cliente2, clase2, clase2.getTurno()));

		clases.add(clase2);
		clases.add(clase1);

		PLogin login = new PLogin();
		login.setVisible(true);

	}

}
