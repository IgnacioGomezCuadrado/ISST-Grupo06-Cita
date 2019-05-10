<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/pas" %>


 
<t:paspagestemplate>

	<jsp:attribute name="head">
		<title>Citas Pendientes - DocApp</title>
	</jsp:attribute>
		
	
	<jsp:body>
	   
	    
	    
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
		        <h1 class="pacientestitle">Buscador de Citas</h1>
		</div>
            <p>Halla las citas deseadas mediante el buscador:</p>
		
		<div class="card">
		  <div class="card-body">
	       <form class="form-signin" action="" method="post">
	            
	            <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-4">
	                <label for="nombre">Paciente</label>
	                <input type="text" name="nombre" id="inputNombre"
							class="form-control" placeholder="Introduce aquí tu nombre" autofocus>
	             </div>
	             <div class="col-sm-4">
	                <label for="sociedad">Especialidad</label>
	                <select name="sociedad" id="inputSociedad" class="form-control">
        				<option value="" selected>Especialidad...</option>
                    </select>
	             </div>
	              <div class="col-sm-4">
	                <label for="sociedad">Doctor</label>
	                <select name="sociedad" id="inputSociedad" class="form-control" required>
        				<option value="" selected>Doctor...</option>
                    </select>
	              </div>
	             </div> <!-- /row -->
	             
	            <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-4">
	                <label for="sociedad">Doctor</label>
	                <select name="sociedad" id="inputSociedad" class="form-control">
        				<option value="" selected>Fecha...</option>
                    </select>
	             </div>
	             <div class="col-sm-4">
	                <label for="apellidos">Hora</label>
	               <label for="sociedad">Doctor</label>
	                <select name="sociedad" id="inputSociedad" class="form-control" required>
        				<option value="" selected>Hora...</option>
                    </select>
	             </div>
	              <div class="col-sm-4">
	                <button class="btn btn-block btn-signin" type="submit">Buscar</button>
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
					<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><a href="#"><button type="button" class="btn btn-info acciones-paciente">Modificar</button></a></td>
								<td><a href="#"><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></a></td>
							</tr>
				
				   <!--  
				   <c:if test="${empty paciente.citas }">
				    <tr>
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
								<td><a href="ModificarCitaServlet?cita=${cita.id}"><button type="button" class="btn btn-info acciones-paciente">Modificar</button></a></td>
								<td><a href="BorrarCitaServlet?cita=${cita.id}"><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></a></td>
							</tr>
						</c:forEach>
				   </c:if>	-->
				</tbody>
			</table>
		</div>
		
	</jsp:body>

</t:paspagestemplate>
   