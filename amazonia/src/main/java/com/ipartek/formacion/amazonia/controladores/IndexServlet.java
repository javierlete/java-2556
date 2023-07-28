package com.ipartek.formacion.amazonia.controladores;

import static com.ipartek.formacion.amazonia.controladores.DBHelper.getConexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.amazonia.modelos.Articulo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SQL_SELECT = "SELECT * FROM articulos";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var articulos = new ArrayList<Articulo>();

		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			while(rs.next()) {
				articulos.add(new Articulo(rs.getLong("id"), rs.getString("descripcion"), rs.getInt("estrellas"), rs.getBigDecimal("precio")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("articulos", articulos);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
