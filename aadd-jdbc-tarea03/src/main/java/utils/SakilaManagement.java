package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.Pelicula;

/**
 * Clase encargada de administrar las consultas y modificaciones a la base de
 * datos sakila
 */
public class SakilaManagement {

	/** Select de peliculas */
	private static final String SELECT_ALL_PELICULAS = "SELECT * FROM film";

	/** Insert de peliculas */
	private static final String INSERT_PELICULAS = "INSERT INTO film (title, description, release_year, rating) VALUES (?, ?, ?, ?)";

	/** Select de actores */
	private static final String SELECT_ACTORES = "select * from actor inner join film_actor on film_actor.actor_id = actor.actor_id inner join film on film.film_id = film_actor.film_id where film.film_id = ?";

	/** Resultset actores */
	private ResultSet resultSetActores;

	/** ResultSet de peliculas */
	private ResultSet resultSetPeliculas;

	/** Conexion */
	private Connection con;

	/**
	 * Constructor
	 */
	public SakilaManagement() {
		con = Conexion.conectar();
	}

	/**
	 * Obtiene resultset con actores por película
	 * 
	 * @param pelicula
	 */
	public void getActoresByPeliculas(int id) {

		try {

			PreparedStatement sentencia = con.prepareStatement(SELECT_ACTORES);
			sentencia.setInt(1, id);

			resultSetActores = sentencia.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	/**
	 * Saca todas las películas de la tabla film a una lista de objetos Pelicula
	 * 
	 * @return resultSet de peliculas
	 */
	public void getAllPeliculas() {

		try {

			Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSetPeliculas = sentencia.executeQuery(SELECT_ALL_PELICULAS);

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void insertaPelicula(Pelicula pelicula) {

		try {

			PreparedStatement sentencia = con.prepareStatement(INSERT_PELICULAS);
			sentencia.setString(1, "'" + pelicula.getTitle() + "'");
			sentencia.setString(2, "'" + pelicula.getDescription() + "'");
			sentencia.setInt(3, pelicula.getReleaseYear());
			sentencia.setString(4, "'" + pelicula.getRating() + "'");

			sentencia.executeUpdate();

			System.out.println("INSERT OK");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	/**
	 * Cierra una conexion SQL
	 * 
	 * @param con
	 */
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return the resultSet
	 */
	public ResultSet getResultSetPeliculas() {
		return resultSetPeliculas;
	}

	/**
	 * @return the resultSetActores
	 */
	public ResultSet getResultSetActores() {
		return resultSetActores;
	}

}
