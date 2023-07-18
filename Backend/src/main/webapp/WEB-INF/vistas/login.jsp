<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="login" method="post">
	<div class="row mb-3">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="email" name="email"
				value="${email}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
		<div class="col-sm-10">
			<div class="input-group">
				<input type="password" class="form-control" id="password"
					name="password">
				<button id="mostrar-password" class="btn btn-outline-secondary"
					type="button" id="button-addon2">
					<i class="bi bi-eye"></i>
				</button>
			</div>
		</div>
	</div>
	<button type="submit" class="btn btn-primary">Login</button>
</form>

<script src="js/mostrar-password.js"></script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>