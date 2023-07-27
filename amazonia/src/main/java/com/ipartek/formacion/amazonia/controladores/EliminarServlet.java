package com.ipartek.formacion.amazonia.controladores;

import java.io.IOException;

import com.ipartek.formacion.amazonia.modelos.Cesta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/eliminar")
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = request.getParameter("id");
		
		Long id = Long.parseLong(idString);
		
		Cesta cesta = (Cesta) request.getSession().getAttribute("cesta");
		cesta.eliminarArticulo(id);
		
		response.sendRedirect(request.getContextPath() + "/cesta");
	}
}
