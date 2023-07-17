package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/index")
public class AdminIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String RUTA = getServletContext().getRealPath("/WEB-INF/sql/bases.db");
		final String URL = "jdbc:sqlite:" + RUTA;
		final String SQL_SELECT = "SELECT * FROM productos";
		
		List<Producto> productos = new ArrayList<>();

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				productos.add(new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), LocalDate.parse(rs.getString("caducidad"))));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/index.jsp").forward(request, response);
	}
}
