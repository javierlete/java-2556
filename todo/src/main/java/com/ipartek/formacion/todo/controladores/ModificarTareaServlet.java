package com.ipartek.formacion.todo.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ipartek.formacion.todo.modelos.Tarea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modificar-tarea")
public class ModificarTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		String texto = request.getParameter("texto");
		String strTerminada = request.getParameter("terminada");
		
		Long id = Long.parseLong(strId);
		Boolean terminada = strTerminada != null;
		
		Tarea tarea = new Tarea(id, texto, terminada);
		
		DBHelper db = new DBHelper(getServletContext());
		
		try (Connection con = db.getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_UPDATE)) {
			pst.setString(1, tarea.getTexto());
			pst.setBoolean(2, tarea.isTerminada());
			pst.setLong(3, tarea.getId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("index");
	}
}
