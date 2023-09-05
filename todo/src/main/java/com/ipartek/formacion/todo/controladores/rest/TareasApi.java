package com.ipartek.formacion.todo.controladores.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.todo.controladores.DBHelper;
import com.ipartek.formacion.todo.modelos.Tarea;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("tareas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TareasApi {
	private static final String RUTA = "C:\\Users\\java\\git\\java-2556\\todo\\src\\main\\webapp\\WEB-INF\\sql\\todo.db";

	@GET
	public List<Tarea> get() {
		return obtenerTodos();
	}

	@GET
	@Path("{id}")
	public Response getId(@PathParam("id") Long id) {
		Tarea tarea = obtenerPorId(id);
		
		if(tarea == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			return Response.ok(tarea).build();
		}
	}

	@POST
	public Response post(Tarea tarea) {
		insertar(tarea);

		return Response.ok(tarea).status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("{id}")
	public Tarea put(@PathParam("id") Long id, Tarea tarea) {
		modificar(tarea);

		return tarea;
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		borrar(id);
	}
	
	@PATCH
	@Path("{id}")
	public void patchTerminada(@PathParam("id") Long id, Tarea tarea) {
		modificarTerminada(id, tarea);
	}

	private void modificarTerminada(Long id, Tarea tarea) {
		try (Connection con = new DBHelper(RUTA).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_UPDATE_TERMINADO);) {

			pst.setBoolean(1, tarea.isTerminada());
			pst.setLong(2, tarea.getId());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private List<Tarea> obtenerTodos() {
		List<Tarea> tareas = new ArrayList<>();

		try (Connection con = new DBHelper(RUTA).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				tareas.add(new Tarea(rs.getLong("id"), rs.getString("texto"), rs.getBoolean("terminada")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tareas;
	}

	private Tarea obtenerPorId(Long id) {
		Tarea tarea = null;

		try (Connection con = new DBHelper(RUTA).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_SELECT_ID)) {

			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				tarea = new Tarea(rs.getLong("id"), rs.getString("texto"), rs.getBoolean("terminada"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tarea;
	}

	private void insertar(Tarea tarea) {
		try (Connection con = new DBHelper(RUTA).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_INSERT);) {

			pst.setString(1, tarea.getTexto());
			pst.setBoolean(2, tarea.isTerminada());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void modificar(Tarea tarea) {
		try (Connection con = new DBHelper(RUTA).getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_UPDATE);) {

			pst.setString(1, tarea.getTexto());
			pst.setBoolean(2, tarea.isTerminada());
			pst.setLong(3, tarea.getId());

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
