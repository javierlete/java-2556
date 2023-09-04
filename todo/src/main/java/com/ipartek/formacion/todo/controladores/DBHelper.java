package com.ipartek.formacion.todo.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

public class DBHelper {
	public static final String SQL_SELECT = "SELECT * FROM tareas";
	
	private final String URL;
	
	DBHelper(ServletContext context) {
		String ruta = context.getRealPath("/WEB-INF/sql/todo.db");
		URL = "jdbc:sqlite:" + ruta;
	}
	
	public DBHelper(String ruta) {
		URL = "jdbc:sqlite:" + ruta;
	}
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexion() {
		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido conectar a la base de datos: " + URL);
		}
	}
}
