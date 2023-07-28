package com.ipartek.formacion.amazonia.rest;

import java.math.BigDecimal;

import com.ipartek.formacion.amazonia.modelos.Cesta;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("cesta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CestaApi {
	private Cesta cesta;
	
	public CestaApi(@Context HttpServletRequest request) {
		cesta = (Cesta) request.getSession().getAttribute("cesta");
	}
	
	@GET
	@Path("cantidad")
	public Integer getCantidad() {
		return cesta.getCantidadArticulos();
	}
	
	@GET
	@Path("total")
	public BigDecimal getTotal() {
		return cesta.getTotal();
	}
	
	@PATCH
	@Path("{id}")
	public void actualizarCantidadArticulo(@PathParam("id") Long id, @QueryParam("cantidad") Integer cantidad) {
		cesta.cambiarCantidad(id, cantidad);
	}
}