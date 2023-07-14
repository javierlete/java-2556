package com.ipartek.formacion.backend;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ipartek.formacion.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String precioString = request.getParameter("precio");
		String caducidadString = request.getParameter("caducidad");
		
		BigDecimal precio = new BigDecimal(precioString);
		LocalDate caducidad = LocalDate.parse(caducidadString);
		
		Producto producto = new Producto(null, nombre, precio, caducidad);
		
		final String RUTA = getServletContext().getRealPath("/WEB-INF/sql/bases.db");
		final String URL = "jdbc:sqlite:" + RUTA;
		final String SQL_INSERT = "INSERT INTO productos (nombre, precio, caducidad) VALUES (?,?,?)";
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {

			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getCaducidad().toString());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("listado");		
	}
}
