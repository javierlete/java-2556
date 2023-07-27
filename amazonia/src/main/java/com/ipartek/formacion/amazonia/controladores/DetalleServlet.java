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
import static com.ipartek.formacion.amazonia.controladores.Globales.*;

@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SQL_SELECT_ID = "SELECT * FROM articulos WHERE id = ?";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		
		Long id = Long.parseLong(idString);
		
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
		request.getRequestDispatcher("/detalle.jsp").forward(request, response);
	}
}
