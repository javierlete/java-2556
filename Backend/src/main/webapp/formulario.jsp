<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.formacion.modelos.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>

<form action="formulario" method="post">
	<input type="text" name="nombre" placeholder="Nombre">
	<input type="number" step=".01" name="precio" placeholder="Precio">
	<input type="date" name="caducidad" placeholder="Caducidad">
	<button>Guardar</button>
</form>

</body>
</html>
