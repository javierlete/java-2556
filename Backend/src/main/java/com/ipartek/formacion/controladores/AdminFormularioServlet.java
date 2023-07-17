package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ipartek.formacion.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/formulario")
public class AdminFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, caducidad) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?,precio=?,caducidad=? WHERE id=?";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");

		if (idString != null && idString.trim().length() > 0) {

			Long id = Long.parseLong(idString);

			final String RUTA = getServletContext().getRealPath("/WEB-INF/sql/bases.db");
			final String URL = "jdbc:sqlite:" + RUTA;
			final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=?";

			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try (Connection con = DriverManager.getConnection(URL);
					PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {

				pst.setLong(1, id);
				ResultSet rs = pst.executeQuery();

				Producto producto = null;

				if (rs.next()) {
					producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"),
							LocalDate.parse(rs.getString("caducidad")));
					request.setAttribute("producto", producto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/formulario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recogemos todos los datos de la petición
		String idString = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precioString = request.getParameter("precio");
		String caducidadString = request.getParameter("caducidad");

		// Convertimos
		Long id = null;

		if (idString != null && idString.trim().length() > 0) {
			id = Long.parseLong(idString);
		}

		BigDecimal precio = new BigDecimal(precioString);
		LocalDate caducidad = LocalDate.parse(caducidadString);

		// Empaquetamos en objeto del modelo
		Producto producto = new Producto(id, nombre, precio, caducidad);

		// Hacemos lo que queremos hacer
		if (id == null) {
			insertar(producto);
		} else {
			modificar(producto);
		}

		response.sendRedirect(request.getContextPath() + "/admin/index");
	}

	private void insertar(Producto producto) {
		final String RUTA = getServletContext().getRealPath("/WEB-INF/sql/bases.db");
		final String URL = "jdbc:sqlite:" + RUTA;
		
		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {

			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getCaducidad().toString());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void modificar(Producto producto) {
		final String RUTA = getServletContext().getRealPath("/WEB-INF/sql/bases.db");
		final String URL = "jdbc:sqlite:" + RUTA;
		
		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getCaducidad().toString());
			pst.setLong(4, producto.getId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
