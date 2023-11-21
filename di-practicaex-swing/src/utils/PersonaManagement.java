package utils;

import java.util.ArrayList;
import java.util.List;

import dao.Persona;

public class PersonaManagement {

	public static List<Persona> personas = new ArrayList<Persona>();

	public static void addPersona(Persona p) {
		personas.add(p);
	}

	public static void removePersona(String nombre) {
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getNombre().equals(nombre)) {
				personas.remove(i);
			}
		}
	}

}
