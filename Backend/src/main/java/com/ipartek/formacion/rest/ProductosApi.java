package com.ipartek.formacion.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.controladores.DBHelper;
import com.ipartek.formacion.modelos.Producto;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("productos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductosApi {
	private static final String RUTA = "C:\\Users\\java\\git\\java-2556\\Backend\\src\\main\\webapp\\WEB-INF\\sql\\bases.db";

	@GET
	public List<Producto> get() {
		return obtenerTodos();
	}

	@GET
	@Path("{id}")
	public Producto getId(@PathParam("id") Long id) {
		return obtenerPorId(id);
	}

	@POST
	public Producto post(Producto producto) {
		insertar(producto);

		return producto;
	}

	@PUT
	@Path("{id}")
	public Producto put(@PathParam("id") Long id, Producto producto) {
		modificar(producto);

		return producto;
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		borrar(id);
	}

	private List<Producto> obtenerTodos() {
		List<Producto> productos = new ArrayList<>();

		try (Connection con = new DBHelper(RUTA).getConexion();
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

		try (Connection con = new DBHelper(RUTA).getConexion();
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
		try (Connection con = new DBHelper(RUTA).getConexion();
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
		try (Connection con = new DBHelper(RUTA).getConexion();
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
		try (Connection con = new DBHelper(RUTA).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_DELETE)) {

			pst.setLong(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
