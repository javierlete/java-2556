package com.ipartek.formacion.amazonia.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static final String URL = "jdbc:sqlite:C:\\Users\\java\\git\\java-2556\\amazonia\\sql\\amazonia.db";
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConexion() {
		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido hacer la conexion", e);
		}
	}
}
