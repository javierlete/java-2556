package com.ipartek.formacion.amazonia.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.amazonia.modelos.Articulo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cesta")
public class CestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:sqlite:C:\\Users\\java\\git\\java-2556\\amazonia\\sql\\amazonia.db";

	private static final String SQL_SELECT_ID = "SELECT * FROM articulos WHERE id = ?";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		String cantidadString = request.getParameter("cantidad");
		
		Long id = Long.parseLong(idString);
		Integer cantidad = Integer.parseInt(cantidadString);
		
		Articulo articulo = null;

		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				articulo = new Articulo(rs.getLong("id"), rs.getString("descripcion"), rs.getInt("estrellas"), rs.getBigDecimal("precio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("articulo", articulo);
		request.setAttribute("cantidad", cantidad);
		request.getRequestDispatcher("/cesta.jsp").forward(request, response);
	}
}
