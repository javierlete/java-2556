<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<main class="my-3 container">
	<div class="input-group mb-3">
		<input type="text" class="form-control"
			placeholder="Introduce la nueva tarea que quieres añadir">
		<button class="btn btn-primary" type="button">
			<i class="fs-3 bi bi-plus"></i>
		</button>
	</div>
	<ul class="list-unstyled">
		<li>
			<div class="input-group mb-3">
				<div class="input-group-text">
					<input class="fs-3 form-check-input mt-0" type="checkbox">
				</div>
				<input type="text" class="form-control"
					value="Tarea 1">
				<button class="btn btn-outline-secondary" type="button">
					<i class="fs-3 bi bi-pencil"></i>
				</button>
				<button class="btn btn-outline-danger" type="button">
					<i class="fs-3 bi bi-trash"></i>
				</button>
			</div>
		</li>
		<li>
			<div class="input-group mb-3">
				<div class="input-group-text">
					<input class="fs-3 form-check-input mt-0" type="checkbox" checked>
				</div>
				<input type="text" class="form-control text-decoration-line-through"
					value="Tarea 1">
				<button class="btn btn-outline-secondary" type="button">
					<i class="fs-3 bi bi-pencil"></i>
				</button>
				<button class="btn btn-outline-danger" type="button">
					<i class="fs-3 bi bi-trash"></i>
				</button>
			</div>
		</li>
	</ul>

</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>