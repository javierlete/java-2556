<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saludo</title>
</head>
<body>

	<form action="hola-jsp" method="post">
		<input name="nombre" placeholder="Dime tu nombre">
		<input name="password" type="password">
		<button>Saludar</button>
		<%= request.getAttribute("saludo") %>
	</form>

</body>
</html>