<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


 
<t:pacientepagestemplate>

	<jsp:attribute name="head">
		<title>Selección Fecha - DocApp</title>
		
	 
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script>
			document.getElementById("confCita").onclick = function () {
    			var horacita = document.getElementById("horacita").value;
        		window.location.href = "GuardarCitaServlet?hora=" + horacita;
    		};
		</script>
	</jsp:attribute>
	
	
	<jsp:body>
	   
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selección de Fecha de Cita</h1>
		</div>
		    <h2 class="text-center">Doctor ${medico.apellidos}</h2>
            <p>Ahora elige una hora para la cita.</p>
        
        	  <div class="fichadoctor">
        	  	<div class="row">       	  	
        	  		<div class="col-6">
        	  			<h4>Dr. ${medico.nombre} ${medico.apellidos}</h4>
        	  			<i class="fas fa-user-md"></i>
        	  			
        	  			<p><i>${medico.especialidad.nombre}</i></p>
        	  			<button class="btn btn-lg btn-block btn-cita" id="confCita">Confirmar Cita</button>
        	  		
        	  		</div>
        	  		<div class="col-6">
        	  			 <div class="form-row mt-1 mb-2 pb-4 border-bottom">
					             <div class="col-12 text-muted">
					                <label for="fechacita">Selecciona fecha:</label>
					                <input disabled type="date" class="form-control" name="fechacita" id="fechacita" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${fecha}" />">
					             </div>
					     </div>
					     <div class="form-row mt-1 mb-2 pb-4">
					             <div class="col-12">
					                <label for="horacita">Selecciona hora:</label>
					                <select name="horacita" id="horacita" class="form-control">
				        				<option value="" selected>Selecciona...</option>
				        				<c:forEach items="${horario}" var="hora">
				        					<c:if test="${!hora.value}">
				        						<option value="${hora.key}" >${hora.key}</option>
				        					</c:if>
				        				</c:forEach>
				                    </select>

					             </div>
					     </div>
        	  		</div>
        	  		       	  	
        	  	</div>
        	  	
        	  </div>
          
        

	</jsp:body>

</t:pacientepagestemplate>