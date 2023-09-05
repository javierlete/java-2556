package com.ipartek.formacion.todo.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

public class DBHelper {
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String PREFIJO_JDBC = "jdbc:sqlite:";
	private static final String RUTA_DB = "/WEB-INF/sql/todo.db";

	public static final String SQL_SELECT = "SELECT * FROM tareas";
	public static final String SQL_INSERT = "INSERT INTO tareas (texto, terminada) VALUES (?,?)";
	public static final String SQL_UPDATE = "UPDATE tareas SET texto=?, terminada=? WHERE id=?";
	public static final String SQL_UPDATE_TERMINADO = "UPDATE tareas SET terminada=? WHERE id=?";
	public static final String SQL_DELETE = "DELETE FROM tareas WHERE id=?";

	private final String URL;
	
	public DBHelper(ServletContext context) {
		String ruta = context.getRealPath(RUTA_DB);
		URL = PREFIJO_JDBC + ruta;
	}
	
	public DBHelper(String ruta) {
		URL = PREFIJO_JDBC + ruta;
	}
	
	static {
		try {
			Class.forName(DRIVER);
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
