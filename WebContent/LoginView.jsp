<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DocApp</title>
</head>
<body>
	<shiro:user>
    Welcome back <shiro:principal />! Click <a href="LogoutServlet">here</a> to logout.
    <hr>
	</shiro:user>
	<shiro:guest>

		<section id="Principio">
			<a class="navbar-brand"><img src="images/Logo.jpg"
				class="img-responsive" style="width: 140px; margin-top: -16px;"></a>

			<h1>DOCAPP</h1>
			<p>Una forma óptima de gestionar todas tus citas médicas</p>
			<a href="#login">Acceder</a>

		</section>


		<section id="login">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-sm-4">
						<h2 class="title">Iniciar Sesión</h2>
						<form action="LoginServlet">
							<div class="form-group">
								<input type="text" name="email" placeholder="email" /> <input
									type="password" name="password" placeholder="password" />
							</div>
							<button type="submit">Login</button>
							<a href="ResetPassword.jsp"> ¿Olvidó la contraseña?</a>

							<h3>¿No tienes cuenta?</h3>
							<a href="">Regístrate</a>
						</form>
					</div>
		</section>
	</shiro:guest>

</body>
</html>
