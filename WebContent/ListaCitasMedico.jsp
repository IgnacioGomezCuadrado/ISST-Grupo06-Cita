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
	</jsp:attribute>
		
	
	<jsp:body>
	   
	    
	    
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
		        <h1 class="pacientestitle">Citas Pendientes</h1>
		</div>
            <p>Aquí se muestra un listado con sus citas pendientes de atender.</p>
		<div class="table-responsive">
			  <table class="table table-striped table-sm">
				<thead class="bg-light">
					<tr>
						<th>Fecha</th>
						<th>Hora</th>
						<th>Paciente</th>
						<th colspan="4">Acciones</th>
					</tr>
				</thead>
				<tbody>
				   			<tr>
								<td>DiaX</td>
								<td>HoraY</td>
								<td>Juan Pérez</td>
								<td><button type="button" class="btn btn-info acciones-paciente">Nueva Cita</button></td>
								<td><button type="button" class="btn btn-info acciones-paciente">Terminar Cita</button></td>
								<td><button type="button" class="btn btn-info acciones-paciente">Solicitar Prueba</button></td>
								<td><button type="button" class="btn btn-info acciones-paciente">Interconsulta</button></td>
								
							</tr>
				   <!--
				   <c:if test="${empty medico.citas }">
				    <tr>
				    <td class="text-muted" style="padding-top:15px; font-style:italic"  align="center" colspan="6">No tiene citas pendientes</td>
				    </tr>
				   </c:if>
				   
				   <c:if test="${!empty medico.citas }">
					   <c:forEach items="${medico.citas}" var="cita">
							<tr>
								<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${cita.fecha}" /></td>
								<td><fmt:formatDate pattern = "HH:mm" value = "${cita.hora}" /></td>
								<td>${cita.paciente.nombre } ${cita.paciente.apellidos }</td>
								<td><button type="button" class="btn btn-info acciones-paciente">Ver historial</button></td>
								<td><a href="ModificarCitaServlet?idMedico=${medico.email}&idPaciente=${cita.paciente.email}"><button type="button" class="btn btn-info acciones-paciente">Nueva Cita</button></a></td>
								<td><a href="InterconsultaServlet?idPaciente=${cita.paciente.email}"><button type="button" class="btn btn-info acciones-paciente">Interconsulta</button></a></td>
							</tr>
						</c:forEach>
				   </c:if>
				   -->	
				</tbody>
			</table>
		</div>
		
	</jsp:body>

</t:medicopagestemplate>
   


