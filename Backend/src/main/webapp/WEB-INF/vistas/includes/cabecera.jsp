<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<fmt:setLocale value="es-ES"></fmt:setLocale>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Tienda</title>
<base href="${pageContext.request.contextPath}/">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark border-bottom border-bottom-dark" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Tienda</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link" href="index">Principal</a></li>
				</ul>
				<ul class="navbar-nav">
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
	<main class="my-3 container">