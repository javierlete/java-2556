package com.ipartek.formacion.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

public class DBHelper {
	static final String SQL_SELECT = "SELECT * FROM productos";
	static final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=?";
	static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, caducidad) VALUES (?,?,?)";
	static final String SQL_UPDATE = "UPDATE productos SET nombre=?,precio=?,caducidad=? WHERE id=?";
	static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";
	
	private final String RUTA;
	private final String URL;
	
	public DBHelper(ServletContext context) {
		RUTA = context.getRealPath("/WEB-INF/sql/bases.db");
		URL = "jdbc:sqlite:" + RUTA;
	}
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	Connection getConexion() {
		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido conectar a la base de datos: " + URL);
		}
	}
}
