package com.ipartek.formacion.amazonia.modelos;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var articulos = new ArrayList<Articulo>();

		for (Long id = 1L; id <= 10; id++) {
			articulos.add(new Articulo(id, "Artículo " + id, id.intValue(), new BigDecimal(id)));
		}

		request.setAttribute("articulos", articulos);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
