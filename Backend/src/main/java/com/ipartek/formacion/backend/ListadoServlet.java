package com.ipartek.formacion.backend;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Producto> productos = new ArrayList<>();
		
		productos.add(new Producto(1L, "Producto1", new BigDecimal("123.12"), LocalDate.of(2024,  2, 3)));
		productos.add(new Producto(2L, "Producto2", new BigDecimal("223.12"), LocalDate.of(2024,  12, 13)));
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}
}
