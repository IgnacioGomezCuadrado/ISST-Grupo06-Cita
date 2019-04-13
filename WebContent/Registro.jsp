<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:loginpagetemplate>

	<jsp:attribute name="head">
		<title>Registro - DocApp</title>
	<link rel="stylesheet"
				href="${pageContext.request.contextPath}/css/registro.css" />
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script>
			(function() {
			  'use strict';
			  window.addEventListener('load', function() {
			    // Fetch all the forms we want to apply custom Bootstrap validation styles to
			    var forms = document.getElementsByClassName('needs-validation');
			    // Loop over them and prevent submission
			    var validation = Array.prototype.filter.call(forms, function(form) {
			      
			    	form.addEventListener('submit', function(event) {
			    		
			    		document.getElementById('inputEmailCheck').className += " valid";
			    		document.getElementById('inputPasswordCheck').className += " valid";
			    		var emails_equal = (form.inputEmail.value !== "" || form.inputEmailCheck.value !== "") ?
			    			form.inputEmail.value === form.inputEmailCheck.value : false;
			    		var passwords_equal = (form.inputPassword.value !== "" || form.inputPasswordCheck.value !=="") ?
			    			form.inputPassword.value === form.inputPasswordCheck.value : false;
				    		
				        if (form.checkValidity() === false) {
				            if(!emails_equal){
				            	document.getElementById('inputEmailCheck').className += " invalid";
				            	document.getElementById('inputEmailCheck').nextElementSibling.className += " visible";
				            	}
			        	    if(!passwords_equal){
			        	    	document.getElementById('inputPasswordCheck').className += " invalid";
			        	    	document.getElementById('inputPasswordCheck').nextElementSibling.className += " visible";
			        	    	}
				            event.preventDefault();
				            event.stopPropagation();
				        }
				        else{
				        	if(!emails_equal || !passwords_equal){
				        		if(!emails_equal){
				        			document.getElementById('inputEmailCheck').className += " invalid";
				        			document.getElementById('inputEmailCheck').nextElementSibling.className += " visible";
				        		}
				        		if(!passwords_equal){
				        			document.getElementById('inputPasswordCheck').className += " invalid";
				        			 document.getElementById('inputPasswordCheck').nextElementSibling.className += " visible";
				        		}
				        		event.preventDefault();
						        event.stopPropagation();
				        		
				        	}
				        }
				        
				        form.classList.add('was-validated');
				        
			      }, false);
			    });
			  }, false);
			})();
		</script>
		<script src="${pageContext.request.contextPath}/js/theme_js.js"></script>
	</jsp:attribute>
	


	<jsp:body>

		<div class="row pt-5">
	      	<div class="col-sm-12 section-title">
	          	<h1 class="text-center my-auto">Registro de Pacientes</h1>
	      	</div>
	  	</div>
	  	
	  	<div class="card card-container">
	       <form class="form-signin needs-validation" novalidate action="RegistroServlet" method="post">
	            
	             <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-6">
	                <label for="nombre">Nombre</label>
	                <input type="text" name="nombre" id="inputNombre"
							class="form-control" placeholder="Introduce aquí tu nombre" required autofocus>
					<div class="invalid-feedback">Introduce tu nombre.</div>
					
	             </div>
	             <div class="col-sm-6">
	                <label for="apellidos">Apellidos</label>
	                <input type="text" name="apellidos" id="inputApellidos"
							class="form-control" placeholder="Introduce aquí tus apellidos" required>
					<div class="invalid-feedback">Introduce tus apellidos.</div>
	             </div>
	           </div> <!-- /row -->
	           
	           <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-6">
	                <label for="nombre">DNI</label>
	                <input type="text" maxlength=9 name="dni" id="inputDNI"
							class="form-control" placeholder="Introduce aquí tu DNI" required>
					<div class="invalid-feedback">Introduce un número de DNI válido.</div>
	             </div>
	             <div class="col-sm-6">
	                <label for="apellidos">Teléfono</label>
	                <input type="tel" maxlength=9 name="telefono" id="inputTelefono"
							class="form-control" placeholder="Introduce aquí tu teléfono" required>
					<div class="invalid-feedback">Introduce un número teléfono válido.</div>
	             </div>
	           </div> <!-- /row -->
	           
	            <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-6">
	                <label for="sociedad">Sociedad Médica</label>
	                <select name="sociedad" id="inputSociedad" class="form-control" required>
        				<option value="" selected>Selecciona...</option>
        				<t:sociedadesmedicas/>
                    </select>
                    <div class="invalid-feedback">Indica tu sociedad médica.</div>
                        
	             </div>
	             <div class="col-sm-6">
	                <label for="tarjeta">Número de Tarjeta Sanitaria</label>
	                <input type="number" name="tarjeta" id="inputTarjeta"
							class="form-control" placeholder="Número de Tarjeta Sanitaria" required>
					<div class="invalid-feedback">Indica tu número de tarjeta sanitaria</div>
	             </div>
	           </div> <!-- /row -->
	           
	           
	           <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-6">
	                <label for="email">Email</label>
	                <input type="email" name="email" id="inputEmail"
							class="form-control" placeholder="Dirección email" required>
					<div class="invalid-feedback">Introduce un email válido</div>
	             </div>
	             <div class="col-sm-6">
	                <label for="emailcheck">Repite Email</label>
	                <input type="email" name="emailcheck" id="inputEmailCheck"
							class="customformfield" placeholder="Repite el email">
					<div class="invalid-check">Los emails no coinciden</div>
	             </div>
	           </div> <!-- /row -->
	           
	            <div class="form-row">
	             <div class="col-sm-6">
	                <label for="password">Contraseña</label>
	                <input type="password" name="password" id="inputPassword"
							class="form-control" placeholder="Escribe aquí tu contraseña" required>
					<div class="invalid-feedback">Escribe una contraseña.</div>
	             </div>
	             <div class="col-sm-6">
	                <label for="passwordcheck">Repite Contraseña</label>
	                <input type="password" name="passwordcheck" id="inputPasswordCheck"
							class="customformfield" placeholder="Repite la contraseña">
					<div class="invalid-check">Las contraseñas no coinciden.</div>
	             </div>
	           </div> <!-- /row -->
	              
	          
	           <div class="row">
	               <div class="col-8 offset-2 col-sm-6 offset-sm-3">
	                 <button class="btn btn-lg btn-block btn-signin" type="submit">Registrarse</button>
	               </div>
	           </div> <!-- /row -->
	             
	       </form>
					<!-- /form -->
		 </div>


	</jsp:body>
	


</t:loginpagetemplate>


