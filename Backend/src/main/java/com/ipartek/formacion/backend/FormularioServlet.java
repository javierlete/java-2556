package com.ipartek.formacion.backend;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String precioString = request.getParameter("precio");
		String caducidadString = request.getParameter("caducidad");
		
		BigDecimal precio = new BigDecimal(precioString);
		LocalDate caducidad = LocalDate.parse(caducidadString);
		
		Producto producto = new Producto(null, nombre, precio, caducidad);
		
		response.getWriter().println(producto);
	}
}
