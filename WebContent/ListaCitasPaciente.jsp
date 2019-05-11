<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/paciente" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


 
<t:pacientepagestemplate>

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
            <p>Aquí se muestra un listado con tus citas pendientes.</p>
		<div class="table-responsive">
			  <table class="table table-striped table-sm" id="tabla">
				<thead class="bg-light">
					<tr>
						<th data-sort-method='none'>Cita</th>
						<th data-sort-method='none'>Médico</th>
						<th data-sort-default>Fecha</th>
						<th data-sort-method='none'>Hora</th>
						<th colspan="2" data-sort-method='none'>Acciones</th>
					</tr>
				</thead>
				<tbody>
				   
				   <c:if test="${empty paciente.citas }">
				    <tr data-sort-method='none'>
				    <td class="text-muted" style="padding-top:15px; font-style:italic"  align="center" colspan="6">No tienes citas pendientes</td>
				    </tr>
				   </c:if>
				   
				   <c:if test="${!empty paciente.citas }">
					   <c:forEach items="${paciente.citas}" var="cita">
							<tr>
								<td>${cita.medico.especialidad.nombre }</td>
								
								<td>${cita.medico.nombre } ${cita.medico.apellidos }</td>
								
								<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${cita.fecha}" /></td>
								
								<td><fmt:formatDate pattern = "HH:mm" value = "${cita.hora}" /></td>
								
								<td>
									<form action="ModificarCitaServlet" method="post">
									<input type ="hidden" name ="cita" value ="${cita.id}">
									<button type="submit" class="btn btn-info acciones-paciente">Modificar</button>
									</form>
								</td>
								
								<td>
									<form action="BorrarCitaServlet" method="post">
									<input type ="hidden" name ="cita" value ="${cita.id}">
									<button type="submit" class="btn btn-info acciones-paciente">Cancelar Cita</button>
									</form>
								</td>
								
							</tr>
						</c:forEach>
				   </c:if>	
				</tbody>
			</table>
		</div>
		
	</jsp:body>
	


</t:pacientepagestemplate>
   


