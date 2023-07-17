<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/formulario" method="post">
	<input type="hidden" name="id" value="${producto.id}">
	<div>
		<label class="form-label" for="nombre">Nombre</label> <input
			class="form-control" type="text" id="nombre" name="nombre" placeholder="Nombre" value="${producto.nombre}">
	</div>
	<div>
		<label class="form-label" for="precio">Precio</label> <input
			class="form-control" type="number" step=".01" id="precio" name="precio" placeholder="Precio" value="${producto.precio}">
	</div>
	<div>
		<label class="form-label" for="caducidad">Caducidad</label> <input
			class="form-control" type="date" name="caducidad" id="caducidad" placeholder="Caducidad" value="${producto.caducidad}">
	</div>
	<div>
		<button class="btn btn-primary mt-3">Guardar</button>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>