package com.ipartek.formacion.amazonia.controladores;

import static com.ipartek.formacion.amazonia.controladores.DBHelper.getConexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.amazonia.modelos.Articulo;
import com.ipartek.formacion.amazonia.modelos.Cesta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cesta")
public class CestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SQL_SELECT_ID = "SELECT * FROM articulos WHERE id = ?";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/cesta.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		String cantidadString = request.getParameter("cantidad");
		
		Long id = Long.parseLong(idString);
		Integer cantidad = Integer.parseInt(cantidadString);
		
		Articulo articulo = null;

		try (Connection con = getConexion();
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
		
		articulo.setCantidad(cantidad);
		
		Cesta cesta = (Cesta) request.getSession().getAttribute("cesta");
		cesta.agregarArticulo(articulo);
		
		response.sendRedirect(request.getContextPath() + "/cesta");
	}
}
