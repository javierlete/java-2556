<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES"></fmt:setLocale>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Tienda</title>
<base href="${pageContext.request.contextPath}/">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-icons.min.css">
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<header class="d-flex align-items-center text-bg-dark">
		<a class="btn text-white fs-3 fw-bold" href="#">Amazonia</a> <a
			class="btn text-white" href="#"> <i class="bi bi-geo-alt"></i>
			Hola<br /> <span class="fw-bold">Elige&nbsp;tu&nbsp;direccion</span>
		</a>
		<div class="input-group">
			<select class="form-select bg-secondary-subtle"
				id="inputGroupSelect04"
				aria-label="Example select with button addon">
				<option selected>Todos los departamentos</option>
				<option value="1">One</option>
				<option value="2">Two</option>
				<option value="3">Three</option>
			</select> <input type="text" class="form-control"
				aria-label="Text input with 2 dropdown buttons"
				placeholder="Buscar amazonia">
			<button class="btn btn-warning" type="button" aria-expanded="false">
				<i class="bi bi-search fs-5"></i>
			</button>
		</div>
		<div>
			<a class="btn text-white fw-bold d-flex" data-bs-toggle="collapse"
				href="#collapseExample" role="button" aria-expanded="false"
				aria-controls="collapseExample"> <img src="imgs/spain.png">ES<i
				class="bi bi-caret-down-fill"></i>
			</a>
			<div class="collapse position-absolute" style="z-index: 2000"
				id="collapseExample">
				<div class="card card-body">
					<ul class="list-group list-group-flush">
						<li class="list-group-item">An item</li>
						<li class="list-group-item">A second item</li>
						<li class="list-group-item">A third item</li>
						<li class="list-group-item">A fourth item</li>
						<li class="list-group-item">And a fifth one</li>
					</ul>
				</div>
			</div>
		</div>
		<a class="btn text-white" href="#">Hola,&nbsp;identifícate<br />
			<span class="fw-bold d-flex">Cuenta&nbsp;y&nbsp;listas<i
				class="bi bi-caret-down-fill"></i></span>
		</a> <a class="btn text-white" href="#"> Devoluciones<br /> <span
			class="fw-bold">y Pedidos</span>
		</a> <a class="btn text-white fw-bold d-flex align-items-center" href="#">
			<i class="bi bi-cart fs-1"></i> Cesta
		</a>
	</header>

	<nav class="navbar bg-primary border-bottom border-bottom-dark"
		data-bs-theme="dark">
		<div class="container-fluid justify-content-start">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
				aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="d-flex align-items-center flex-grow-1"
				id="navbarSupportedContent">
				<ul class="navbar-nav me-auto flex-row p-1">
					<li class="nav-item"><a class="nav-link" href="index">Principal</a></li>
				</ul>
				<ul class="navbar-nav flex-row p-1">
					<li class="navbar-text">${usuario}</li>

					<c:if test="${usuario == null }">
						<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					</c:if>

					<c:if test="${usuario != null }">
						<li class="nav-item"><a class="nav-link" href="admin/index">Administración</a></li>
						<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<div class="offcanvas offcanvas-start" tabindex="-1"
		id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel"
		data-bs-theme="light">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasNavbarLabel">Offcanvas</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
				aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>

			</ul>
		</div>
	</div>
	<nav class="opciones-claras border-bottom bg-secondary-subtle py-1">
		<ul class="d-flex justify-content-left list-unstyled m-0">
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
		</ul>
	</nav>
	<nav class="opciones-claras border-bottom pt-3">
		<ul class="d-flex justify-content-left list-unstyled m-0">
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
			<li class="px-2"><a
				class="text-dark link-underline-warning link-offset-3-hover link-underline-opacity-0 link-underline-opacity-100-hover fw-bold"
				href="#">&nbsp;&nbsp;Opción&nbsp;&nbsp;</a></li>
		</ul>
	</nav>
	<c:if test="${error != null}">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			${error}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<main class="my-3 container">