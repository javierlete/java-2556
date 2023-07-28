package com.ipartek.formacion.amazonia.rest;

import com.ipartek.formacion.amazonia.modelos.Cesta;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("articulos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArticulosApi {
	@PATCH
	@Path("{id}")
	public void put(@PathParam("id") Long id, @QueryParam("cantidad") Integer cantidad, @Context HttpServletRequest request) {
		System.out.println(id);
		System.out.println(cantidad);
		
		Cesta cesta = (Cesta)request.getSession().getAttribute("cesta");
		cesta.cambiarCantidad(id, cantidad);
	}
}