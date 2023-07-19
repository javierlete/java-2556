package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ipartek.formacion.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/productos/*")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = extraerId(request);

		if (id == null) {
			List<Producto> productos = obtenerTodos();
			mapper.writeValue(response.getWriter(), productos);
		} else {
			Producto producto = obtenerPorId(id);
			
			if(producto == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			mapper.writeValue(response.getWriter(), producto);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Producto producto = mapper.readValue(request.getReader(), Producto.class);
		
		insertar(producto);
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		
		mapper.writeValue(response.getWriter(), producto);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Long id = extraerId(request);
		
		Producto producto = mapper.readValue(request.getReader(), Producto.class);
		
		modificar(producto);
		
		mapper.writeValue(response.getWriter(), producto);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = extraerId(request);
		
		borrar(id);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	
	private Long extraerId(HttpServletRequest request) {
		String path = request.getPathInfo();

		if(path == null) {
			return null;
		}
		
		String numero = path.substring(1);

		Long id = null;
		
		if (!numero.isBlank()) {
			id = Long.parseLong(numero);
		}
		
		return id;
	}

	

	private List<Producto> obtenerTodos() {
		List<Producto> productos = new ArrayList<>();

		try (Connection con = new DBHelper(getServletContext()).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				productos.add(new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"),
						LocalDate.parse(rs.getString("caducidad"))));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	private Producto obtenerPorId(Long id) {
		Producto producto = null;
		
		try (Connection con = new DBHelper(getServletContext()).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_SELECT_ID)) {
			
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"),
						LocalDate.parse(rs.getString("caducidad")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}

	private void insertar(Producto producto) {
		try (Connection con = new DBHelper(getServletContext()).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_INSERT);) {

			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getCaducidad().toString());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void modificar(Producto producto) {
		try (Connection con = new DBHelper(getServletContext()).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_UPDATE);) {

			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getCaducidad().toString());
			pst.setLong(4, producto.getId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void borrar(Long id) {
		try (Connection con = new DBHelper(getServletContext()).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_DELETE)) {

			pst.setLong(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
