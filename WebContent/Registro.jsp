<html>
<body>
	<div class="cuerpo">

		<div class="row">
			<div class="col-md-12 titulo">
				<h1>Registro de Pacientes</h1>
			</div>
			<form action="RegistroPacienteServlet" method="post">
				<p>
					Nombre: <input type="text" name="nombre" />
				</p>
				<p>
					Apellidos: <input type="text" name="apellidos" />
				</p>
				<p>
					Email: <input type="text" name="email" />
				</p>
				<p>
					Password: <input type="password" name="password" />
				</p>
				<p>
					DNI: <input type="text" name="dni" />
				</p>
				<p>
					Telefono: <input type="text" name="telefono" />
				</p>
				<p>
					Sociedad médica: <input type="text" name="sociedad" />
				</p>
				<p>
					Tarjeta sanitaria: <input type="text" name="tarjeta" />
				</p>				
				<p>
					<button type="submit">Registrarse</button>
				</p>
			</form>
		</div>
</body>

</html>
