<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/paciente" %>


 
<t:pacientepagestemplate>

	<jsp:attribute name="head">
		<title>Selección Fecha - DocApp</title>
		
	 
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script>
			var today = new Date().toISOString().split('T')[0];
			document.getElementsByName("fechacita")[0].setAttribute('min', today);
		</script>
		<script>
    		document.getElementById("selecFecha").onclick = function () {
    		var fechacita = document.getElementById("fechacita").value;
        	window.location.href = "HorarioServlet?fecha=" + fechacita;
    		};
		</script>
	</jsp:attribute>
	
	
	<jsp:body>
	   
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selección de Fecha de Cita</h1>
		</div>
		    <h2 class="text-center">Doctor/a ${medico.apellidos}</h2>
            <p>Comienza eligiendo la fecha para la cita.</p>
        
        	  <div class="fichadoctor">
        	  	<div class="row">       	  	
        	  		<div class="col-6">
        	  			<h4>Dr/a. ${medico.nombre} ${medico.apellidos}</h4>
        	  			<i class="fas fa-user-md"></i>
        	  			
        	  			<p><i>${medico.especialidad.nombre}</i></p>
        	  			
        	  			<button class="btn btn-lg btn-block btn-cita" id="selecFecha">Seleccionar fecha</button>
        	  		</div>
        	  		<div class="col-6">
        	  			 <div class="form-row mt-1 mb-2 pb-4 border-bottom">
					             <div class="col-12">
					                <label for="fechacita">Selecciona fecha:</label>
					                <input type="date" class="form-control" name="fechacita" id="fechacita">
					             </div>
					     </div>
					     <div class="form-row mt-1 mb-2 pb-4">
					             <div class="col-12 text-muted">
					                <label for="horacita">Selecciona hora:</label>
					                <select disabled name="horacita" id="horacita" class="form-control">
				        				<option value="" selected>Antes debe seleccionar una fecha</option>
				                    </select>

					             </div>
					     </div>
        	  		</div>
        	  		       	  	
        	  	</div>
        	  	
        	  </div>
          
        

	</jsp:body>

</t:pacientepagestemplate>