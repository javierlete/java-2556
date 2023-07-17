<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hover table-bordered table-striped">
	<thead class="table-dark">
		<tr>
			<th class="text-end">Id</th>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
			<th>Caducidad</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<th class="text-end">${p.id}</th>
				<td>${p.nombre}</td>
				<td class="text-end">
					<fmt:formatNumber type="currency" value="${p.precio}"></fmt:formatNumber>
				</td>
				<td>${p.caducidad}</td>
				<td>
					<a class="btn btn-sm btn-primary" href="admin/formulario?id=${p.id}">Editar</a>
					<a class="btn btn-sm btn-danger" href="admin/borrar?id=${p.id}">Borrar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<a class="btn btn-sm btn-primary" href="admin/formulario">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>