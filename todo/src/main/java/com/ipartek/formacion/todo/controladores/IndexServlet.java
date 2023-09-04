package com.ipartek.formacion.todo.controladores;

import java.io.IOException;
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
		
		tareas.add(new Tarea(1L, "Tarea 1", false));
		tareas.add(new Tarea(2L, "Tarea 2", true));
		tareas.add(new Tarea(3L, "Tarea 3", true));
		
		request.setAttribute("tareas", tareas);
		
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
