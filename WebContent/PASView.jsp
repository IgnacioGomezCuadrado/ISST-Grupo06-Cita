<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/pas" %>


 
<t:paspagestemplate>

	<jsp:attribute name="head">
		<title>Buscador de Citas - DocApp</title>
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="${pageContext.request.contextPath}/js/jquery.autocomplete.js"></script>
		<script>
		var patients = ${pacientes};
		$('#inputPaciente').devbridgeAutocomplete({
		    lookup: patients,
		    onSelect: function (suggestion) {
		       document.getElementById("mailPaciente").value = suggestion.data;
		      // console.log('You selected: ' + suggestion.value + ', ' + suggestion.data);
		    }
		});
			var today = new Date().toISOString().split('T')[0];
			document.getElementsByName("fechacita")[0].setAttribute('min', today);
		</script>
	</jsp:attribute>
		
	
	<jsp:body>
	   
	    
	    
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
		        <h1 class="pacientestitle">Buscador de Citas</h1>
		</div>
            <p>Halla las citas deseadas mediante el buscador:</p>
		
		<div class="card">
		  <div class="card-body">
	       <form class="form-signin" action="FormularioServlet" method="post">
	            
	            <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-4">
	                <label for="nombre">Paciente</label>
	                <input type="text" name="paciente" id="inputPaciente"
							class="form-control" placeholder="Nombre y apellidos" autocomplete="off" autofocus>
							<input type="hidden" name="mailpaciente" id="mailPaciente" value="">
	             </div>
	             <div class="col-sm-4">
	                <label for="medico">Doctor</label>
	                <select name="mailmedico" id="inputMedico" class="form-control">
        				<option value="" selected>Doctor...</option>
        				<c:forEach items="${medicos}" var="medico">
        					<option value="${medico.email}">${medico.nombre} ${medico.apellidos}</option>
        				</c:forEach>
                    </select>
	             </div>
	              <div class="col-sm-4">
	                  <label for="fechacita">Fecha</label>
	                  	<input type="date" class="form-control" name="fechacita" id="fechacita">
	              </div>
	             </div> <!-- /row -->
	             
	            <div class="form-row mt-1 mb-2">
	              <div class="col-sm-3 offset-5 align-self-center">
	                <button class="btn btn-block btn-signin w-50" type="submit">Buscar</button>
	              </div>
	             </div> <!-- /row -->
	                   
	       </form>
					<!-- /form -->
		 </div>
	  </div>
		
		
		<div class="table-responsive">
			  <table class="table table-striped table-sm">
				<thead class="bg-light">
					<tr>
						<th>Cita</th>
						<th>Paciente</th>
						<th>Médico</th>
						<th>Fecha</th>
						<th>Hora</th>
						<th colspan="2">Acciones</th>
					</tr>
				</thead>
				<tbody>  
				   <c:if test="${empty citas }">
				    <tr>
				    <td class="text-muted" style="padding-top:15px; font-style:italic"  align="center" colspan="6">Rellena al menos un campo para solicitar resultados</td>
				    </tr>
				   </c:if>
				   <c:if test="${!empty citas }">
					   <c:forEach items="${citas}" var="cita">
							<tr>
								<td>${cita.medico.especialidad.nombre}</td>
								<td>${cita.paciente.nombre} ${cita.paciente.apellidos}</td>
								<td>${cita.medico.nombre} ${cita.medico.apellidos}</td>
								<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${cita.fecha}" /></td>
								<td><fmt:formatDate pattern = "HH:mm" value = "${cita.hora}" /></td>
								<td>
								<form action="ModificarCitaPASServlet" method="post">
								<input type ="hidden" name ="cita" value ="${cita.id}">
								<input type ="hidden" name ="idPaciente" value ="${cita.paciente.email}">
								<button type="submit" class="btn btn-info acciones-paciente">Modificar</button>
								
								</form>
								</td>
								<td>
								<form action="BorrarCitaPASServlet" method="post">
								<input type ="hidden" name ="cita" value ="${cita.id}">
								<button type="submit" class="btn btn-info acciones-paciente">Cancelar</button>
								</form>
								</td>
							</tr>
						</c:forEach>
				   </c:if>
				</tbody>
			</table>
		</div>
		
	</jsp:body>

</t:paspagestemplate>
   