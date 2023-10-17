package dto;

import java.util.List;

public class EjemploMain {

	public static void main(String[] args) {

		List<Empleado> listaEmpleados = EjemploManagement.getEmpleadoPorCargo("root", "root", "Desarrollador");

		for (Empleado e : listaEmpleados) {
			System.out.println(e.getDatosEmpleado());
		}

	}

}
