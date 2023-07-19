package com.ipartek.formacion.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

public class DBHelper {
	public static final String SQL_SELECT = "SELECT * FROM productos";
	public static final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=?";
	public static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, caducidad) VALUES (?,?,?)";
	public static final String SQL_UPDATE = "UPDATE productos SET nombre=?,precio=?,caducidad=? WHERE id=?";
	public static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";
	
	private final String URL;
	
	DBHelper(ServletContext context) {
		String ruta = context.getRealPath("/WEB-INF/sql/bases.db");
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
