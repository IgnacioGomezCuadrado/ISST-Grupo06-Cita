<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/medico" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


 
<t:medicopagestemplate>

	<jsp:attribute name="head">
		<title>Citas Pendientes - DocApp</title>
		 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tablesort.css" />
	</jsp:attribute>
	<jsp:attribute name="scripts">
		<script src="${pageContext.request.contextPath}/js/tablesort.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/tablesort.date.min.js"></script>
		<script>
  			new Tablesort(document.getElementById('tabla'));
		</script>
	</jsp:attribute>
		
	
	<jsp:body>
	   
	    
	    
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
		        <h1 class="pacientestitle">Citas Pendientes</h1>
		</div>
            <p>Aquí se muestra un listado con sus citas pendientes de atender.</p>
		<div class="table-responsive">
			  <table class="table table-striped table-sm" id="tabla">
				<thead class="bg-light">
					<tr>
						<th data-sort-default>Fecha</th>
						<th data-sort-method='none'>Hora</th>
						<th data-sort-method='none'>Paciente</th>
						<th colspan="4" data-sort-method='none'>Acciones</th>
					</tr>
				</thead>
				<tbody>
				   <c:if test="${empty medicomismo.citas }">
				    <tr>
				    <td class="text-muted" style="padding-top:15px; font-style:italic"  align="center" colspan="6">No tiene citas pendientes</td>
				    </tr>
				   </c:if>
				   
				   <c:if test="${!empty medicomismo.citas }">
					   <c:forEach items="${medicomismo.citas}" var="cita">
							<tr>
								
								<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${cita.fecha}" /></td>
								
								<td><fmt:formatDate pattern = "HH:mm" value = "${cita.hora}" /></td>
								
								<td>${cita.paciente.nombre } ${cita.paciente.apellidos }</td>
								
								<td>
									<form action="CitaMedicoServlet" method="get">
									<input type="hidden" name="idMedico" value="${medicomismo.email }">
									<input type ="hidden" name ="idPaciente" value ="${cita.paciente.email }">
									<button type="submit" class="btn btn-info acciones-paciente">Nueva Cita</button>
									</form>
								</td>
								
								<td><button type="button" class="btn btn-info acciones-paciente" data-toggle="modal" data-target="#pruebamedica">Solicitar Prueba</button></td>
								
								<td>
									<form action="InterconsultaServlet" method="get">
									<input type ="hidden" name ="idPaciente" value ="${cita.paciente.email }">
									<button type="submit" class="btn btn-info acciones-paciente">Interconsulta</button>
									</form>
								</td>
								
								<td><button type="button" class="btn btn-info acciones-paciente">Ver historial</button></td>
								
							</tr>
						</c:forEach>
				   </c:if>
				   
				</tbody>
			</table>
		</div>
		
		
		
		<!-- Modal -->
			<div class="modal fade" id="pruebamedica" tabindex="-1" role="dialog" aria-labelledby="pruebamedica" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Solicitud de prueba diagnóstica médica</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
							  <div class="form-group">
							    <label for="pruebamedica">Detalles de la solicitud:</label>
							    <textarea class="form-control" id="pruebamedica" rows="3"></textarea>
							  </div>
							</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-primary" data-dismiss="modal">Confirmar</button>
			      </div>
			    </div>
			  </div>
			</div>
		
	</jsp:body>

</t:medicopagestemplate>
   


