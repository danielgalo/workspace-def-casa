package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class PruebaSQL {

	private static final String MYSQL_CON = "jdbc:mysql://localhost:3306/ejemplo?characterEncoding=UTF-8";

	public static void main(String[] args) {
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection(MYSQL_CON, "root", "root");

			Statement sentencia = (Statement) con.createStatement();

			ResultSet rs = (ResultSet) sentencia.executeQuery("SELECT * FROM empleados");

			while (rs.next()) {

				System.out.println(rs.getInt(1) + rs.getString(2));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {

				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();

			}
		}

	}

}
