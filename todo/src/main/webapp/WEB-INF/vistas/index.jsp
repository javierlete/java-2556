<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<main class="my-3 container">
	<form action="nueva-tarea" class="input-group mb-3" method="post">
		<input type="text" class="form-control" name="texto"
			placeholder="Introduce la nueva tarea que quieres añadir">
		<button class="btn btn-primary">
			<i class="fs-3 bi bi-plus"></i>
		</button>
	</form>
	
	<ul class="list-unstyled">
		<c:forEach items="${tareas}" var="t">
			<li>
				<form action="modificar-tarea" method="post" class="input-group mb-3">
					<input type="hidden" name="id" value="${t.id}">
					
					<div class="input-group-text">
						<input name="terminada" class="fs-3 form-check-input mt-0" type="checkbox" ${t.terminada ? 'checked': ''}>
					</div>
					<input type="text" name="texto" class="form-control ${t.terminada ? 'text-decoration-line-through': ''}" value="${t.texto}">
					<button class="btn btn-outline-secondary">
						<i class="fs-3 bi bi-pencil"></i>
					</button>
					<a href="borrar-tarea?id=${t.id}" class="btn btn-outline-danger">
						<i class="fs-3 bi bi-trash"></i>
					</a>
				</form>
			</li>
		</c:forEach>
	</ul>

</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>