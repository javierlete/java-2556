package com.ipartek.formacion.todo.controladores.api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ipartek.formacion.todo.controladores.DBHelper;
import com.ipartek.formacion.todo.modelos.Tarea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/terminada")
public class TerminadoTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		String strTerminada = request.getParameter("terminada");
		
		Long id = Long.parseLong(strId);
		Boolean terminada = strTerminada.equals("true");
		
		Tarea tarea = new Tarea(id, null, terminada);
		
		DBHelper db = new DBHelper(getServletContext());
		
		try (Connection con = db.getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_UPDATE_TERMINADO)) {
			pst.setBoolean(1, tarea.isTerminada());
			pst.setLong(2, tarea.getId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			e.printStackTrace();
		}
	}
}
