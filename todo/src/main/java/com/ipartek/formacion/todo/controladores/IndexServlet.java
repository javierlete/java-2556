package com.ipartek.formacion.todo.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.todo.modelos.Tarea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tarea> tareas = new ArrayList<>();
		
		DBHelper db = new DBHelper(getServletContext());
		
		try (Connection con = db.getConexion();
				PreparedStatement pst = con.prepareStatement(DBHelper.SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			while(rs.next()) {
				tareas.add(new Tarea(rs.getLong("id"), rs.getString("texto"), rs.getBoolean("terminada")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("tareas", tareas);
		
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
