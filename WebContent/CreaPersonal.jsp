<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

MEDICO
<form action="CrearPersonalServlet" method="POST">
	Nombre<input type="text" name="nombre"></input>
	Apellidos<input type="text" name ="apellidos"></input>
	Email<input type="text" name ="email"></input>
	Password<input type="password" name="pass"></input>
	<input type="hidden" name="personaltype" value="0">
	<button type="submit">Crear Médico</button>
</form>

PAS
<form action="CrearPersonalServlet" method="POST">
	Nombre<input type="text" name="nombre"></input>
	Apellidos<input type="text" name ="apellidos"></input>
	Email<input type="text" name ="email"></input>
	Password<input type="password" name="pass"></input>
	<input type="hidden" name="personaltype" value="1">
	<button type="submit">Crear PAS</button>
</form>

</body>
</html>