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

@WebServlet("/nueva-tarea")
public class NuevaTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto = request.getParameter("texto");
		
		Tarea tarea = new Tarea(null, texto, false);
		
		DBHelper db = new DBHelper(getServletContext());
		
		try (Connection con = db.getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_INSERT)) {
			pst.setString(1, tarea.getTexto());
			pst.setBoolean(2, tarea.isTerminada());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index");
	}
}
