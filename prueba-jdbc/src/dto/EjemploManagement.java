package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para hacer operaciones con la base de datos ejemplo
 */
public class EjemploManagement {

	/** Cadena usada para el Class.forname */
	private static final String JDBC_CLASS_NAME = "com.mysql.jdbc.Driver";

	/** Conexion para la base de datos */
	private static final String MYSQL_CON = "jdbc:mysql://localhost:3306/ejemplo?characterEncoding=UTF-8";

	/**
	 * Realiza una consulta sobre la base de datos ejemplo y devuelve una lista con
	 * los empleados que tengan el cargo pasado por parámetros
	 * 
	 * @param usuarioBd  el usuario de la base de datos
	 * @param passwordBd la password de la base de datos
	 * @param cargoEmp   el cargo del empleado para filtar
	 * @return la lista de empleados con dicho cargo
	 */
	public static List<Empleado> getEmpleadoPorCargo(String usuarioBd, String passwordBd, String cargoEmp) {

		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		Connection con = null;

		// Select a realizar
		String select = "SELECT * FROM empleados WHERE cargo = ?";

		try {

			Class.forName(JDBC_CLASS_NAME);

			// Conseguir conexion
			con = DriverManager.getConnection(MYSQL_CON, usuarioBd, passwordBd);

			// Preparar sentencia
			PreparedStatement sentencia = con.prepareStatement(select);
			sentencia.setString(1, cargoEmp);

			// Ejecutar select
			ResultSet resultado = sentencia.executeQuery();

			// Recorrer resultset y crear empleados, añadirlos a la lista
			while (resultado.next()) {

				Empleado emp = new Empleado(resultado.getInt("id"), resultado.getString("nombre"),
						resultado.getString("apellido"), resultado.getString("cargo"), resultado.getDouble("salario"),
						resultado.getString("fecha_contratacion"), resultado.getInt("empresa_id"));

				listaEmpleados.add(emp);

			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		} finally {
			// Cerrar conexion
			closeConnection(con);

		}

		return listaEmpleados;
	}

	/**
	 * Cierra la conexion a la base de datos
	 * 
	 * @param conexion a cerrar
	 */
	private static void closeConnection(Connection con) {

		try {

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
