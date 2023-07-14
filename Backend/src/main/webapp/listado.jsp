<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.formacion.modelos.*, java.util.List" %>
<%
Object o = request.getAttribute("productos");

System.out.println(o);

List<Producto> productos = (List<Producto>)o;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Caducidad</th>
		</tr>
	</thead>
	<tbody>
		<% for(Producto producto: productos) { %>
		<tr>
			<th><%= producto.getId() %></th>
			<td><%= producto.getNombre() %></td>
			<td><%= producto.getPrecio() %></td>
			<td><%= producto.getCaducidad() %></td>
		</tr>
		<% } %>
	</tbody>
</table>

</body>
</html>
